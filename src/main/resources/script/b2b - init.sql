insert into  b2b.app_config (id, config_key, config_value, created_by, created_date) values(1, 'upload_path', '/Users/magicalcyber/Pictures/b2b_upload', 'B2B', curdate());

insert into 
     b2b.brand(id, name, logo, created_by, created_date) 
values
(70, 'STARBOARD SURF', null, 'B2B', curdate()),
(50, 'DRAKE',null, 'B2B', curdate()),
(40, 'SEVERNE','/upload/brand/logo/severne.png', 'B2B', curdate()),
(30, 'AIRUSH', '/upload/brand/logo/airush.png', 'B2B', curdate()),
(29, 'STARBOARD SUP APPAREL', null, 'B2B', curdate()),
(10, 'STARBOARD','/upload/brand/logo/starboard.png', 'B2B', curdate()),
(19, 'STARBOARD APPAREL', null, 'B2B', curdate()),
(20, 'STARBOARD SUP', null, 'B2B', curdate()),
(99, 'NON BRAND', null, 'B2B', curdate());


INSERT INTO `b2b`.`role` (`role_id`) VALUES ('ROLE_ADMIN');
INSERT INTO `b2b`.`role` (`role_id`) VALUES ('ROLE_USER');
