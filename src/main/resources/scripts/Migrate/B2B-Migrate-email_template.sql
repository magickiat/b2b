delete from `b2b`.`email_template`;

INSERT INTO `b2b`.`email_template`
(`id`,
`subject`,
`body`,
`user_create`,
`user_update`,
`time_create`,
`time_update`)




SELECT `email_template`.`id`,
    `email_template`.`subject`,
    `email_template`.`body`,
    `email_template`.`user_create`,
    `email_template`.`user_update`,
    `email_template`.`time_create`,
    `email_template`.`time_update`
FROM `cube`.`email_template`;


UPDATE `b2b`.`email_template` SET `id`='A0' WHERE `id`='100';
