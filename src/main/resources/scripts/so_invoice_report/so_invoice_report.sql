-- orders
INSERT INTO b2b.orders (brand_group_id, cust_code, cust_id, cust_user_id, discount, expect_receipt_date, expect_shipment_date, member_id, net_price, order_code, order_date, order_status, payment_currency_id, payment_id, payment_method_id, payment_term_id, price, product_unit_id, remark_customer, remark_orders, ship_price, shipping_id, so_code, time_create, time_update, total_price, track_id, user_create, user_update) VALUES (10, 'AE-001-EUR', 1001, '5', null, '2016-09-20 02:10:00', '2016-09-20 02:10:00', null, null, 'RO-2016-0001', '2016-09-19 02:09:18', '30', 'USD', null, 'T/T', '3070AP', null, null, '', '', null, 'SEA', null, '2016-09-19 02:09:18', '2016-09-19 02:09:18', null, null, 'user', null);
INSERT INTO b2b.orders (brand_group_id, cust_code, cust_id, cust_user_id, discount, expect_receipt_date, expect_shipment_date, member_id, net_price, order_code, order_date, order_status, payment_currency_id, payment_id, payment_method_id, payment_term_id, price, product_unit_id, remark_customer, remark_orders, ship_price, shipping_id, so_code, time_create, time_update, total_price, track_id, user_create, user_update) VALUES (10, 'AE-001-EUR', 1001, '5', null, '2016-09-20 02:10:04', '2016-09-20 02:10:04', null, null, 'RO-2016-0002', '2016-09-19 02:09:43', '10', 'USD', null, 'T/T', '3070AP', null, null, '', '', null, 'SEA', null, '2016-09-19 02:09:43', '2016-09-19 02:09:43', null, null, 'user', null);
INSERT INTO b2b.orders (brand_group_id, cust_code, cust_id, cust_user_id, discount, expect_receipt_date, expect_shipment_date, member_id, net_price, order_code, order_date, order_status, payment_currency_id, payment_id, payment_method_id, payment_term_id, price, product_unit_id, remark_customer, remark_orders, ship_price, shipping_id, so_code, time_create, time_update, total_price, track_id, user_create, user_update) VALUES (10, 'AE-001-EUR', 1001, '5', null, '2016-09-20 02:10:00', '2016-09-20 02:10:00', null, null, 'RO-2016-0003', '2016-09-19 02:09:18', '30', 'USD', null, 'T/T', '3070AP', null, null, '', '', null, 'SEA', null, '2016-09-19 02:09:18', '2016-09-19 02:09:18', null, null, 'user', null);
INSERT INTO b2b.orders (brand_group_id, cust_code, cust_id, cust_user_id, discount, expect_receipt_date, expect_shipment_date, member_id, net_price, order_code, order_date, order_status, payment_currency_id, payment_id, payment_method_id, payment_term_id, price, product_unit_id, remark_customer, remark_orders, ship_price, shipping_id, so_code, time_create, time_update, total_price, track_id, user_create, user_update) VALUES (10, 'AE-001-EUR', 1001, '5', null, '2016-09-20 02:10:00', '2016-09-20 02:10:00', null, null, 'RO-2016-0004', '2016-09-19 02:09:18', '30', 'USD', null, 'T/T', '3070AP', null, null, '', '', null, 'SEA', null, '2016-09-19 02:09:18', '2016-09-19 02:09:18', null, null, 'user', null);

-- ord_detail
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (97, 1, 324.0000000000, 'GROUP3', 'USD', 714, 'PCS', 0, '2016-09-19 02:10:00', '2016-09-19 02:10:00', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (98, 1, 307.0000000000, 'GROUP3', 'USD', 713, 'PCS', 0, '2016-09-19 02:10:00', '2016-09-19 02:10:00', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (99, 1, 30.0000000000, 'GROUP3', 'USD', 830, 'PCS', 0, '2016-09-19 02:10:00', '2016-09-19 02:10:00', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (3, 3, 60.0000000000, 'GROUP3', 'USD', 863, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (5, 3, 8.0000000000, 'GROUP3', 'USD', 861, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (4, 3, 3.0000000000, 'GROUP3', 'USD', 860, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (96, 2, 8.0000000000, 'GROUP3', 'USD', 861, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (95, 2, 3.0000000000, 'GROUP3', 'USD', 860, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (94, 2, 60.0000000000, 'GROUP3', 'USD', 863, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (4, 5, 3.0000000000, 'GROUP3', 'USD', 860, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (5, 5, 8.0000000000, 'GROUP3', 'USD', 861, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.ord_detail (amount, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (3, 5, 60.0000000000, 'GROUP3', 'USD', 863, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');

-- so 
INSERT INTO b2b.so (expect_shipment_date, order_id, payment_method_id, payment_term_id, shipping_id, so_no, time_create, time_update, user_create, user_update) VALUES (null, 1, 'T/T', '3070AP', 'SEA', 's001', '2016-09-22 01:53:24', null, 'user', null);
INSERT INTO b2b.so (expect_shipment_date, order_id, payment_method_id, payment_term_id, shipping_id, so_no, time_create, time_update, user_create, user_update) VALUES (null, 1, 'T/T', '3070AP', 'SEA', 's002', '2016-09-25 01:12:41', null, 'user', null);
INSERT INTO b2b.so (expect_shipment_date, order_id, payment_method_id, payment_term_id, shipping_id, so_no, time_create, time_update, user_create, user_update) VALUES (null, 1, 'T/T', '3070AP', 'SEA', 's003', '2016-09-25 01:41:16', null, 'user', null);
INSERT INTO b2b.so (expect_shipment_date, order_id, payment_method_id, payment_term_id, shipping_id, so_no, time_create, time_update, user_create, user_update) VALUES (null, 2, 'T/T', '3070AP', 'SEA', 's004', '2016-09-25 23:47:48', null, 'user', null);

-- so_detail 
INSERT INTO b2b.so_detail (amount, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, so_id, time_create, time_update, user_create, user_update) VALUES (55, 16, 33.0000000000, 'GROUP3', 'USD', 'PCS', 1, '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.so_detail (amount, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, so_id, time_create, time_update, user_create, user_update) VALUES (55, 18, 33.0000000000, 'GROUP3', 'USD', 'PCS', 2, '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.so_detail (amount, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, so_id, time_create, time_update, user_create, user_update) VALUES (55, 17, 33.0000000000, 'GROUP3', 'USD', 'PCS', 2, '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.so_detail (amount, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, so_id, time_create, time_update, user_create, user_update) VALUES (97, 18, 324.0000000000, 'GROUP3', 'USD', 'PCS', 3, '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.so_detail (amount, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, so_id, time_create, time_update, user_create, user_update) VALUES (55, 17, 307.0000000000, 'GROUP3', 'USD', 'PCS', 3, '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.so_detail (amount, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, so_id, time_create, time_update, user_create, user_update) VALUES (97, 20, 324.0000000000, 'GROUP3', 'USD', 'PCS', 4, '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.so_detail (amount, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, so_id, time_create, time_update, user_create, user_update) VALUES (55, 19, 307.0000000000, 'GROUP3', 'USD', 'PCS', 4, '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.so_detail (amount, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, so_id, time_create, time_update, user_create, user_update) VALUES (55, 21, 307.0000000000, 'GROUP3', 'USD', 'PCS', 4, '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);

-- invoice 
INSERT INTO b2b.invoice (invoice_id, invoice_date, invoice_eta, invoice_etd, invoice_no, so_id, time_create, time_update, user_create, user_update) VALUES (1, '2016-09-19 02:50:05', '2016-09-19 02:50:27', '2016-09-19 02:50:29', 'IV0001', 1, '2016-09-19 02:50:39', '2016-09-19 02:50:40', null, null);
INSERT INTO b2b.invoice (invoice_id, invoice_date, invoice_eta, invoice_etd, invoice_no, so_id, time_create, time_update, user_create, user_update) VALUES (2, '2016-09-19 02:50:05', '2016-09-19 02:50:27', '2016-09-19 02:50:29', 'IV0002', 4, '2016-09-19 02:50:39', '2016-09-19 02:50:40', null, null);

-- invoice_detail 
INSERT INTO b2b.invoice_detail (invoice_product_id, amount, invoice_id, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, time_create, time_update, user_create, user_update) VALUES (1, 55, 1, 830, 33.0000000000, 'GROUP1', 'USD', 'PCS', '2016-09-19 02:53:29', '2016-09-19 02:53:30', null, null);
INSERT INTO b2b.invoice_detail (invoice_product_id, amount, invoice_id, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, time_create, time_update, user_create, user_update) VALUES (2, 55, 2, 19, 33.0000000000, 'GROUP3', 'USD', 'PCS', '2016-09-19 02:53:29', '2016-09-19 02:53:30', null, null);
INSERT INTO b2b.invoice_detail (invoice_product_id, amount, invoice_id, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, time_create, time_update, user_create, user_update) VALUES (3, 55, 2, 20, 103.0000000000, 'GROUP3', 'USD', 'PCS', '2016-09-19 02:53:29', '2016-09-19 02:53:30', null, null);
INSERT INTO b2b.invoice_detail (invoice_product_id, amount, invoice_id, order_product_id, price, product_buyer_group_id, product_currency, product_unit_id, time_create, time_update, user_create, user_update) VALUES (4, 55, 2, 21, 55.0000000000, 'GROUP3', 'USD', 'PCS', '2016-09-19 02:53:29', '2016-09-19 02:53:30', null, null);