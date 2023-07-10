package db.service;

import db.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    private static final String populateDB = "sql/populate_db.sql";
    public static void populateDatabase(){
        Connection connection = Database.getInstance().getConnection();
        String populate = DatabaseQueryService.readFile(populateDB);
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(populate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
