INSERT INTO
  brand (id, name, logo, user_create, time_create)
VALUES
  (70, 'STARBOARD SURF', NULL, 'B2B', curdate()),
  (50, 'DRAKE', NULL, 'B2B', curdate()),
  (40, 'SEVERNE', '/upload/brand/logo/severne.png', 'B2B', curdate()),
  (30, 'AIRUSH', '/upload/brand/logo/airush.png', 'B2B', curdate()),
  (29, 'STARBOARD SUP APPAREL', NULL, 'B2B', curdate()),
  (10, 'STARBOARD', '/upload/brand/logo/starboard.png', 'B2B', curdate()),
  (19, 'STARBOARD APPAREL', NULL, 'B2B', curdate()),
  (20, 'STARBOARD SUP', NULL, 'B2B', curdate()),
  (99, 'NON BRAND', NULL, 'B2B', curdate());


INSERT INTO role (role_id) VALUES ('ROLE_ADMIN');
INSERT INTO role (role_id) VALUES ('ROLE_USER');

COMMIT;