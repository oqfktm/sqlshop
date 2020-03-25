package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ConnectionClass cn = new ConnectionClass();
    Connection connection = cn.getConnection();
    ObservableList<User> observableList = FXCollections.observableArrayList();
    @FXML
    TableView<User> tableView = new TableView();
    @FXML
    TableColumn<User, String> ID;
    @FXML
    TableColumn<User, String> Product;
    @FXML
    TableColumn<User, String> Price;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID.setCellValueFactory(new PropertyValueFactory("ID"));
        Product.setCellValueFactory(new PropertyValueFactory("Product"));
        Price.setCellValueFactory(new PropertyValueFactory("Price"));

        String sql = "select * from Products;";

        try {

            Statement statement = connection.createStatement();
            ID = new TableColumn<>("ID");
            Product = new TableColumn<>("Product");
            Price = new TableColumn<>("Price");

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Product = rs.getString("Product");
                String Price = rs.getString("Price");

                observableList.add(new User(ID, Product, Price));
            }



        } catch(SQLException e){
            e.printStackTrace();
        }
        tableView.setItems(observableList);
    }
}