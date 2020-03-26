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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nehal
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField username = new TextField();

    @FXML
    private TextField phone = new TextField();

    @FXML
    private PasswordField password = new PasswordField();

    @FXML
    private Button signup = new Button();

    @FXML
    private Button loginButton = new Button();
    
    Statement statement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connectDB();
    }    
    
    public void signup(){
        
        String sql = "INSERT INTO `users` (`phone`, `username`, `password`) VALUES ('"+phone.getText()+"', '"+username.getText()+"', '"+password.getText()+"')";
        try {
            statement.executeUpdate(sql);
            
            Alert orderPlaced = new Alert(Alert.AlertType.INFORMATION);
            orderPlaced.setTitle("User created");
            orderPlaced.setContentText("Your account has been created!\nPlease login to continue!");
            orderPlaced.setHeaderText(null);
            orderPlaced.showAndWait();
            
            Stage loginStage = new Stage();
            Pane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            loginStage.setScene(new Scene(root, 1024, 725));
            loginStage.show();
            loginStage.setResizable(false);
            
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();            
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    public void login() {
        try {
            Stage loginStage = new Stage();
            Pane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            loginStage.setScene(new Scene(root, 1024, 725));
            loginStage.show();
            loginStage.setResizable(false);
            
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void connectDB() {

        //Connect to MySQL database
        try {
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/CoffeeDB", "root", "");
            System.out.println("Database successfully connected for signup page!");

            statement = dbConnection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
