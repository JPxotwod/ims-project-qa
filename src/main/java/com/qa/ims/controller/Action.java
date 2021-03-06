package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.Domain;

import com.qa.ims.utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum Action {

	
	CREATE("To save a new entity into the database"), READ("To read an entity from the database"),
	UPDATE("To change an entity already in the database"), DELETE("To remove an entity from the database"),
	COST("To calculate the cost of an order"), DELETEITEM("To remove an item from an order"),
	ADDITEM("To add an item to an order"), RETURN("To return to domain selection");


	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	Action(String description) {
		this.description = description;
	}

	/**
	 * Describes the action
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints out all possible actions
	 */

	public static void printActions(Domain CurrentDomain) {
		for (Action action : Action.values()) {
			//this block of code checks makes sure update never shows up in order
			//and that add item delete item and cost never show outside of order
			if (CurrentDomain.name().equals("ORDER") && !action.equals(UPDATE)) {
				LOGGER.info(action.getDescription());
			} else if (!action.equals(Action.COST) && !action.equals(Action.DELETEITEM)
					&& !action.equals(Action.ADDITEM)) {
				if (CurrentDomain.name().equals("ORDER") && !action.equals(UPDATE)) {
					LOGGER.info(action.getDescription());
				}else if(!CurrentDomain.name().equals("ORDER")) {
					LOGGER.info(action.getDescription());
				}
			}


		}
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return Action type
	 */
	public static Action getAction(Utils utils) {
		Action action = null;
		do {
			try {
				action = Action.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (action == null);
		return action;
	}

}
