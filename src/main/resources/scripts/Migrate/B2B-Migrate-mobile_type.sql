truncate table `b2b`.`mobile_type`;

INSERT INTO `b2b`.`mobile_type`
(`mobile_id`,
`name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)



SELECT `mobile_type`.`mobile_id`,
    `mobile_type`.`name`,
    `mobile_type`.`description`,
    `mobile_type`.`user_create`,
    `mobile_type`.`user_update`,
    `mobile_type`.`time_create`,
    `mobile_type`.`time_update`
FROM `stb`.`mobile_type`;
