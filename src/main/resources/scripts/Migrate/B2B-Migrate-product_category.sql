truncate table `b2b`.`product_category`;

INSERT INTO `b2b`.`product_category`
(`product_category_id`,
`product_category_name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)



SELECT `product_category`.`product_category_id`,
    `product_category`.`product_category_name`,
    `product_category`.`description`,
    `product_category`.`user_create`,
    `product_category`.`user_update`,
    `product_category`.`time_create`,
    `product_category`.`time_update`
FROM `stb`.`product_category`;
