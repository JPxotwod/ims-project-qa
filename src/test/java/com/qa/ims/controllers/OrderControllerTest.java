package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@Mock
	private OrderItemDAO OrderItemDAO;

	@Mock
	private ItemDAO ItemDAO;

	@Mock
	private Order OrderMock;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final long id = 1L;
		final long customerid = 1L; 
		final Order created = new Order(1L, 1L);

		Mockito.when(utils.getLong()).thenReturn(id, customerid);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
	    Order updated = new Order(1L, 2L);

//		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getId(), updated.getCustomerid());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
//		Mockito.verify(this.utils, Mockito.times(2)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long id = 1L;

		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(dao.delete(id)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(id);
	}
	
	@Test
	public void testCalculateCost() {
		List<OrderItem> OrderItemReturned = new ArrayList<>();
		OrderItemReturned.add(new OrderItem(1L, 1L, 1L));// Orderid, Itemid, Quantity

		Mockito.when(utils.getLong()).thenReturn(1l);// pass order 1l
		Mockito.when(OrderItemDAO.ReadAllOrdersBelongingToOrderid(1L)).thenReturn(OrderItemReturned);
		Mockito.when(ItemDAO.read(1l)).thenReturn(new Item("football", 19.99d));// pass item id 1

		assertEquals(19.99d * 1L, controller.CalculateCost(), 0.0002);

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(OrderItemDAO, Mockito.times(1)).ReadAllOrdersBelongingToOrderid(1L);
		Mockito.verify(ItemDAO, Mockito.times(1)).read(1l);
		
	}
	
	@Test
	public void testDeleteItemFromOrder() {
		
		Mockito.when(utils.getLong()).thenReturn(1L, 1L);
		Mockito.when(OrderItemDAO.DeleteOrderItemUsingItemid(1L, 1L)).thenReturn(1);

		assertEquals(1, controller.DeleteItemFromOrder());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(OrderItemDAO, Mockito.times(1)).DeleteOrderItemUsingItemid(1L, 1L);

	}

	@Test
	public void testAddItemFromOrder() {
		OrderItem Returns = new OrderItem(1L, 1L, 1L);
		Mockito.when(utils.getLong()).thenReturn(1L, 1L, 1L);// order, item, quantity
		Mockito.when(OrderItemDAO.AddItemToOrderItem(1L, 1L, 1L)).thenReturn(Returns);

		assertEquals(Returns, controller.AddItemToOrderItem());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(OrderItemDAO, Mockito.times(1)).AddItemToOrderItem(1L, 1L, 1L);
	}


}

