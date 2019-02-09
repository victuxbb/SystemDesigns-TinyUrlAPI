CREATE KEYSPACE tinyurl
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};

USE tinyurl;

CREATE TABLE URL (
  hash text PRIMARY KEY,
  original_url text,
  creation_date timestamp
) WITH comment='Urls';