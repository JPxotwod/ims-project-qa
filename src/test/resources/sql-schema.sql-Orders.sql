DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `orders` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`customerid` INT(11) NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (`customerid`) REFERENCES `customers`(id)
);

INSERT INTO `orders` (`customerid`) VALUES ('1');
INSERT INTO `orders` (`customerid`) VALUES ('2');
INSERT INTO `orders` (`customerid`) VALUES ('3');
