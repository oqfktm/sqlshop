import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public Connection getConnection(){


        Connection connection = null;

        try {
            String dbName = "PhoneShopDB";
            String user="root";
            String pass ="";
            String URL = "jdbc:mysql://localhost:3308/PhoneShopDB"; // SET GLOBAL time_zone = '-1:00';

            connection = DriverManager.getConnection(URL,user,pass);
            System.out.println("Connection Created");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
}
