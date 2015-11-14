truncate TABLE  `b2b`.`product_buyer_group`;


INSERT INTO `b2b`.`product_buyer_group`
(`product_buyer_group_id`,
`product_buyer_group_name`,
`description`,
`seq`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)


SELECT `product_buyer_group`.`product_buyer_group_id`,
    `product_buyer_group`.`product_buyer_group_name`,
    `product_buyer_group`.`description`,
    `product_buyer_group`.`seq`,
    `product_buyer_group`.`user_create`,
    `product_buyer_group`.`user_update`,
    `product_buyer_group`.`time_create`,
    `product_buyer_group`.`time_update`
FROM `stb`.`product_buyer_group`;
