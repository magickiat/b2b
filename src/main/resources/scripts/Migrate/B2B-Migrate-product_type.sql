truncate table `b2b`.`product_type`;

INSERT INTO `b2b`.`product_type`
(`product_type_id`,
`product_type_name`,
`product_type_parent_id`,
`product_type_description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)




SELECT `product_type`.`product_type_id`,
    `product_type`.`product_type_name`,
    `product_type`.`product_type_parent_id`,
    `product_type`.`product_type_description`,
    `product_type`.`user_create`,
    `product_type`.`user_update`,
    `product_type`.`time_create`,
    `product_type`.`time_update`
FROM `stb`.`product_type`;
