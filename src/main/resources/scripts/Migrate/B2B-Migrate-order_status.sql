truncate table `b2b`.`order_status`;

INSERT INTO `b2b`.`order_status`
(`order_status_id`,
`order_status_name`,
`order_status_description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)


SELECT `order_status`.`order_status_id`,
    `order_status`.`order_status_name`,
    `order_status`.`order_status_description`,
    `order_status`.`user_create`,
    `order_status`.`user_update`,
    `order_status`.`time_create`,
    `order_status`.`time_update`
FROM `stb`.`order_status`;
