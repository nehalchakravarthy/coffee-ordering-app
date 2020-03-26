/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.ordering.app;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    Statement statement;

    ObservableList<Model> oblist = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Connection dbConnection = connectDB();
        System.out.println("Database successfully connected for admin page!");
        try {
            ResultSet res = dbConnection.createStatement().executeQuery("SELECT * FROM orders");
            while(res.next())
            {
                //oblist.add(new Model(res.getString("phone"),res.getString("type"),res.getString("quantity"),res.getString("whipped cream"),res.getString("chocolate")
                        //,res.getString("nutella"),res.getString("amount"),res.getString("payment")));
                oblist.add(new Model(res.getString(1),res.getString(2),res.getInt(3),res.getBoolean(4),res.getBoolean(5)
                        ,res.getBoolean(6),res.getInt(7),res.getString(8)));
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
    
}