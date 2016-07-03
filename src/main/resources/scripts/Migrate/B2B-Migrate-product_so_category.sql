truncate table `b2b`.`product_so_category`;


INSERT INTO `b2b`.`product_so_category`
(`so_category`,
`site`,
`warehouse`,
`sale_order_cat`,
`email`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)



SELECT `product_so_category`.`so_category`,
    `product_so_category`.`site`,
    `product_so_category`.`warehouse`,
    `product_so_category`.`sale_order_cat`,
    `product_so_category`.`email`,
    `product_so_category`.`user_create`,
    `product_so_category`.`user_update`,
    `product_so_category`.`time_create`,
    `product_so_category`.`time_update`
FROM `cube`.`product_so_category`;
