-- drop schema ims;

-- CREATE SCHEMA IF NOT EXISTS `ims`;

-- USE `ims` ;

-- CREATE TABLE IF NOT EXISTS `customers` (
-- `id` INT(11) NOT NULL AUTO_INCREMENT,
-- `first_name` VARCHAR(40) DEFAULT NULL,
-- `surname` VARCHAR(40) DEFAULT NULL,
-- PRIMARY KEY (`id`)
-- );

-- CREATE TABLE IF NOT EXISTS `items` (
-- `id` INT(11) NOT NULL AUTO_INCREMENT,
-- `item_name` VARCHAR(40) NULL DEFAULT NULL,
-- `item_value` DOUBLE(99,2) NOT NULL DEFAULT 0,
-- PRIMARY KEY (`id`)
-- );

-- CREATE TABLE IF NOT EXISTS `orders` (
-- `id` INT(11) NOT NULL AUTO_INCREMENT,
-- `customerid` INT(11) NOT NULL,
-- PRIMARY KEY (`id`),
-- FOREIGN KEY (`customerid`) REFERENCES `customers`(id)
-- );

-- CREATE TABLE IF NOT EXISTS `order_items` (
-- `orderid` INT(11) NULL DEFAULT NULL,
-- `itemid` INT(11) NULL DEFAULT NULL,
-- `quantity` INT(11) NULL DEFAULT NULL,
-- FOREIGN KEY (`orderid`) REFERENCES `orders`(id),
-- FOREIGN KEY (`itemid`) REFERENCES `items`(id)
-- );
