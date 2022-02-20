package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();



	/**
	 * Reads all item orders from the database
	 * 
	 * @return A list of item orders
	 */
	public List<OrderItem> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items");) {
			List<OrderItem> orderitems = new ArrayList<>();
			while (resultSet.next()) {
				orderitems.add(modelFromResultSet(resultSet));
			}
			return orderitems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `order_items` ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			System.out.print(modelFromResultSet(resultSet));
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order in the database
	 * 
	 * @param order - takes in a order object. id will be ignored
	 */
	public OrderItem create(OrderItem orderitem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items (itemid, orderid, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, orderitem.getItemid());
			statement.setLong(2, orderitem.getOrderid());
			statement.setLong(3, orderitem.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return orderitem;
	}
@Override
	public OrderItem read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an item order in the database
	 * 
	 * @param item order - takes in a order object, the id field will be used to
	 *                 update that item order in the database
	 * @return
	 */
	public OrderItem update(OrderItem orderitem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_items SET itemid = ?, orderid = ? WHERE id = ?");) {
			statement.setLong(1, orderitem.getItemid());
			statement.setLong(2, orderitem.getOrderid());
			statement.executeUpdate();
			return orderitem;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an item order in the database
	 * 
	 * @param id - id of the order
	 */
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {//values read correctly here not hex
	
		Long Itemid = resultSet.getLong("itemid");
		Long Orderid = resultSet.getLong("orderid");
		Long Quantity = resultSet.getLong("quantity");
		
		return new OrderItem(Orderid, Itemid, Quantity);
	}

	public OrderItem ReadLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY orderid DESC LIMIT 1");) {
			resultSet.next();
			Long Itemid = resultSet.getLong("itemid");
			Long Orderid = resultSet.getLong("orderid");
			Long Quantity = resultSet.getLong("quantity");
			return new OrderItem(Orderid, Itemid, Quantity);
//			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public List<OrderItem> ReadAllOrdersBelongingToOrderid(Long orderid) {//This returns correct value as well
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM order_items WHERE orderid = ?");) {
			statement.setLong(1, orderid);
			List<OrderItem> OrderList = new ArrayList<>();
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					OrderList.add(modelFromResultSet(resultSet));
				}
			}
			return OrderList;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public int DeleteOrderItemUsingOrderid(Long Orderid) { 
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE orderid = ?");) {
			statement.setLong(1, Orderid); 
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;// no records deleted

	}
	
	public int DeleteOrderItemUsingItemid(Long Itemid, Long Orderid) { 
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE itemid = ? and orderid = ?");) {
			statement.setLong(1, Itemid); 
			statement.setLong(2, Orderid); 
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;// no records deleted

	}
	
	public OrderItem AddItemToOrderItem(Long Orderid, Long Itemid, Long Quantity) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO order_items (orderid, itemid, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, Orderid); 
			statement.setLong(2, Itemid); 
			statement.setLong(3, Quantity);
			statement.executeUpdate();
			return ReadLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}



}

