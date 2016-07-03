truncate table `b2b`.`payment_method`;

INSERT INTO `b2b`.`payment_method`
(`payment_method_id`,
`payment_method_name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)



SELECT `payment_method`.`payment_method_id`,
    `payment_method`.`payment_method_name`,
    `payment_method`.`description`,
    `payment_method`.`user_create`,
    `payment_method`.`user_update`,
    `payment_method`.`time_create`,
    `payment_method`.`time_update`
FROM `stb`.`payment_method`;
