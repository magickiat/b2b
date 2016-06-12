---------- ROLE ----------
INSERT INTO role (role_id) VALUES ('ROLE_ADMIN');
INSERT INTO role (role_id) VALUES ('ROLE_USER');

---------- USER ----------
INSERT INTO `b2b`.`user` (`time_create`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `name`, `password`, `username`) VALUES ('2016-06-12 11:33:30', b'1', b'1', b'1', b'1', 'Administrator', '21232F297A57A5A743894A0E4A801FC3', 'admin');

---------- USER_ROLE ----------
INSERT INTO `b2b`.`user_role` (`user_id`, `role_role_id`) VALUES (1, 'ROLE_ADMIN');

COMMIT;