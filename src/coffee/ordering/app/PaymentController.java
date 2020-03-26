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
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nehal
 */
public class PaymentController implements Initializable {

    @FXML
    private Text amount;
    
    @FXML
    private ComboBox<String> paymentType = new ComboBox<>();

    @FXML
    private Button confirm = new Button(); 
    
    Statement statement;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connectDB();
        amount.setText(""+OrderController.amount);
        paymentType.getItems().addAll("Cash","Card","UPI");
    }    
    
    public void confirm() {
        String sql = "UPDATE `orders` SET `payment` = '"+paymentType.getValue()+"' WHERE `orders`.`phone` = '"+OrderController.phoneNo+"'";
        
        try {
            statement.executeUpdate(sql);
            
            Alert orderPlaced = new Alert(Alert.AlertType.INFORMATION);
            orderPlaced.setTitle("Order Placed");
            orderPlaced.setContentText("Your order is successfully placed!");
            orderPlaced.setHeaderText(null);
            orderPlaced.showAndWait();
            
            Stage stage = (Stage) confirm.getScene().getWindow();
            stage.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void connectDB() {
        
        //Connect to MySQL database
        try{
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/CoffeeDB","root","");
            System.out.println("Database successfully connected to payment page!");
            
            statement = dbConnection.createStatement();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
