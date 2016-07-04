truncate table `b2b`.`addr`;

INSERT INTO `b2b`.`addr`
(`addr_id`,
`cust_id`,
`cust_code`,
`contact_id`,
`address`,
`sub_district`,
`district`,
`province`,
`region_country_id`,
`post_code`,
`tel_1`,
`tel_2`,
`fax`,
`email`,
`trans_type`,
`trans_tel`,
`type`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)



SELECT `addr`.`addr_id`,
    `addr`.`cust_id`,
    `addr`.`cust_code`,
    `addr`.`contact_id`,
    `addr`.`address`,
    `addr`.`sub_district`,
    `addr`.`district`,
    `addr`.`province`,
    `addr`.`region_country_id`,
    `addr`.`post_code`,
    `addr`.`tel_1`,
    `addr`.`tel_2`,
    `addr`.`fax`,
    `addr`.`email`,
    `addr`.`trans_type`,
    `addr`.`trans_tel`,
    `addr`.`type`,
    `addr`.`user_create`,
    `addr`.`user_update`,
    `addr`.`time_create`,
    `addr`.`time_update`
FROM `stb`.`addr`;
