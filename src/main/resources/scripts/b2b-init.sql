---------- ROLE ----------
INSERT INTO role (role_id) VALUES ('ROLE_ADMIN');
INSERT INTO role (role_id) VALUES ('ROLE_USER');

----- app config -----
insert into app_config(config_key, config_value) values('page.size', '12');
----- default -----
insert into app_config(config_key, config_value) values('default.product.tech', '000');
insert into app_config(config_key, config_value) values('default.order.status', 'TBA');
insert into app_config(config_key, config_value) values('default.payment.term.id', 'xxx');
insert into app_config(config_key, config_value) values('default.product.price', 'xxx');
insert into app_config(config_key, config_value) values('default.product.unit.id', 'xxx');


COMMIT;