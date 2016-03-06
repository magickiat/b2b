truncate table `b2b`.`product_price_group`;


INSERT INTO `b2b`.`product_price_group`
(`product_price_group_id`,
`product_price_group_name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)



SELECT `product_price_group`.`product_price_group_id`,
    `product_price_group`.`product_price_group_name`,
    `product_price_group`.`description`,
    `product_price_group`.`user_create`,
    `product_price_group`.`user_update`,
    `product_price_group`.`time_create`,
    `product_price_group`.`time_update`
FROM `cube`.`product_price_group`

where `product_price_group`.`product_price_group_id` <> '';