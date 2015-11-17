truncate table `b2b`.`country`;


INSERT INTO `b2b`.`country`
(`country_code`,
`country_name`)


SELECT `country`.`country_code`,
    `country`.`country_name`
FROM `stb`.`country`
where `country`.`country_code` is not null;
