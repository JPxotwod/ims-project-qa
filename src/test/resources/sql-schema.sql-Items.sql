DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`item_name` VARCHAR(40) NULL DEFAULT NULL,
`item_value` DOUBLE(99,2) NOT NULL DEFAULT 0,
PRIMARY KEY (`id`)
);

INSERT INTO `items` (`item_name`, `item_value`) VALUES ('football', '19.99');
INSERT INTO `items` (`item_name`, `item_value`) VALUES ('teddy', '4.99');
INSERT INTO `items` (`item_name`, `item_value`) VALUES ('bucket', '12.50');