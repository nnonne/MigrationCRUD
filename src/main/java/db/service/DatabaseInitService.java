package db.service;

import db.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    private static final String initDB = "sql/init_db.sql";

    public void initDatabase(){
        Connection connection = Database.getInstance().getConnection();
        String init = DatabaseQueryService.readFile(initDB);
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(init);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
