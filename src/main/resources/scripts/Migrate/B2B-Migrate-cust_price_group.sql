truncate table `b2b`.`cust_price_group`;

INSERT INTO `b2b`.`cust_price_group`
(`cust_price_group_id`,
`cust_code`,
`product_type_id`,
`product_buyer_group_id`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)



SELECT `cust_price_group`.`cust_price_group_id`,
    `cust_price_group`.`cust_code`,
    `cust_price_group`.`product_type_id`,
    `cust_price_group`.`product_buyer_group_id`,
    `cust_price_group`.`user_create`,
    `cust_price_group`.`user_update`,
    `cust_price_group`.`time_create`,
    `cust_price_group`.`time_update`
FROM `stb`.`cust_price_group`;
