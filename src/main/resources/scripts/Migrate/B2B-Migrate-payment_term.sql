truncate table `b2b`.`payment_term`;

INSERT INTO `b2b`.`payment_term`
(`payment_term_id`,
`payment_term_name`,
`description`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)

SELECT `payment_term`.`payment_term_id`,
    `payment_term`.`payment_term_name`,
    `payment_term`.`description`,
    `payment_term`.`user_create`,
    `payment_term`.`user_update`,
    `payment_term`.`time_create`,
    `payment_term`.`time_update`
FROM `stb`.`payment_term`;
