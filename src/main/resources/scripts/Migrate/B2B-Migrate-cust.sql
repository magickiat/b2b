INSERT INTO `b2b`.`cust`
(`cust_id`,
`cust_code`,
`invoice_code`,
`sale_id`,
`name_th`,
`name_en`,
`currency`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)



SELECT `cust`.`cust_id`,
    `cust`.`cust_code`,
    `cust`.`invoice_code`,
    `cust`.`sale_id`,
    `cust`.`name_th`,
    `cust`.`name_en`,
    `cust`.`currency`,
    `cust`.`user_create`,
    `cust`.`user_update`,
    `cust`.`time_create`,
    `cust`.`time_update`
FROM `stb`.`cust`;
