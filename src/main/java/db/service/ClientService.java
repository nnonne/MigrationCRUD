package db.service;
import db.Database;
import entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    Connection connection = Database.getInstance().getConnection();

    private static final String createClient = "INSERT INTO client (name) VALUES (?)";
    private static final String getClientById = "SELECT name FROM client WHERE id = ?";
    private static final String setNameById = "UPDATE client SET name = ? WHERE id = ?";
    private static final String deleteClientById = "DELETE FROM client WHERE id = ?";
    private static final String listAllClients = "SELECT * FROM client";

    public long create(String name) {
        if (name.length() < 2 || name.length() >1000) throw new IllegalArgumentException("Length of a name should be between 2 and 1000");
        try (PreparedStatement queryStatement = connection.prepareStatement(createClient, Statement.RETURN_GENERATED_KEYS)) {
            queryStatement.setString(1, name);
            queryStatement.executeUpdate();
            ResultSet generatedKeys = queryStatement.getGeneratedKeys();
            generatedKeys.next();
            return generatedKeys.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public String getById(long id) {
        if (id <= 0) throw new IllegalArgumentException("Id should be bigger than zero");
        try (PreparedStatement queryStatement = connection.prepareStatement(getClientById)) {
            queryStatement.setLong(1, id);
            ResultSet client = queryStatement.executeQuery();
            return client.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setName(long id, String name) {
        if (id <= 0) throw new IllegalArgumentException("Id should be bigger than zero");
        if (name.length() < 2 || name.length() >1000) throw new IllegalArgumentException("Length of a name should be between 2 and 1000");
        try (PreparedStatement queryStatement = connection.prepareStatement(setNameById)) {
            queryStatement.setString(1, name);
            queryStatement.setLong(2, id);
            queryStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        if (id <= 0) throw new IllegalArgumentException("Id should be bigger than zero");
        try (PreparedStatement queryStatement = connection.prepareStatement(deleteClientById)) {
            queryStatement.setLong(1, id);
            queryStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> listAll() {
        List<Client> clientsList = new ArrayList<>();
        try (PreparedStatement queryStatement = connection.prepareStatement(listAllClients)) {
            ResultSet clients = queryStatement.executeQuery();
            while (clients.next()) {
                clientsList.add(new Client(clients.getLong("id"),clients.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientsList;
    }
}

