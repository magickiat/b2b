truncate table `b2b`.`product_year`;

INSERT INTO `b2b`.`product_year`
(`product_year_id`,
`product_year_name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)



SELECT `product_year`.`product_year_id`,
    `product_year`.`product_year_name`,
    `product_year`.`description`,
    `product_year`.`user_create`,
    `product_year`.`user_update`,
    `product_year`.`time_create`,
    `product_year`.`time_update`
FROM `stb`.`product_year`;
