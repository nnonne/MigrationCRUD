package db;
import java.sql.*;
import java.util.ResourceBundle;

public class Database {
    private static final Database db = new Database();
    private Connection connection;
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
    private static final String JDBC_URL = "jdbcURL";

    private Database() {
        try {
            connection = DriverManager.getConnection(resourceBundle.getString(JDBC_URL));
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
}


