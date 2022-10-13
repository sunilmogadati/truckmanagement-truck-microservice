CREATE TABLE trucks (
  `truck_id` INT NOT NULL AUTO_INCREMENT,
  `truck_make` VARCHAR(45) NULL,
  `truck_model` VARCHAR(45) NULL,
  `truck_year` INT NULL,
  `truck_weight` VARCHAR(45) NULL,
  `truck_volume` VARCHAR(45) NULL,
  `truck_mpg` INT NOT NULL,
  `truck_space` VARCHAR(45) NULL,
  `truck_type` ENUM('GAS','HYBRID','ELECTRIC') NOT NULL,
  PRIMARY KEY (`truck_id`));
