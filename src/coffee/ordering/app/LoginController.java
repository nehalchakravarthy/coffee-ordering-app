/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.ordering.app;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nehal
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username = new TextField();

    @FXML
    private PasswordField password = new PasswordField();

    @FXML
    private Button login = new Button();

    @FXML
    private Button signup = new Button();

    Statement statement;

    public static String phone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connectDB();
    }

    @FXML
    public void login() {
        String user = username.getText();
        String pass = password.getText();

        String sql = "SELECT * from users WHERE username = '" + user + "' and password = '" + pass + "'";

        try {
            if(user.equals("admin") && pass.equals("admin"))
            {
                Stage adminStage = new Stage();
                Pane root = FXMLLoader.load(getClass().getResource("Payment.fxml"));
                adminStage.setScene(new Scene(root, 1024, 725));
                adminStage.show();
                adminStage.setResizable(false);
            
                Stage stage = (Stage) signup.getScene().getWindow();
                stage.close();
            }
            else
            {
            ResultSet result = statement.executeQuery(sql);
            if (!result.next()) {
                Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                loginFailed.setTitle("Login Failed!");
                loginFailed.setContentText("Invalid username or password!");
                loginFailed.setHeaderText(null);
                loginFailed.showAndWait();
            } else {
                long ph;
                ph = result.getLong(1);
                phone = "" + ph;
                System.out.println(phone);

                Stage orderStage = new Stage();
                Pane root = FXMLLoader.load(getClass().getResource("Order.fxml"));
                orderStage.setScene(new Scene(root, 1420, 860));
                orderStage.show();
                orderStage.setResizable(false);

                Stage stage = (Stage) login.getScene().getWindow();
                stage.close();
            }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void signup() {
        try {
            Stage signupStage = new Stage();
            Pane root = FXMLLoader.load(getClass().getResource("register.fxml"));
            signupStage.setScene(new Scene(root, 1024, 725));
            signupStage.show();
            signupStage.setResizable(false);
            
            Stage stage = (Stage) signup.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void connectDB() {

        //Connect to MySQL database
        try {
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/CoffeeDB", "root", "");
            System.out.println("Database successfully connected for login page!");

            statement = dbConnection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
