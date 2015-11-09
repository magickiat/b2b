truncate table `b2b`.`product_technology`;

INSERT INTO `b2b`.`product_technology`
(`product_technology_id`,
`product_technology_name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)




SELECT `product_technology`.`product_technology_id`,
    `product_technology`.`product_technology_name`,
    `product_technology`.`description`,
    `product_technology`.`user_create`,
    `product_technology`.`user_update`,
    `product_technology`.`time_create`,
    `product_technology`.`time_update`
FROM `stb`.`product_technology`;
