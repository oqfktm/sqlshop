import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

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

    @FXML
    TextField idfield;
    @FXML
    TextField hodnota;

    @FXML protected void handleUpdateButtonAction(ActionEvent event) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int currentID = Integer.parseInt(idfield.getText());
            String currentHodnota = (hodnota.getText());

            String cmd1 = "UPDATE Products";
            String cmd2 = "SET Product = " + "'" + currentHodnota + "'";
            String cmd3 = "WHERE ID = " + currentID + ";";

            boolean setT = statement.execute("UPDATE Products SET Product = " + "'" + currentHodnota + "'" + "WHERE ID = " + currentID + ";");
            // boolean set1 = statement.execute(cmd1);
            // boolean set2 = statement.execute(cmd2);
            // boolean set3 = statement.execute(cmd3);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML protected void handleDeleteButtonAction(ActionEvent event2) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            int currentID = Integer.parseInt(idfield.getText());

            String deleteID = "delete from Products where ID=" + currentID + ";";
            int exec_1 = statement.executeUpdate(deleteID);
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML protected void handleInsertButtonAction(ActionEvent event3) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String currentHodnota = (hodnota.getText());
            int currentID = Integer.parseInt(idfield.getText());

            String insertcmd = "insert into Products (ID, Product, Price)";
            String insertcmd2 = "values (" + currentID + ", '" + currentHodnota + "', 0);";

            int exec_2 = statement.executeUpdate(insertcmd + " " + insertcmd2);
           // int exec_3 = statement.executeUpdate(insertcmd2);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

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
                Double Price = rs.getDouble("Price");

                observableList.add(new User(ID, Product, Price));
            }



        } catch(SQLException e){
            e.printStackTrace();
        }
        tableView.setItems(observableList);
    }

    @FXML protected void handleREFRESH(ActionEvent eventR) {
        tableView.getItems().clear();

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
                Double Price = rs.getDouble("Price");

                observableList.add(new User(ID, Product, Price));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tableView.setItems(observableList);
        tableView.refresh();
    }
    }



