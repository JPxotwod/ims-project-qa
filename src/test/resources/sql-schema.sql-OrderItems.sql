DROP TABLE IF EXISTS `order_items`;

CREATE TABLE IF NOT EXISTS `order_items` (
`orderid` INT(11) NULL DEFAULT NULL,
`itemid` INT(11) NULL DEFAULT NULL,
`quantity` INT(11) NULL DEFAULT NULL,
FOREIGN KEY (`orderid`) REFERENCES `orders`(id),
FOREIGN KEY (`itemid`) REFERENCES `items`(id)
);

INSERT INTO `order_items` (`itemid`, `orderid`, `quantity`) VALUES ('1', '1', '1');
INSERT INTO `order_items` (`itemid`, `orderid`, `quantity`) VALUES ('2', '2', '2');
INSERT INTO `order_items` (`itemid`, `orderid`, `quantity`) VALUES ('3', '3', '3');