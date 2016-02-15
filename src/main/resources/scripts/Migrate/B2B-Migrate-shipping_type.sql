truncate table `b2b`.`shipping_type`;

INSERT INTO `b2b`.`shipping_type`
(`shipping_type_id`,
`shipping_type_name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)

SELECT `shipping_type`.`shipping_type_id`,
    `shipping_type`.`shipping_type_name`,
    `shipping_type`.`description`,
    `shipping_type`.`user_create`,
    `shipping_type`.`user_update`,
    `shipping_type`.`time_create`,
    `shipping_type`.`time_update`
FROM `cube`.`shipping_type`;
