-- Database: invoicedb

-- DROP DATABASE invoicedb;

CREATE DATABASE invoicedb
  WITH OWNER = invoice
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;