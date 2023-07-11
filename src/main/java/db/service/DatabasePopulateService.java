package db.service;

import db.Database;
import domains.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.List;

public class DatabasePopulateService {
    private static final String insertWorker = "INSERT INTO worker (name, birthday, level, salary) VALUES (?,?,?,?)";
    private static final String insertClient = "INSERT INTO client (name) VALUES (?)";
    private static final String insertProject = "INSERT INTO project (name, client_id, start_date, finish_date, project_duration) VALUES (?,?,?,?,?)";
    private static final String insertProjectWorker = "INSERT INTO project_worker (project_id, worker_id) VALUES (?,?)";


    public static void populateDatabase(){
        Connection connection = Database.getInstance().getConnection();

        List<Worker> workers = new GeneratorService().generateWorkers();
        List<Client> clients = new GeneratorService().generateClients();
        List<Project> projects = new GeneratorService().generateProjects();
        List<ProjectWorker> projectWorkers = new GeneratorService().generateProjectWorkers();

        try(PreparedStatement queryStatementWorker = connection.prepareStatement(insertWorker)){
            for (Worker worker:workers) {
                queryStatementWorker.setString(1, worker.getName());
                queryStatementWorker.setString(2, worker.getBirthday());
                queryStatementWorker.setString(3, worker.getLevel());
                queryStatementWorker.setInt(4, worker.getSalary());
                queryStatementWorker.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement queryStatementClient = connection.prepareStatement(insertClient)){
            for (Client client:clients) {
                queryStatementClient.setString(1, client.getName());
                queryStatementClient.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement queryStatementProject = connection.prepareStatement(insertProject)){
            for (Project project:projects) {
                queryStatementProject.setString(1, project.getName());
                queryStatementProject.setInt(2, project.getClient_id());
                queryStatementProject.setString(3, project.getStart_date());
                queryStatementProject.setString(4, project.getFinish_date());
                queryStatementProject.setInt(5, project.getProject_duration());
                queryStatementProject.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement queryStatementProjectWorker = connection.prepareStatement(insertProjectWorker)){
            for (ProjectWorker projectWorker: projectWorkers) {
                queryStatementProjectWorker.setInt(1, projectWorker.getProjectId());
                queryStatementProjectWorker.setInt(2, projectWorker.getWorkerId());
                queryStatementProjectWorker.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
