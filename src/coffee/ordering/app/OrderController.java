/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.ordering.app;

import java.net.URL;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author nehal
 */
public class OrderController implements Initializable {
    
    @FXML
    public TextField quantity = new TextField();
    
    @FXML
    public ComboBox<String> coffeeType = new ComboBox<>();
    
    @FXML
    public CheckBox whippedCream = new CheckBox();
    
    @FXML
    public CheckBox chocolate = new CheckBox();
    
    @FXML
    public CheckBox nutella = new CheckBox();
    
    @FXML
    Button orderButton = new Button();
    
    @FXML
    Button clearButton = new Button();
    
    @FXML
    Button logout = new Button();
    
    Statement statement;
    public static int amount = 0;
    
    public static String phoneNo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Make a database connection
        connectDB();
        
        coffeeType.getItems().addAll("Iced Coffee (Rs. 30)","Espresso (Rs. 30)","Flat White (Rs. 30)", "Cafe Latte (Rs. 30)","Cappuccino (Rs. 30)","Americano (Rs. 30)","Cortado (Rs. 30)","Macchiato (Rs. 30)","Mocha (Rs. 30)");
    }
    
    public void connectDB() {
        
        //Connect to MySQL database
        try{
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/CoffeeDB","root","");
            System.out.println("Database successfully connected for order page!");
            
            statement = dbConnection.createStatement();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    public void order() {
        int wc=0,c=0,n=0;
        
        if(whippedCream.isSelected())
            wc=1;
        if(chocolate.isSelected())
            c=1;
        if(nutella.isSelected())
            n=1;
        
        amount += (30+(wc*10) + (c*10) + (n*10))*Integer.parseInt(quantity.getText());
        
        phoneNo = LoginController.phone;
        
        String sql = "INSERT INTO `orders` (`phone`, `type`, `quantity`, `whipped cream`, `chocolate`, "
                + "`nutella`, `amount`, `payment`, `delivery`) "
                + "VALUES ('"+phoneNo+"','"+coffeeType.getValue()+"', "
                + "'"+quantity.getText()+"',"
                + " '"+wc+"', '"+c+"',  '"+n+"', '"+amount+"', '"+null+"', '0')";
        
        try {
            //Write to database
            statement.executeUpdate(sql);
            
            //Create new window for payment
            Stage payment = new Stage();
            Pane root = new FXMLLoader().load(getClass().getResource("Payment.fxml"));
            payment.setScene(new Scene(root,1024,725));
            payment.setTitle("Order confirmation");
            payment.showAndWait();
            payment.setResizable(false);

            //Clear fields
            quantity.setText(null);
            whippedCream.setSelected(false);
            chocolate.setSelected(false);
            nutella.setSelected(false);
            coffeeType.setValue(null);
            amount=0;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    @FXML
    public void clear() {
        quantity.setText(null);
        whippedCream.setSelected(false);
        chocolate.setSelected(false);
        nutella.setSelected(false);
        coffeeType.setValue(null);
        amount=0;
    }
    
    @FXML
    public void logout() {
        try {
            Stage loginStage = new Stage();
            Pane root = new FXMLLoader().load(getClass().getResource("Login.fxml"));
            loginStage.setScene(new Scene(root,1024,725));
            loginStage.setTitle("Login");
            loginStage.show();
            loginStage.setResizable(false);
            Stage stage = (Stage) logout.getScene().getWindow();
            stage.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
