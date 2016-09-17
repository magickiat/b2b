package com.starboard.b2b.service.impl;

import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.dao.OrderAddressDao;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.dao.TmpContactAXDao;
import com.starboard.b2b.dao.TmpOrderAddressAXDao;
import com.starboard.b2b.dao.TmpProductDao;
import com.starboard.b2b.dao.TmpSoDao;
import com.starboard.b2b.dao.TmpSoDetailDao;
import com.starboard.b2b.dao.impl.TmpOrderAddressAXDaoImpl;
import com.starboard.b2b.model.Contact;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.TmpContactFromAx;
import com.starboard.b2b.model.TmpOrdAddressFromAx;
import com.starboard.b2b.model.TmpProduct;
import com.starboard.b2b.service.SyncB2BService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("syncB2BService")
public class SyncB2BServiceImpl implements SyncB2BService {

    private static final Logger log = LoggerFactory.getLogger(SyncB2BServiceImpl.class);

    private OrderDao orderDao;
    private OrderDetailDao orderDetailDao;
    private SoDao soDao;
    private SoDetailDao soDetailDao;
    private TmpSoDao tmpSoDao;
    private TmpSoDetailDao tmpSoDetailDao;
    private TmpProductDao tmpProductDao;
    private ProductDao productDao;
    private TmpContactAXDao tmpContactAXDao;
    private ContactDao contactDao;
    private TmpOrderAddressAXDao tmpOrdAddressAXDao;
    private OrderAddressDao orderAddressDao;

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    public void syncContactFromAX() {
        log.info("Sync Contact from AX");
        //Step 1: Get data from AX
        List<TmpContactFromAx> tmpContactFromAXs = tmpContactAXDao.list();
        if (tmpContactFromAXs != null && !tmpContactFromAXs.isEmpty()) {
            for (TmpContactFromAx tmpContactFromAx : tmpContactFromAXs) {
                //Step 2: Clear all match cust_id
                contactDao.removeByCustId(tmpContactFromAx.getCustId());
                //Step 3: Insert into sync table
                Contact syncContact = new Contact();
                BeanUtils.copyProperties(tmpContactFromAx, syncContact);
                contactDao.save(syncContact);
            }
            //Step 4: Remove from AX
            tmpContactAXDao.removeAll();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void syncAddressFromAX() {
        log.info("Sync Address from AX");
        //Step 1: Get data from AX
        //Step 2: Insert / Update into sync table
        //Step 3: Remove table from AX
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void syncProductFromAX() {
        log.info("Sync Product from AX");
        //Step 1: Get data from AX
        List<TmpProduct> tmpProducts = tmpProductDao.list();
        //Step 2: Insert / Update into sync table
        if (tmpProducts != null && !tmpProducts.isEmpty()) {
            for (TmpProduct tmpProduct : tmpProducts) {
                //Step 2.1: Check if Product Code is in Product
                final Product product = productDao.findByProductCode(tmpProduct.getProductCode());
                //If Exist: then update value
                if (product != null) {
                    BeanUtils.copyProperties(tmpProduct, product, "productId");
                    productDao.save(product);
                } else {
                    //If Not Exist: then insert
                    Product newProduct = new Product();
                    BeanUtils.copyProperties(tmpProduct, newProduct, "productId");
                    productDao.save(newProduct);
                }
            }
            //Step 3: Remove from AX table
            tmpProductDao.removeAll();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void syncOrderFromAX() {
        log.info("Sync Order from AX");
        //Step 1: Get data from AX
        //Step 2: Insert / Update into sync table
        //Step 3: Remove table from AX
    }

    //for Address

    //for Product

    //for Order

    //for Order Detail

    //for Order Address
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void syncOrderAddressFromAX() {
        log.info("Sync Order Address from AX");
        //Step 1: Get data from AX
        final List<TmpOrdAddressFromAx> ordAddressFromAxes = tmpOrdAddressAXDao.list();
        if(ordAddressFromAxes != null && !ordAddressFromAxes.isEmpty()){
            for(TmpOrdAddressFromAx ordAddressFromAx : ordAddressFromAxes){
                //Step 2: Remove order_address which has order_code match with AX
                orderAddressDao.deleteByOrderCode(ordAddressFromAx.getOrderCode());
                //Step 3: Insert data from AX into sync table
                OrdAddress orderAddress = new OrdAddress();
                BeanUtils.copyProperties(ordAddressFromAx, orderAddress, "orderAddressId", "orderCode");
                orderAddressDao.save(orderAddress);
            }
            //Step 4: Remove from AX table
            tmpOrdAddressAXDao.removeAll();
        }
    }

    //for Sale Order

    //for Sale Order Detail

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void syncSellOrderFromAX() {
        log.info("Sync sell order from AX");
        //Step 1: Get data from AX
        //Step 2: Insert / Update into sync table
        //Step 3: Remove table from AX
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void syncInvoiceFromAX() {
        log.info("sync invoice from AX");
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }

    @Autowired
    public void setSoDao(SoDao soDao) {
        this.soDao = soDao;
    }

    @Autowired
    public void setSoDetailDao(SoDetailDao soDetailDao) {
        this.soDetailDao = soDetailDao;
    }

    @Autowired
    public void setTmpSoDao(TmpSoDao tmpSoDao) {
        this.tmpSoDao = tmpSoDao;
    }

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    public void setTmpSoDetailDao(TmpSoDetailDao tmpSoDetailDao) {
        this.tmpSoDetailDao = tmpSoDetailDao;
    }

    @Autowired
    public void setTmpProductDao(TmpProductDao tmpProductDao) {
        this.tmpProductDao = tmpProductDao;
    }

    @Autowired
    public void setTmpContactAXDao(TmpContactAXDao tmpContactAXDao) {
        this.tmpContactAXDao = tmpContactAXDao;
    }

    @Autowired
    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Autowired
    public void setTmpOrdAddressAXDao(TmpOrderAddressAXDaoImpl tmpOrdAddressAXDao) {
        this.tmpOrdAddressAXDao = tmpOrdAddressAXDao;
    }
}
