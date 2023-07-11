package db;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Database {
    private static final Database db = new Database();
    private Connection connection;
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
    private static final String JDBC_URL = "jdbcURL";

    private Database() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:./JDBC_HW4");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Database getInstance() {
        return db;
    }
    public Connection getConnection() {
        return connection;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}


