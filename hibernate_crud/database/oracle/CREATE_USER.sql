CREATE USER LECTURE2 IDENTIFIED BY LECTURE2 DEFAULT TABLESPACE USERS 
TEMPORARY TABLESPACE TEMP;

GRANT CONNECT, RESOURCE, CREATE TABLE, CREATE SEQUENCE TO LECTURE2;