Coverage: 70.5%
# Project Title

You are required to build an application that an end user can interact with via a CLI (Command Line Interface).
The application needs to be an Inventory Management System that utilises supporting tools, methodologies and technologies that encapsulate all fundamental modules covered during training.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

You will need an IDE that can handle JAVA code i recommend Eclipse.
If you wish to modify or interact with the database outside of what the application already does you will need an instillation of MySQL.
You will need Maven 3.6.3 since that is the version this application was built on. 
You will need Java 1.8 or higher up until Java 14.
A local instillation of Git

### Installing

Create a Git repository on GitHub.
Clone the Git repository onto your system.
Install Eclipse, JUnit, Maven.
Open Eclipse and import the forked Git Repository starter given to us by QA.
Install MySQL.



## Running the tests

The application consists of 3 main entities that are Customer, Item and Order.

To start the application, run a test within the Runner class and then within the console enter in the following commands and so on.
To load the Customer entity, enter Customer.
You then have the option to either Create, Read, Update or Delete a Customer within the Customer entity by entering either 1 of those 4 words.
Create = First Name and Surname.
Delete = Customer ID.
Update = Customer ID and will then ask to give a new First Name and Surname.
Read = Read all Customers within that database.

This is the same for each entity, however each entity will have different attributes and ask for different inputs of data.
To return to the menu, enter Return.
Finally, to exit the application, enter STOP.

### Unit Tests 

My Unit Tests cover the Controllers, DAOs and the Objects for each system.
They test the behaviour of the Controllers and make sure that they work as expected.
They test the functionality of the DAOs and make sure they return the expected value based on what is entered.
They make sure that the objects return the correct type.

The test below is made using JUnit and Mockito and tests the delete function in the Order Controller.
It passes the ID 1 when asked for an ID and returns 1 for the number of records deleted using the delete function in the DAO
and then checks that the delete function does what I have defined aboved using 'assertEquals' to make sure everything works as expected.

For example: Long ID = 1L;

### And coding style tests

Mockito.when(utils.getLong()).thenReturn(ID);
Mockito.when(dao.delete(ID)).thenReturn(1);
Mockito.when(OrderItemDAO.DeleteOrderItemUsingOrderID(ID)).thenReturn(1);

assertEquals(ID, this.controller.delete());

Mockito.verify(utils, Mockito.times(1)).getLong();
Mockito.verify(dao, Mockito.times(1)).delete(ID);
Mockito.verify(OrderItemDAO, Mockito.times(1)).DeleteOrderItemUsingOrderID(ID);

## Deployment

Follow the steps within Getting Started and Installation. 
To deploy to a live server remove ``` drop schema `ims` ``` from the schema folder in main/resources this will make sure that the data isn't removed every time that application is launched.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

