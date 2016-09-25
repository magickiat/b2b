-- tmp_orders_from_ax
INSERT INTO b2b.tmp_orders_from_ax (order_id, brand_group_id, cust_code, cust_id, cust_user_id, discount, expect_receipt_date, expect_shipment_date, member_id, net_price, order_code, order_date, order_status, payment_currency_id, payment_id, payment_method_id, payment_term_id, price, product_unit_id, remark_customer, remark_orders, ship_price, shipping_id, so_code, time_create, time_update, total_price, track_id, user_create, user_update) VALUES (1, 10, 'AE-001-EUR', 1001, '5', null, '2016-09-20 02:10:00', '2016-09-20 02:10:00', null, null, 'RO-2016-0001', '2016-09-19 02:09:18', '30', 'USD', null, 'T/T', '3070AP', null, null, '', '', null, 'SEA', null, '2016-09-19 02:09:18', '2016-09-19 02:09:18', null, null, 'user', null);
INSERT INTO b2b.tmp_orders_from_ax (order_id, brand_group_id, cust_code, cust_id, cust_user_id, discount, expect_receipt_date, expect_shipment_date, member_id, net_price, order_code, order_date, order_status, payment_currency_id, payment_id, payment_method_id, payment_term_id, price, product_unit_id, remark_customer, remark_orders, ship_price, shipping_id, so_code, time_create, time_update, total_price, track_id, user_create, user_update) VALUES (2, 10, 'AE-001-EUR', 1001, '5', null, '2016-09-20 02:10:04', '2016-09-20 02:10:04', null, null, 'RO-2016-0002', '2016-09-19 02:09:43', '10', 'USD', null, 'T/T', '3070AP', null, null, '', '', null, 'SEA', null, '2016-09-19 02:09:43', '2016-09-19 02:09:43', null, null, 'user', null);
INSERT INTO b2b.tmp_orders_from_ax (order_id, brand_group_id, cust_code, cust_id, cust_user_id, discount, expect_receipt_date, expect_shipment_date, member_id, net_price, order_code, order_date, order_status, payment_currency_id, payment_id, payment_method_id, payment_term_id, price, product_unit_id, remark_customer, remark_orders, ship_price, shipping_id, so_code, time_create, time_update, total_price, track_id, user_create, user_update) VALUES (3, 10, 'AE-001-EUR', 1001, '5', null, '2016-09-20 02:10:00', '2016-09-20 02:10:00', null, null, 'RO-2016-0003', '2016-09-19 02:09:18', '30', 'USD', null, 'T/T', '3070AP', null, null, '', '', null, 'SEA', null, '2016-09-19 02:09:18', '2016-09-19 02:09:18', null, null, 'user', null);
INSERT INTO b2b.tmp_orders_from_ax (order_id, brand_group_id, cust_code, cust_id, cust_user_id, discount, expect_receipt_date, expect_shipment_date, member_id, net_price, order_code, order_date, order_status, payment_currency_id, payment_id, payment_method_id, payment_term_id, price, product_unit_id, remark_customer, remark_orders, ship_price, shipping_id, so_code, time_create, time_update, total_price, track_id, user_create, user_update) VALUES (5, 10, 'AE-001-EUR', 1001, '5', null, '2016-09-20 02:10:00', '2016-09-20 02:10:00', null, null, 'RO-2016-0004', '2016-09-19 02:09:18', '30', 'USD', null, 'T/T', '3070AP', null, null, '', '', null, 'SEA', null, '2016-09-19 02:09:18', '2016-09-19 02:09:18', null, null, 'user', null);

-- tmp_ord_detail_from_ax
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (13, 4, 'RO-2016-0003', 3, 3.0000000000, 'GROUP3', 'USD', 860, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (14, 5, 'RO-2016-0003', 3, 8.0000000000, 'GROUP3', 'USD', 861, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (15, 3, 'RO-2016-0003', 3, 60.0000000000, 'GROUP3', 'USD', 863, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (16, 99, 'RO-2016-0001', 1, 30.0000000000, 'GROUP3', 'USD', 830, 'PCS', 0, '2016-09-19 02:10:00', '2016-09-19 02:10:00', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (17, 98, 'RO-2016-0001', 1, 307.0000000000, 'GROUP3', 'USD', 713, 'PCS', 0, '2016-09-19 02:10:00', '2016-09-19 02:10:00', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (18, 97, 'RO-2016-0001', 1, 324.0000000000, 'GROUP3', 'USD', 714, 'PCS', 0, '2016-09-19 02:10:00', '2016-09-19 02:10:00', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (19, 96, 'RO-2016-0002', 2, 8.0000000000, 'GROUP3', 'USD', 861, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (20, 95, 'RO-2016-0002', 2, 3.0000000000, 'GROUP3', 'USD', 860, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (21, 94, 'RO-2016-0002', 2, 60.0000000000, 'GROUP3', 'USD', 863, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (22, 4, 'RO-2016-0004', 5, 3.0000000000, 'GROUP3', 'USD', 860, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (23, 5, 'RO-2016-0004', 5, 8.0000000000, 'GROUP3', 'USD', 861, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');
INSERT INTO b2b.tmp_ord_detail_from_ax (order_detail_id, amount, order_code, order_id, price, product_buyer_group_id, product_currency, product_id, product_unit_id, status, time_create, time_update, user_create, user_update) VALUES (24, 3, 'RO-2016-0004', 5, 60.0000000000, 'GROUP3', 'USD', 863, 'PCS', 0, '2016-09-19 02:10:04', '2016-09-19 02:10:04', 'user', 'admin');

-- tmp_so
INSERT INTO b2b.tmp_so (expect_shipment_date, order_code, order_id, payment_method_id, payment_term_id, shipping_id, so_no, time_create, time_update, user_create, user_update) VALUES (null, 'RO-2016-0001', 1, 'T/T', '3070AP', 'SEA', 's001', '2016-09-22 01:53:24', null, 'user', null);
INSERT INTO b2b.tmp_so (expect_shipment_date, order_code, order_id, payment_method_id, payment_term_id, shipping_id, so_no, time_create, time_update, user_create, user_update) VALUES (null, 'RO-2016-0001', 1, 'T/T', '3070AP', 'SEA', 's002', '2016-09-25 01:12:41', null, 'user', null);
INSERT INTO b2b.tmp_so (expect_shipment_date, order_code, order_id, payment_method_id, payment_term_id, shipping_id, so_no, time_create, time_update, user_create, user_update) VALUES (null, 'RO-2016-0001', 1, 'T/T', '3070AP', 'SEA', 's003', '2016-09-25 01:41:16', null, 'user', null);
INSERT INTO b2b.tmp_so (expect_shipment_date, order_code, order_id, payment_method_id, payment_term_id, shipping_id, so_no, time_create, time_update, user_create, user_update) VALUES (null, 'RO-2016-0002', 2, 'T/T', '3070AP', 'SEA', 's004', '2016-09-25 23:47:48', null, 'user', null);

-- tmp_so_detail
INSERT INTO b2b.tmp_so_detail (amount, order_product_id, price, product_buyer_group_id, product_code, product_currency, product_unit_id, so_id, so_no, time_create, time_update, user_create, user_update) VALUES (55, 16, 33.0000000000, 'GROUP3', '1000000001058', 'USD', 'PCS', 1, 's001', '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.tmp_so_detail (amount, order_product_id, price, product_buyer_group_id, product_code, product_currency, product_unit_id, so_id, so_no, time_create, time_update, user_create, user_update) VALUES (55, 18, 33.0000000000, 'GROUP3', '1000000001060', 'USD', 'PCS', 2, 's002', '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.tmp_so_detail (amount, order_product_id, price, product_buyer_group_id, product_code, product_currency, product_unit_id, so_id, so_no, time_create, time_update, user_create, user_update) VALUES (55, 17, 33.0000000000, 'GROUP3', '1000000001059', 'USD', 'PCS', 2, 's002', '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.tmp_so_detail (amount, order_product_id, price, product_buyer_group_id, product_code, product_currency, product_unit_id, so_id, so_no, time_create, time_update, user_create, user_update) VALUES (97, 18, 324.0000000000, 'GROUP3', '1000000001060', 'USD', 'PCS', 3, 's003', '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.tmp_so_detail (amount, order_product_id, price, product_buyer_group_id, product_code, product_currency, product_unit_id, so_id, so_no, time_create, time_update, user_create, user_update) VALUES (55, 17, 307.0000000000, 'GROUP3', '1000000001059', 'USD', 'PCS', 3, 's003', '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.tmp_so_detail (amount, order_product_id, price, product_buyer_group_id, product_code, product_currency, product_unit_id, so_id, so_no, time_create, time_update, user_create, user_update) VALUES (97, 20, 324.0000000000, 'GROUP3', '1000000001428', 'USD', 'PCS', 4, 's004', '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.tmp_so_detail (amount, order_product_id, price, product_buyer_group_id, product_code, product_currency, product_unit_id, so_id, so_no, time_create, time_update, user_create, user_update) VALUES (55, 19, 307.0000000000, 'GROUP3', '1000000001414', 'USD', 'PCS', 4, 's004', '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);
INSERT INTO b2b.tmp_so_detail (amount, order_product_id, price, product_buyer_group_id, product_code, product_currency, product_unit_id, so_id, so_no, time_create, time_update, user_create, user_update) VALUES (55, 21, 307.0000000000, 'GROUP3', '1000000001430', 'USD', 'PCS', 4, 's004', '2016-09-19 02:48:34', '2016-09-19 02:48:35', null, null);