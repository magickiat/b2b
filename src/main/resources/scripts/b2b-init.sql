---------- ROLE ----------
INSERT INTO role (role_id) VALUES ('ROLE_ADMIN');
INSERT INTO role (role_id) VALUES ('ROLE_USER');

----- config -----
insert into app_config(config_key, config_value) values('page.size', '12');

COMMIT;