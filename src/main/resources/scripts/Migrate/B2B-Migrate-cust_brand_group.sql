INSERT INTO `b2b`.`cust_brand_group`
(`cust_id`,
`brand_group_id`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)





SELECT `cust_brand_group`.`cust_id`,
    `cust_brand_group`.`brand_group_id`,
    `cust_brand_group`.`user_create`,
    `cust_brand_group`.`user_update`,
    `cust_brand_group`.`time_create`,
    `cust_brand_group`.`time_update`
FROM `stb`.`cust_brand_group`;
