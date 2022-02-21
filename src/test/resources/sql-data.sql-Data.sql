INSERT INTO `order_items` (`itemid`, `orderid`, `quantity`) VALUES ('1', '1', '1');
INSERT INTO `order_items` (`itemid`, `orderid`, `quantity`) VALUES ('2', '2', '2');
INSERT INTO `order_items` (`itemid`, `orderid`, `quantity`) VALUES ('3', '3', '3');

INSERT INTO `orders` (`customerid`) VALUES ('1');
INSERT INTO `orders` (`customerid`) VALUES ('2');
INSERT INTO `orders` (`customerid`) VALUES ('3');

INSERT INTO `items` (`item_name`, `item_value`) VALUES ('football', '19.99');
INSERT INTO `items` (`item_name`, `item_value`) VALUES ('teddy', '4.99');
INSERT INTO `items` (`item_name`, `item_value`) VALUES ('bucket', '12.50');

INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `customers` (`first_name`, `surname`) VALUES ('michael', 'jordan');
INSERT INTO `customers` (`first_name`, `surname`) VALUES ('katy', 'wilson');
