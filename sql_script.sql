DROP SCHEMA IF EXISTS yatzy CASCADE;
CREATE SCHEMA yatzy;
SET search_path = yatzy;

CREATE TABLE users 
(
   username CHARACTER VARYING(15),
   email CHARACTER VARYING(30),
   pwd_hash CHARACTER (64),
   pwd_salt CHARACTER (32),
   PRIMARY KEY (username)
);