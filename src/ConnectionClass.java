import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public static final String BLUE = "\u001B[34m";

    public Connection getConnection(){

        Connection connection = null;
        System.out.println(BLUE + "[SQL] Launching...");

        try {
            String dbName = "PhoneShopDB";
            String user="root";
            String pass ="";
            String URL = "jdbc:mysql://localhost:3308/" + dbName; // SET GLOBAL time_zone = '-1:00';

            System.out.println("[SQL] Connecting to jdbc:mysql://localhost:3308/ with user '" + user + "' (pass='" + pass + "')");
            System.out.println("[SQL] Selecting Database: " + dbName);

            connection = DriverManager.getConnection(URL,user,pass);
            System.out.println("[SQL] Connection created successfully.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
}
