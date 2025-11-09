CREATE DATABASE IF NOT EXISTS truck_db;
USE truck_db;

DROP TABLE IF EXISTS app_user;
CREATE TABLE app_user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100),
  password VARCHAR(100),
  full_name VARCHAR(200),
  role VARCHAR(50)
);

DROP TABLE IF EXISTS truck;
CREATE TABLE truck (
  plate VARCHAR(6) PRIMARY KEY,
  brand VARCHAR(100),
  model VARCHAR(100),
  owner_username VARCHAR(100)
);

INSERT INTO app_user (username,password,full_name,role) VALUES
('driver1','pass','Conductor Uno','DRIVER'),
('client1','pass','Cliente Uno','CUSTOMER');

INSERT INTO truck (plate,brand,model,owner_username) VALUES
('ABC123','Isuzu','NQR','driver1');
