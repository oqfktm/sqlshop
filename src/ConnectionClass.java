import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public Connection getConnection(){


        Connection connection;
        String dbName = "PhoneShopDB";
        String user="root";
        String pass ="";

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/"+ dbName + " " + user + "");

            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
