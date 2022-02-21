package com.qa.ims.controllers;

import org.junit.Test;

import com.qa.ims.controller.Action;
import com.qa.ims.persistence.domain.Domain;

public class ActionTest {
	
	@Test(expected = Test.None.class)
	public void TestActionOrder() {
		Action.printActions(Domain.ORDER);
	}
	@Test(expected = Test.None.class)
	public void TestActionOrderNonOrder() {
		Action.printActions(Domain.CUSTOMER);
	
}



}
