CREATE TABLE truck (
  `truck_id` INT NOT NULL AUTO_INCREMENT,
  `make` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `yr` INT NULL,
  `weight` VARCHAR(45) NULL,
  `volume` VARCHAR(45) NULL,
  `mpg` INT NOT NULL,
  `space` VARCHAR(45) NULL,
  `type` ENUM('GAS','HYBRID','ELECTRIC') NOT NULL,
  PRIMARY KEY (`truck_id`));
