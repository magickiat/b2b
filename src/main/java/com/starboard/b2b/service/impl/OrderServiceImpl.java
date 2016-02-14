package com.starboard.b2b.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.OrderStatusConfig;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.OrderAddressDao;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.OrderStatusDao;
import com.starboard.b2b.dao.OrdersIdRunningDao;
import com.starboard.b2b.dao.PaymentMethodDao;
import com.starboard.b2b.dao.PaymentTermDao;
import com.starboard.b2b.dao.ShippingTypeDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dto.CustPriceGroupDTO;
import com.starboard.b2b.dto.OrdAddressDTO;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.PaymentTermDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ShippingTypeDTO;
import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.dto.SoDetailDTO;
import com.starboard.b2b.dto.UserDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.OrderStatus;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.So;
import com.starboard.b2b.model.SoDetail;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.order.OrderDecisionForm;
import com.starboard.b2b.web.form.order.OrderSummaryForm;
import java.lang.reflect.Type;
import java.math.BigDecimal;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private ApplicationConfig applicationConfig;

    @Autowired
    private ShippingTypeDao shippingTypeDao;

    @Autowired
    private PaymentMethodDao paymentMethodDao;

    @Autowired
    private PaymentTermDao paymentTermDao;

    @Autowired
    private OrdersIdRunningDao ordersIdRunningDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderAddressDao orderAddressDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private AddrDao addrDao;

    @Autowired
    private OrderStatusDao orderStatusDao;

    @Autowired
    private SoDao soDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Override
    @Transactional(readOnly = true)
    public List<SoDTO> listSO(long orderId) {
        return soDao.findByOrderId(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShippingTypeDTO> findAllShippingType() {
        return shippingTypeDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentMethodDTO> findAllPaymentMethod() {
        return paymentMethodDao.list();
    }

    // ----- Generate Order Code [RO-Year-Running] -----
    @Override
    @Transactional
    public String generateOrderCode() {
        int year = DateTimeUtil.getCurrentYear();
        long orderRunningNo = getNextRunningNo(year);
        String runingNo = "" + orderRunningNo;
        int size = runingNo.length() <= 4 ? 4 : runingNo.length();
        String strRunningNo = StringUtils.leftPad(runingNo, size, "0");
        return String.format("RO-%d-%s", year, strRunningNo);
    }

    @Override
    @Transactional
    public OrderDTO newOrder(Long invoiceTo, Long dispatchTo, String shippingType, String customerRemark, String paymentMethod,
            Map<Long, ProductDTO> cart) {
        Addr invoiceToAddr = addrDao.findById(invoiceTo);
        if (invoiceToAddr == null) {
            throw new IllegalArgumentException("Address 'Invoice To' is required");
        }

        Addr dispatchToAddr = addrDao.findById(dispatchTo);
        if (dispatchToAddr == null) {
            throw new IllegalArgumentException("Address 'Dispatch To' is required");
        }

        Entry<Long, ProductDTO> firstProduct = cart.entrySet().iterator().next();
        long brandGroupId = firstProduct.getValue().getProductTypeId();

        // Save Order
        String orderCode = generateOrderCode();
        log.info("\tGenerated orderCode = " + orderCode);

        Date currentDate = DateTimeUtil.getCurrentDate();
        User user = UserUtil.getCurrentUser();

        Orders order = new Orders();
        order.setCustId(user.getCustomer().getCustId());
        order.setCustCode(user.getCustomer().getCustCode());
        order.setCustUserId("" + user.getId());
        order.setOrderCode(orderCode);
        order.setOrderStatus(applicationConfig.getOrderStatusNew());
        order.setOrderDate(currentDate);
        order.setBrandGroupId(brandGroupId);
        order.setShippingId(shippingType);
        order.setPaymentMethodId(paymentMethod);
        order.setPaymentCurrencyId(user.getCustomer().getCurrency());
        order.setPaymentTermId(applicationConfig.getNewOrderPaymentTermId());
        order.setRemarkCustomer(customerRemark);
        order.setTimeCreate(currentDate);
        order.setUserCreate(user.getUsername());
        order.setTimeUpdate(currentDate);

        long orderId = orderDao.save(order);

        CustPriceGroupDTO custPriceGroup = customerService.findCustPriceGroup(user.getCustomer().getCustCode(), brandGroupId);

        // Save Order Detail
        Set<Long> keySet = cart.keySet();
        for (Long key : keySet) {
            ProductDTO product = cart.get(key);
            // Default currency
            if (StringUtils.isEmpty(product.getProductCurrency())) {
                product.setProductCurrency(applicationConfig.getDefaultProductCurrency());
            }
            // Default product unit id
            if (StringUtils.isEmpty(product.getProductUnitId())) {
                product.setProductUnitId(applicationConfig.getDefaultProductUnit());
            }

            // ----- Create order -----
            OrdDetail orderDetail = new OrdDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setProductId(product.getProductId());
            orderDetail.setAmount(product.getProductQuantity());
            orderDetail.setStatus(applicationConfig.getDefaultOrderDetailStatus());
            orderDetail.setProductCurrency(product.getProductCurrency());
            orderDetail.setProductUnitId(product.getProductUnitId());
            if (product.getProductPrice() != null && product.getProductPrice().intValue() >= 0) {
                orderDetail.setPrice(product.getProductPrice());
            }
            orderDetail.setProductBuyerGroupId(custPriceGroup.getProductBuyerGroupId());
            orderDetail.setUserCreate(user.getUsername());
            orderDetail.setTimeCreate(currentDate);
            orderDetail.setTimeUpdate(currentDate);

            orderDetailDao.save(orderDetail);
        }

        // Save Order address
        orderAddressDao.save(createOrderAddress(invoiceToAddr, orderId, AddressConstant.ORDER_INVOICE_TO));
        orderAddressDao.save(createOrderAddress(dispatchToAddr, orderId, AddressConstant.ORDER_DISPATCH_TO));

        // For generate report
        OrderDTO dto = new OrderDTO();
        dto.setOrderId(orderId);
        dto.setOrderCode(orderCode);
        return dto;
    }

    public OrdAddress createOrderAddress(Addr addr, Long orderId, Long addressType) {
        OrdAddress address = new OrdAddress();
        address.setOrderId(orderId);
        address.setOrderAddr(addr.getAddress());
        address.setOrderTel(addr.getTel1());
        address.setFax(addr.getFax());
        address.setEmail(addr.getEmail());
        address.setType(addressType);
        address.setOrderFname("");
        address.setOrderLname("");
        return address;
    }

    @Override
    @Transactional
    public long getNextRunningNo(int year) {
        return ordersIdRunningDao.generateRunning(year);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDTO findOrder(Long orderId) {
        if (orderId != null) {
            Orders order = orderDao.findById(orderId);
            OrderDTO dto = new OrderDTO();
            BeanUtils.copyProperties(order, dto);
            return dto;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchOrderDetailDTO> searchOrderDetail(Long orderId) {
        return orderDetailDao.searchOrderDetail(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchOrderDetailDTO> searchOrderDetail(String orderCode) {
        return orderDetailDao.searchOrderDetail(orderCode);
    }

    @Override
    @Transactional(readOnly = true)
    public SearchOrderDTO findOrderForReport(Long orderId) {
        return orderDao.findOrderForReport(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public SearchOrderDTO findOrderForReport(String orderCode) {
        return orderDao.findOrderForReport(orderCode);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrdAddressDTO> findOrderAddress(final String orderCode) {
        List<OrdAddress> ordAddresses = orderDao.findOrderAddress(orderCode);
        List<OrdAddressDTO> ordAddressDTOs = new ArrayList<>();
        if (ordAddresses != null && !ordAddresses.isEmpty()) {
            for (OrdAddress ordAddress : ordAddresses) {
                OrdAddressDTO ordAddressDTO = new OrdAddressDTO();
                BeanUtils.copyProperties(ordAddress, ordAddressDTO);
                ordAddressDTOs.add(ordAddressDTO);
            }
        }
        return ordAddressDTOs;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderStatusDTO> findAllOrderStatus() {
        final List<OrderStatusDTO> orderStatuses = new ArrayList<>();
        for (OrderStatus status : orderStatusDao.findAll()) {
            final OrderStatusDTO orderStatus = new OrderStatusDTO();
            BeanUtils.copyProperties(status, orderStatus);
            orderStatuses.add(orderStatus);
        }
        return orderStatuses;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SearchOrderDTO> searchOrder(final OrderSummaryForm orderSummaryForm) {
        log.info("Search order summary form: {}", orderSummaryForm);
        final SearchRequest<OrderSummaryForm> req = new SearchRequest<>(orderSummaryForm.getPage(), applicationConfig.getPageSize());
        req.setCondition(orderSummaryForm);

        // Find product model
        final SearchResult<SearchOrderDTO> result = orderDao.search(req);

        // Validate has image exist
        final List<SearchOrderDTO> resultList = result.getResult();
        log.info("resultList size: {}", (resultList == null ? 0 : resultList.size()));

        // create result page object
        final Page<SearchOrderDTO> page = new Page<>();
        page.setCurrent(orderSummaryForm.getPage());
        log.info("current page: {}", page.getCurrent());
        page.setPageSize(req.getPageSize());
        page.setTotal(result.getTotal());
        page.setResult(result.getResult());
        return page;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findAllOrderCurrency(Long orderId) {
        return orderDetailDao.findAllOrderCurrency(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchOrderDTO> findOrderForReport(Long[] ordersId) {
        return orderDao.findOrderForReport(ordersId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchOrderDetailDTO> searchOrderDetail(Long[] ordersId) {
        return orderDetailDao.searchOrderDetail(ordersId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchOrderDTO> searchOrderForReport(OrderSummaryForm orderSummaryForm) {
        return orderDao.searchOrderSummaryForReport(orderSummaryForm);
    }

    @Override
    @Transactional(readOnly = true)
    public SoDTO findSO(long soId) {
        So so = orderDao.findSoById(soId);
        SoDTO dto = new SoDTO();
        BeanUtils.copyProperties(so, dto);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SoDetailDTO> findSoDetail(long soId) {
        List<SoDetail> so = orderDao.findSoDetailBySoId(soId);
        List<SoDetailDTO> soDTOs = new ArrayList<>();
        if (so != null && !so.isEmpty()) {
            SoDetailDTO dto = new SoDetailDTO();
            BeanUtils.copyProperties(so, dto);
            soDTOs.add(dto);
        }
        return soDTOs;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentTermDTO> findAllPaymentTerm() {
        return paymentTermDao.list();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findUserByOrderCode(String orderCode) {
        User user = orderDao.findUserByOrderCode(orderCode);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        return userDTO;
    }

    @Override
    @Transactional
    public void approve(OrderDTO orderDTO) {
        if (orderDTO == null) {
            throw new B2BException("Order is required");
        }

        log.info("orderId = " + orderDTO.getOrderId());

        Orders order = orderDao.findById(orderDTO.getOrderId());
        if (order == null) {
            throw new B2BException("Not found this order id: " + orderDTO.getOrderId());
        }

        Date expectShipDate = DateTimeUtil.generateExpectShipDate();

        order.setExpectReceiptDate(expectShipDate);
        order.setExpectShipmentDate(expectShipDate);
        order.setOrderStatus(OrderStatusConfig.APPROVED);
    }

    @Override
    public void reject(OrderDTO orderDTO) {
        if (orderDTO == null) {
            throw new B2BException("Order is required");
        }

        log.info("orderId = " + orderDTO.getOrderId());

        Orders order = orderDao.findById(orderDTO.getOrderId());
        if (order == null) {
            throw new B2BException("Not found this order id: " + orderDTO.getOrderId());
        }

        order.setOrderStatus(OrderStatusConfig.CANCELED);
    }

    @Override
    @Transactional
    public void updateOrder(OrderDecisionForm form) {
        if (form.getOrderReport().getOrderId() == null) {
            throw new B2BException("order id not specify");
        }
        //
        Orders order = orderDao.findById(form.getOrderReport().getOrderId());
        order.setPaymentTermId(form.getOrderReport().getPaymentTermId());
        order.setPaymentMethodId(form.getOrderReport().getPaymentMethod());
        order.setRemarkCustomer(form.getOrderReport().getRemarkCustomer());
        //
        Type type = new TypeToken<List<Map<String, Object>>>() {
        }.getType();
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
        Date currentDate = DateTimeUtil.getCurrentDate();
        User user = UserUtil.getCurrentUser();
        //
        orderDetailDao.purge(form.getOrderReport().getOrderId());
        //
        List<Map<String, Object>> splits = gson.fromJson(form.getSplitItems(), type);
        for (Map<String, Object> split : splits) {
            if (split.get("ProductID") == null) {
                continue;
            }
            String ProductID = String.class.cast(split.get("ProductID"));
            String ProductUnit = String.class.cast(split.get("ProductUnit"));
            String ProductCurrency = String.class.cast(split.get("ProductCurrency"));
            Double Amount = Double.class.cast(split.get("Amount"));
            Double Price = Double.class.cast(split.get("Price"));
            String BuyerGroupID = String.class.cast(split.get("BuyerGroupID"));
            //
            OrdDetail orderDetail = new OrdDetail();
            orderDetail.setOrderId(form.getOrderReport().getOrderId());
            orderDetail.setProductId(Long.parseLong(ProductID));
            orderDetail.setAmount(Amount.longValue());
            orderDetail.setStatus(applicationConfig.getDefaultOrderDetailStatus());
            orderDetail.setProductCurrency(ProductCurrency);
            orderDetail.setProductUnitId(ProductUnit);
            orderDetail.setPrice(new BigDecimal(Price));
            orderDetail.setProductBuyerGroupId(BuyerGroupID);
            orderDetail.setUserCreate(user.getUsername());
            orderDetail.setTimeCreate(currentDate);
            orderDetail.setTimeUpdate(currentDate);
            //
            orderDetailDao.save(orderDetail);
        }
    }

}
