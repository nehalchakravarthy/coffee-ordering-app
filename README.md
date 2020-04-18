# Coffee Ordering App
A simple GUI application to implement Coffee ordering, developed using Java and JavaFX.

## Abstract
<p align="justify">The Coffee Ordering application is an application software made for the users of a coffee shop to pre-order their coffee and snacks with their personal choice of customisation. If the restaurant is overcrowded, customers will have to wait for a long time to order and to get the coffee they ordered. This application saves their precious time.</p>

<p align="justify">The software displays the menu of the coffee-shop with the prices associated and allows the user to order through an interactive and user-friendly UI. Any user using the application has to create an account and login in order to order their coffees. Once the user makes the choice of his/her order, he/she will be taken to a payment page, wherein the final bill amount will be displayed and the user will be given a choice for selecting the desired mode of payment. Once done, the order will be placed.Orders ordered by users can be managed by logging in as admin into the system. The admin user will have the rights to view all orders, mark an order as delivered and delete orders.</p>

<p align="justify">On implementing this application it can be seen that a lot of time and energy of a customer is saved. This application includes ordering features that make it easier for customers to pre-order and it can be further developed such that they can pay for their order in one simple transaction. This application improves the customers' ordering experience as it can showcase photos and descriptions of the products to them.</p>

## Objectives

- To provide the user with an interactive user interface to seamlessly order their favourite coffee in a couple of minutes.

- To create a system that communicates with the database effectively in order to update details and orders in real time.

- To provide a simple system to manage orders efficiently when logged in as the admin of the application, granting access to update and delete them.

## Methodology

- The application was originally developed using Apache Netbeans IDE.

- The user interface is created using JavaFX frameworks, using the scene builder component integrated with the IDE. The .fxml files contain the codes for UI.

- A controller file for each .fxml file contains the code that links the UI components with their functionalities.

- Java codes are written in the backend to implement all the functionalities and connect to the database. CoffeeOrderingApp.java file contains the main method and is used to run the application. It extends the class “Application”.

- XAMPP server solution is used to fire up Apache server, in order to link the application to a database created using Maria DB, a commercially supported fork of MySQL. The database can be accessed through the phpMyAdmin portal in the localhost.

- Regular expression is used to set conditions on the password when creating an account. The conditions set are there must be at least one uppercase letter, one lowercase letter and a digit with a length of 8-16 characters.

- Exceptions are handled using try-catch-finally blocks wherever necessary.

## Features

- User login and signup

- Simple order placing with the help of user-friendly UI.

- Manage orders option for admin.

## Instructions to run the application

1. Install XAMPP

2. Set username as "root" and password " " (blank)

3. Open localhost/phpmyadmin

4. Create a database named "CoffeeDB"

5. Create the following tables with the respective fileds:
    + users
        + phone     : bigint(10) - Primary Key
        + username  : varchar(10)
        + password  : varchar(20)
    + orders
        + phone         : varchar(20) - Primary Key
        + type          : varchar(25)
        + quantity      : int(2)
        + whipped cream : tinyint(1)/boolean
        + chocolate     : tinyint(1)/boolean
        + nutella       : tinyint(1)/boolean
        + amount        : int(4)
        + payment       : varchar(4)
        + delivery      : tinyint(1)/boolean

6. Run the application

5. To login as admin enter username and password as "admin"

## Future Scope

- The application works completely offline. It can be further extended to work online so that users can order from a remote place.

- A payment gateway can be integrated with the payment screen so that the user can complete his payment (for non-cash methods) before placing the order.

- The application can be developed and extended to mobile platforms like Android and iOS.

- New sections like “New Products”, “Favourites”, and “Special Deals” can be added so that the coffee shop can better promote its range.

- The application allows the customers to create their own account, which can be further utilised so that their menu preferences and payment details can be remembered; a useful function for regular customers.

## Screenshots

![Login](https://github.com/nehalchakravarthy/coffee-ordering-app/blob/master/src/coffee/ordering/app/screenshots/Login.png)

> Login Screen

![Signup](https://github.com/nehalchakravarthy/coffee-ordering-app/blob/master/src/coffee/ordering/app/screenshots/Sign%20up.png)

> Signup Screen

![Order menu](https://github.com/nehalchakravarthy/coffee-ordering-app/blob/master/src/coffee/ordering/app/screenshots/Order%20menu.png)

> Order Screen

![Payment](https://github.com/nehalchakravarthy/coffee-ordering-app/blob/master/src/coffee/ordering/app/screenshots/Payment.png)

> Payment Screen

![Manage Orders](https://github.com/nehalchakravarthy/coffee-ordering-app/blob/master/src/coffee/ordering/app/screenshots/Manage%20orders.png)

> Manage Orders Screen

##### Developed by Nehal Chakravarthy (@nehalchakravarthy)
