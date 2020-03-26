/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.ordering.app;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nehal
 */
public class AdminController implements Initializable {

    @FXML
    private TableView<Model> orderTable;
    @FXML
    private TableColumn<Model, String> phone;
    @FXML
    private TableColumn<Model, String> type;
    @FXML
    private TableColumn<Model, String> quantity;
    @FXML
    private TableColumn<Model, String> wc;
    @FXML
    private TableColumn<Model, String> c;
    @FXML
    private TableColumn<Model, String> n;
    @FXML
    private TableColumn<Model, String> amount;
    @FXML
    private TableColumn<Model, String> payment;
    @FXML
    private TableColumn<Model, String> delivered;
    @FXML
    private JFXButton clear;

    @FXML
    private JFXTextField phoneSearch;
    @FXML
    private CheckBox deliver;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton logout;

    Statement statement;

    ObservableList<Model> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Database successfully connected for admin page!");
        try {
            ResultSet res = connectDB().createStatement().executeQuery("SELECT * FROM orders");
            while (res.next()) {
                //oblist.add(new Model(res.getString("phone"),res.getString("type"),res.getString("quantity"),res.getString("whipped cream"),res.getString("chocolate")
                //,res.getString("nutella"),res.getString("amount"),res.getString("payment")));
                oblist.add(new Model(res.getString(1), res.getString(2), res.getInt(3), res.getBoolean(4), res.getBoolean(5),
                        res.getBoolean(6), res.getInt(7), res.getString(8), res.getBoolean(9)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        wc.setCellValueFactory(new PropertyValueFactory<>("wc"));
        c.setCellValueFactory(new PropertyValueFactory<>("c"));
        n.setCellValueFactory(new PropertyValueFactory<>("n"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        payment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        delivered.setCellValueFactory(new PropertyValueFactory<>("deliver"));

        orderTable.setItems(oblist);
    }

    public Connection connectDB() {

        //Connect to MySQL database
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/CoffeeDB", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    @FXML
    private void update() {
        String sql = "SELECT * FROM `orders` WHERE `orders`.`phone` = '" + phoneSearch.getText() + "'";
        try {
            ResultSet res = connectDB().createStatement().executeQuery(sql);
            if (res.next()) {
                if (deliver.isSelected()) {
                    try {
                        statement = connectDB().createStatement();
                        statement.executeUpdate("UPDATE `orders` SET `delivery` = '1' WHERE `orders`.`phone` = '" + phoneSearch.getText().toString() + "'");
                        refresh();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Order updated");
                        alert.setContentText("The selected order has been updated!");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Update failed");
                    alert.setContentText("No changes to update!");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Update failed");
                alert.setContentText("Order not found!");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void delete() {
        String sql = "SELECT * FROM `orders` WHERE `orders`.`phone` = '" + phoneSearch.getText() + "'";

        try {
            ResultSet res = connectDB().createStatement().executeQuery(sql);
            if (res.next()) {
                try {
                    statement = connectDB().createStatement();
                    statement.executeUpdate("DELETE FROM `orders` WHERE `orders`.`phone` = '" + phoneSearch.getText().toString() + "'");
                    refresh();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Order deleted");
                alert.setContentText("The selected order has been deleted!");
                alert.setHeaderText(null);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Delete Failed!");
                alert.setContentText("Order not found!");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void logout() {
        try {
            Stage loginStage = new Stage();
            Pane root = new FXMLLoader().load(getClass().getResource("Login.fxml"));
            loginStage.setScene(new Scene(root, 1024, 725));
            loginStage.setTitle("Login");
            loginStage.show();
            loginStage.setResizable(false);
            Stage stage = (Stage) logout.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void refresh() {
        orderTable.getItems().clear();

        try {
            ResultSet res = connectDB().createStatement().executeQuery("SELECT * FROM orders");
            while (res.next()) {
                //oblist.add(new Model(res.getString("phone"),res.getString("type"),res.getString("quantity"),res.getString("whipped cream"),res.getString("chocolate")
                //,res.getString("nutella"),res.getString("amount"),res.getString("payment")));
                oblist.add(new Model(res.getString(1), res.getString(2), res.getInt(3), res.getBoolean(4), res.getBoolean(5),
                        res.getBoolean(6), res.getInt(7), res.getString(8), res.getBoolean(9)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        wc.setCellValueFactory(new PropertyValueFactory<>("wc"));
        c.setCellValueFactory(new PropertyValueFactory<>("c"));
        n.setCellValueFactory(new PropertyValueFactory<>("n"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        payment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        delivered.setCellValueFactory(new PropertyValueFactory<>("deliver"));

        orderTable.setItems(oblist);
    }

    @FXML
    private void clear() {
        phoneSearch.setText(null);
    }

}
