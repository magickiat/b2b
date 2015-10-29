truncate table `b2b`.`product_model`;


INSERT INTO `b2b`.`product_model`
(`product_model_id`,
`product_model_name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`,
`image`,
`header_text1`,
`header_text2`)


SELECT `product_model`.`product_model_id`,
    `product_model`.`product_model_name`,
    `product_model`.`description`,
    `product_model`.`user_create`,
    `product_model`.`user_update`,
    `product_model`.`time_create`,
    `product_model`.`time_update`,
    `product_model`.`image`,
    `product_model`.`header_text1`,
    `product_model`.`header_text2`
FROM `stb`.`product_model`

where `product_model`.`product_model_id` is not null or `product_model`.`product_model_id` <> ''
;

DELETE FROM `b2b`.`product_model` WHERE `product_model_id`='';