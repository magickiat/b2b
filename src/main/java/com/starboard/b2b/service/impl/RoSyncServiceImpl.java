package com.starboard.b2b.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.dto.search.SearchOrderDetailReportResult;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.RoSyncService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.CurrencyUtils;

@Service("roSyncService")
public class RoSyncServiceImpl implements RoSyncService {

	@Autowired
	private ApplicationConfig applicationConfig;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private OrderDao orderDao;

//	@Autowired
//	private TmpRoDao tmpRoDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncProduct() {
		throw new UnsupportedOperationException("Not implement yet");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncRoFromB2BtoAX(long orderId) {
		List<SearchOrderDetailReportResult> list = orderDetailDao.findOrderDetailByOrderId(orderId);
		if (list != null && !list.isEmpty()) {
			Orders ord = orderDao.findById(orderId);
			User orderUser = userDao.findByUsername(ord.getUserCreate());
			String saleId = orderUser.getCustomer().getSaleId();
			Orders order = orderDao.findById(orderId);
			for (SearchOrderDetailReportResult ordDetail : list) {
//				TmpRo tmpRo = createTmpRO(order, ordDetail);
//				tmpRo.setSalesId(saleId);
//				tmpRoDao.save(tmpRo);
			}
		}
	}

//	private TmpRo createTmpRO(Orders ord, SearchOrderDetailReportResult ordDetail) {
//		TmpRo tmpRo = new TmpRo();
//		tmpRo.setOrderProductId(ordDetail.getOrderDetailId());
//		setTmpRo(ord, ordDetail, tmpRo);
//		return tmpRo;
//	}

//	public void setTmpRo(Orders ord, SearchOrderDetailReportResult ordDetail, TmpRo tmpRo) {
//		tmpRo.setOrderId(ordDetail.getOrderId());
//		tmpRo.setRoNumber(ord.getOrderCode());
//		tmpRo.setProductId(ordDetail.getProductId());
//
//		tmpRo.setItemId(ordDetail.getProductCode());
//		tmpRo.setProductName(ordDetail.getProductNameEn());
//		tmpRo.setCategory(ordDetail.getSaleOrderCat());
//		tmpRo.setCustAccount(ordDetail.getCustCode());
//		tmpRo.setCustName(ordDetail.getNameEn());
//		tmpRo.setNumberSeqCode(B2BConstant.VO_NUMBER_SEQ_CODE);
//		tmpRo.setSite(ordDetail.getSite());
//		tmpRo.setWarehouse(ordDetail.getWarehouse());
//
//		tmpRo.setReqShipDate(ord.getExpectShipmentDate());
//		tmpRo.setReqReceiptDate(ord.getExpectReceiptDate());
//		tmpRo.setAmount(ordDetail.getAmount());
//		tmpRo.setStatus(ordDetail.getStatus());
//
//		tmpRo.setSalesPrice(getSalePrice(ordDetail.getPrice()));
//		tmpRo.setUnit(getProductUnit(ordDetail.getProductUnitId()));
//		tmpRo.setProductBuyerGroupId(getProductBuyerGroup(ordDetail.getProductBuyerGroupId()));
//
//		tmpRo.setCurrencyCode(getCurrencyCode(tmpRo.getCustAccount(), ordDetail.getProductCurrency(), ordDetail.getProductCategoryId()));
//		tmpRo.setTermCode(ordDetail.getPaymentTermId());
//		tmpRo.setRunningNumber(0L);
//		
//		tmpRo.setCategory(ordDetail.getSaleOrderCat());
//		tmpRo.setWarehouse(ordDetail.getWarehouse());
//		tmpRo.setSite(ordDetail.getSite());
//		
//		tmpRo.setImportDateTime(null);
//		tmpRo.setSalesId(null);
//		tmpRo.setImportStatus(B2BConstant.ONE_IMPORT_STATUS);
//		tmpRo.setDtsSystem(B2BConstant.B2B_SYSTEM_NAME);
//		tmpRo.setDtsUpdate(ordDetail.getTimeUpdate());
//		
//		tmpRo.setUserCreate(ordDetail.getUserCreate());
//		tmpRo.setUserUpdate(ordDetail.getUserUpdate());
//		tmpRo.setTimeCreate(ordDetail.getTimeCreate());
//		tmpRo.setTimeUpdate(ordDetail.getTimeUpdate());
//		
//	}

	private String getCurrencyCode(String custAccount, String productCurrency, String productCategoryId) {
		if (StringUtils.isEmpty(productCurrency)) {
			if (custAccount.length() > 3) {
				productCurrency = custAccount.substring(custAccount.length() - 3, custAccount.length());
			} else {
				productCurrency = custAccount;
			}
		}
		return CurrencyUtils.parseCurrencyB2BToAX(productCurrency, productCategoryId);
	}

	private String getProductBuyerGroup(String productBuyerGroupId) {
		if (StringUtils.isEmpty(productBuyerGroupId)) {
			return applicationConfig.getDefaultProductBuyerGroup();
		} else {
			return productBuyerGroupId;
		}
	}

	private String getProductUnit(String productUnitId) {
		if (StringUtils.isEmpty(productUnitId)) {
			return applicationConfig.getDefaultProductUnit();
		} else {
			return productUnitId;
		}
	}

	private BigDecimal getSalePrice(BigDecimal price) {
		if (price == null) {
			return new BigDecimal(0);
		} else {
			return price;
		}
	}

}
