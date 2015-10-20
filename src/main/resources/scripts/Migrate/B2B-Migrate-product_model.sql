INSERT INTO `b2b`.`product_model`
(`product_model_id`,
`product_model_name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)




SELECT `product_model`.`product_model_id`,
    `product_model`.`product_model_name`,
    `product_model`.`description`,
    `product_model`.`user_create`,
    `product_model`.`user_update`,
    `product_model`.`time_create`,
    `product_model`.`time_update`
FROM `stb`.`product_model`;
