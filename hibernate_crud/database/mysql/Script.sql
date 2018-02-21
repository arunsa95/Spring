--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `training`.`account` DROP PRIMARY KEY;

DROP TABLE `training`.`account`;

CREATE TABLE `training`.`account` (
	`ACCOUNT_ID` BIGINT NOT NULL,
	`CREATION_DATE` DATETIME,
	`ACCOUNT_TYPE` VARCHAR(255),
	`BALANCE` DOUBLE,
	PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB;

