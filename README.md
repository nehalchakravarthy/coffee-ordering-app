# Coffee Ordering App
A simple GUI application to implement Coffee ordering, developed using Java and JavaFX.

## Abstract
The Coffee Ordering application is an application software made for the users of a coffee shop to pre-order their coffee and snacks with their personal choice of customisation. If the restaurant is overcrowded, customers will have to wait for a long time to order and to get the coffee they ordered. This application saves their precious time.

The software displays the menu of the coffee-shop with the prices associated and allows the user to order through an interactive and user-friendly UI. Any user using the application has to create an account and login in order to order their coffees. Once the user makes the choice of his/her order, he/she will be taken to a payment page, wherein the final bill amount will be displayed and the user will be given a choice for selecting the desired mode of payment. Once done, the order will be placed.Orders ordered by users can be managed by logging in as admin into the system. The admin user will have the rights to view all orders, mark an order as delivered and delete orders.

On implementing this application it can be seen that a lot of time and energy of a customer is saved. This application includes ordering features that make it easier for customers to pre-order and it can be further developed such that they can pay for their order in one simple transaction. This application improves the customers' ordering experience as it can showcase photos and descriptions of the products to them.

## Objectives
- To provide the user with an interactive user interface to seamlessly order their favourite coffee in a couple of minutes.

- To create a system that communicates with the database effectively in order to update details and orders in real time.

- To provide a simple system to manage orders efficiently when logged in as the admin of the application, granting access to update and delete them.

## Methodology
- The application is developed using Apache Netbeans IDE.

- The user interface is created using JavaFX frameworks, using the scene builder component integrated with the IDE. The .fxml files contain the codes for UI.

- XAMPP server solution is used to fire up Apache server, in order to link the application to a database created using Maria DB, a commercially supported fork of MySQL. The database can be accessed through the phpMyAdmin portal in the localhost.

- Java codes are written in the backend to implement all the functionalities and connect to the database. CoffeeOrderingApp.java file contains the main method and is used to run the application. It extends the class “Application”.

- A controller file for each .fxml file contains the code that links the UI components with their functionalities.

- Exceptions are handled using try-catch-finally blocks wherever necessary.

- Regular expression is used to set conditions on the password when creating an account.

## Future Scope
- The application works completely offline. It can be further extended to work online so that users can order from a remote place.

- A payment gateway can be integrated with the payment screen so that the user can complete his payment (for non-cash methods) before placing the order.

- The application can be developed and extended to mobile platforms like Android and iOS.

- New sections like “New Products”, “Favourites”, and “Special Deals” can be added so that the coffee shop can better promote its range.

- The application allows the customers to create their own account, which can be further utilised so that their menu preferences and payment details can be remembered; a useful function for regular customers.

## Screenshots
![](https://drive.google.com/uc?export=view&id=1uv22CatYHHto1T2NxVyMoyvj75quJ6LO)

> Login Screen

![](https://drive.google.com/uc?export=view&id=1Q6OVK2q9s_dhrv8B-cwKd6LAPP4-fywv)

> Signup Screen

![](https://drive.google.com/uc?export=view&id=1mkaPZS2GPlKHR3feVPeZk7pRNqnfMnYM)

> Order Screen

![](https://drive.google.com/uc?export=view&id=1a6Zo9U3e4lCej9sIQED2OJ8AuSOwaVk-)

> Payment Screen

![](https://drive.google.com/uc?export=view&id=1gp9vub6f3YV5lztJ_BRhc0K0uj9uHiWR)

> Manage Orders Screen

##### Developed by Nehal Chakravarthy (@nehalchakravarthy)
