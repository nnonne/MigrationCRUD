package db.service;
import dto.*;
import db.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String findMaxSalaryWorker = "sql/find_max_salary_worker.sql";
    private static final String findMaxProjectsClient = "sql/find_max_projects_client.sql";
    private static final String findLongestProject = "sql/find_longest_project.sql";
    private static final String findYoungestEldestWorkers = "sql/find_youngest_eldest_workers.sql";
    private static final String printProjectPrices = "sql/print_project_prices.sql";

    private final Connection connection = Database.getInstance().getConnection();
    public static String readFile(String filePath){
        String content = "";
        try {
            content = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList();
        String findWorkers = DatabaseQueryService.readFile(findMaxSalaryWorker);
        try(Statement statement = connection.createStatement()){
            ResultSet workers = statement.executeQuery(findWorkers);
            while (workers.next()) {
            MaxSalaryWorker worker = new MaxSalaryWorker(
                    workers.getString("name"),
                    workers.getInt("salary"));
            maxSalaryWorkers.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxSalaryWorkers;
    }

    public List<MaxProjectsClient> findMaxProjectsClient(){
        List<MaxProjectsClient> maxProjectsClients = new ArrayList();
        String findClients = DatabaseQueryService.readFile(findMaxProjectsClient);
        try(Statement statement = connection.createStatement()){
            ResultSet clients = statement.executeQuery(findClients);
            while (clients.next()) {
                MaxProjectsClient client = new MaxProjectsClient(
                        clients.getString("name"),
                        clients.getInt("project_count"));
                maxProjectsClients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxProjectsClients;
    }

    public List<LongestProject> findLongestProject(){
        List<LongestProject> longestProjects = new ArrayList();
        String findProjects= DatabaseQueryService.readFile(findLongestProject);
        try(Statement statement = connection.createStatement()){
            ResultSet projects = statement.executeQuery(findProjects);
            while (projects.next()) {
                LocalDate date1 = LocalDate.parse(projects.getString("start_date"));
                LocalDate date2 = LocalDate.parse(projects.getString("finish_date"));
                LongestProject project = new LongestProject(
                        projects.getString("name"),
                        (int) ChronoUnit.MONTHS.between(date1, date2));
                longestProjects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return longestProjects;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers(){
        List<YoungestEldestWorkers> youngestEldestWorkers= new ArrayList();
        String findWorkers = DatabaseQueryService.readFile(findYoungestEldestWorkers);
        try(Statement statement = connection.createStatement()){
            ResultSet workers = statement.executeQuery(findWorkers);
            while (workers.next()) {
                YoungestEldestWorkers worker = new YoungestEldestWorkers(
                        workers.getString("type"),
                        workers.getString("name"),
                        workers.getString("birthday"));
                youngestEldestWorkers.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return youngestEldestWorkers;
    }

    public List<ProjectPrices> printProjectPrices(){
        List<ProjectPrices> projectPrices= new ArrayList();
        String findPrices = DatabaseQueryService.readFile(printProjectPrices);
        try(Statement statement = connection.createStatement()){
            ResultSet prices = statement.executeQuery(findPrices);
            while (prices.next()) {
                ProjectPrices price = new ProjectPrices(
                        prices.getString("name"),
                        prices.getInt("price"));
                projectPrices.add(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectPrices;
    }
}
