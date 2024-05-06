--liquibase formatted sql
--changeset rnbv:init db
CREATE TABLE testTable(
  columnName1 VARCHAR (355)
);
