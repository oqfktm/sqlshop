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

    @FXML
    TextField idfield;
    @FXML
    TextField hodnota;

    @FXML protected void handleDeleteButtonAction(ActionEvent event) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int currentID = Integer.parseInt(idfield.getText());
            String currentHodnota = (hodnota.getText());

            String cmd1 = "update Products";
            String cmd2 = "set Product = " + currentHodnota;
            String cmd3 = "where ID = " + currentID;

            ResultSet set1 = statement.executeQuery(cmd1);
            ResultSet set2 = statement.executeQuery(cmd2);
            ResultSet set3 = statement.executeQuery(cmd3);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML protected void handleUpdateButtonAction(ActionEvent event2) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            int currentID = Integer.parseInt(idfield.getText());

            String deleteID = "delete from Products where ID=" + currentID + ";";
            ResultSet res1t = statement.executeQuery(deleteID);
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML protected void handleInsertButtonAction(ActionEvent event3) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String currentHodnota = (hodnota.getText());

            String insertcmd = "insert into Products (ProductName) values ('" + currentHodnota + "');";

            ResultSet res2t = statement.executeQuery(insertcmd);

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
}


