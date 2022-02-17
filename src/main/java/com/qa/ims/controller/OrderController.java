package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private OrderItemDAO orderItemDAO;
	private ItemDAO itemDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, OrderItemDAO orderItemDAO, ItemDAO itemDAO, Utils utils) {
        super();
        this.orderDAO = orderDAO;
        this.utils = utils;
        this.orderItemDAO = orderItemDAO;
        this.itemDAO = itemDAO;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a order id");
		Long id = utils.getLong();
		LOGGER.info("Please enter a customer id");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(id, customerId));
		LOGGER.info("order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
//		LOGGER.info("Please enter the id of the order you would like to update");
//		Long id = utils.getLong();
//		LOGGER.info("Please enter an order id");
//		Long customerId = utils.getLong();
//		Order order = orderDAO.update(new Order(id, customerId));
//		LOGGER.info("Item Updated");
		return null;
	}

	/**
	 * Deletes an existing item by the id of the item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

	public float CalculateCost() {
		float Cost = 0f;
		LOGGER.info("What is the orderid of the order that you would like to know the cost of?");
		Long Orderid = utils.getLong();
		List<OrderItem> OrderItem = orderItemDAO.ReadAllOrdersBelongingToOrderid(Orderid);
		for (OrderItem orderItem : OrderItem) {
			Long Itemid = orderItem.getItemid();
			Item Item = itemDAO.read(Itemid);
			Cost += Item.getItemValue() * orderItem.getQuantity();
		}
		LOGGER.info(String.format("The total cost of the order with the ID: %x is $%s", Orderid,
				String.format("%.02f", Cost)));
		// get all children records and get the items id from that and add the price
		return Cost;
	}

	public int DeleteItemFromOrder() {
		LOGGER.info("What is the ID of the order that you want to delete an item from");
		Long Orderid = utils.getLong();
		LOGGER.info(
				"What is the id of the item that you would like to remove. If this item exists multiple times in an order all of the orders for that item will be removed.");
		Long Itemid = utils.getLong();
		int RecordsDeleted = OrderItemDAO.DeleteOrderItemUsingItemid(Itemid, Orderid);
		LOGGER.info(String.format("Item ID: %d was removed from Order ID: %d %d many times", Itemid, Orderid,
				RecordsDeleted));
		return RecordsDeleted;
	}

	public OrderItem AddItemToOrderItem() {
		LOGGER.info("What is the ID of the order that you want to add an item from");
		Long Orderid = utils.getLong();
		LOGGER.info("What is the id of the item that you would like to add to the order");
		Long Itemid = utils.getLong();
		LOGGER.info("How many items should be added to the order");
		Long Quantity = utils.getLong();
		OrderItem OrderAdded = orderItemDAO.AddItemToOrderItem(Orderid, Itemid, Quantity);
		LOGGER.info("Item added to the order");
		return OrderAdded;
	}
}
