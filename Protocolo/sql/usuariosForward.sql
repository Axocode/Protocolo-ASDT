-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema usuarios
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema usuarios
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `usuarios`;
CREATE SCHEMA IF NOT EXISTS `usuarios` DEFAULT CHARACTER SET utf8;
USE `usuarios` ;

-- -----------------------------------------------------
-- Table `usuarios`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios`.`users` (
  `iusernum` INT NOT NULL AUTO_INCREMENT,
  `iuser` VARCHAR(50) NULL DEFAULT NULL,
  `ipassword` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`iusernum`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

