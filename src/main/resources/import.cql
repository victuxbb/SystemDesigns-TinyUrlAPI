CREATE KEYSPACE tinyurl
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};

USE tinyurl;

CREATE TABLE URL (
  hash text PRIMARY KEY,
  original_url text,
  creation_date timestamp,
  expiration_date timestamp,
  user_id int
) WITH comment='Urls';

CREATE TABLE User (
  id int PRIMARY KEY,
  name text,
  email text,
  creation_date timestamp,
  last_login timestamp
) WITH comment='Users';