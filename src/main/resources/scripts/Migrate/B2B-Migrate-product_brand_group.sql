INSERT INTO `b2b`.`product_brand_group`
(`brand_group_id`,
`product_type_id`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)


SELECT `product_brand_group`.`brand_group_id`,
    `product_brand_group`.`product_type_id`,
    `product_brand_group`.`user_create`,
    `product_brand_group`.`user_update`,
    `product_brand_group`.`time_create`,
    `product_brand_group`.`time_update`
FROM `stb`.`product_brand_group`;


