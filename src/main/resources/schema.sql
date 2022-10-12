CREATE TABLE truck (
  `truck_id` INT NOT NULL AUTO_INCREMENT,
  `make` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `truck_year` INT NULL,
  PRIMARY KEY (`truck_id`));

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;
