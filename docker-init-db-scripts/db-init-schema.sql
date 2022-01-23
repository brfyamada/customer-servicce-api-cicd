DROP SCHEMA IF EXISTS customer;
CREATE SCHEMA customer;

CREATE EXTENSION pgcrypto SCHEMA customer;

CREATE TABLESPACE tsdcustomer01 OWNER postgres LOCATION '/var/lib/postgresql/data/pg_tblspc';
CREATE TABLESPACE tsicustomer01 OWNER postgres LOCATION '/var/lib/postgresql/data/';

