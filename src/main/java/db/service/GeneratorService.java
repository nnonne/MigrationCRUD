package db.service;

import domains.*;

import java.util.ArrayList;
import java.util.List;

public class GeneratorService {
    public  List<Worker> generateWorkers(){
        List <Worker> workers = new ArrayList<>();
        workers.add(new Worker("Anna", "1976-01-01", "Middle", 5000));
        workers.add(new Worker("Brennan", "1984-02-02", "Junior", 1000));
        workers.add(new Worker("Candice", "1996-03-03", "Trainee", 500));
        workers.add(new Worker("Derek", "1997-03-03", "Middle", 1000));
        workers.add(new Worker("Evan", "1978-04-04", "Senior", 10000));
        workers.add(new Worker("Fred", "1979-05-05", "Senior", 1000));
        workers.add(new Worker("Grant", "1983-06-06", "Senior", 10000));
        workers.add(new Worker("Hanna", "1995-07-07", "Trainee", 500));
        workers.add(new Worker("Iris", "1991-08-08", "Trainee", 500));
        workers.add(new Worker("Julian", "1985-09-09", "Junior", 1000));
        workers.add(new Worker("Katie", "1979-10-10", "Middle", 5000));
        return workers;
    }
    public List<Client> generateClients(){
        List <Client> clients = new ArrayList<>();
        clients.add(new Client("Leia"));
        clients.add(new Client("Margaret"));
        clients.add(new Client("Neville"));
        clients.add(new Client("Owen"));
        clients.add(new Client("Peter"));
        return clients;
    }
    public  List<Project> generateProjects(){
        List <Project> projects = new ArrayList<>();
        projects.add(new Project("Project1", 1, "2023-01-01", "2023-02-01",1));
        projects.add(new Project("Project2", 2, "2023-01-01", "2023-03-01",2));
        projects.add(new Project("Project3", 3, "2023-01-01", "2023-04-01",3));
        projects.add(new Project("Project4", 4, "2023-01-01", "2023-05-01",4));
        projects.add(new Project("Project5", 4, "2023-01-01", "2023-06-01",5));
        projects.add(new Project("Project6", 1, "2023-01-01", "2023-07-01",6));
        projects.add(new Project("Project7", 2, "2023-01-01", "2023-08-01",7));
        projects.add(new Project("Project8", 2, "2023-01-01", "2023-09-01",8));
        projects.add(new Project("Project9", 4, "2023-01-01", "2023-10-01",9));
        projects.add(new Project("Project10", 5, "2023-01-01", "2023-10-01",9));
        return projects;
    }

    public List<ProjectWorker> generateProjectWorkers(){
        List<ProjectWorker> projectWorkers = new ArrayList<>();
        projectWorkers.add(new ProjectWorker(1, 1));
        projectWorkers.add(new ProjectWorker(1, 2));
        projectWorkers.add(new ProjectWorker(1, 3));
        projectWorkers.add(new ProjectWorker(1, 4));
        projectWorkers.add(new ProjectWorker(2, 4));
        projectWorkers.add(new ProjectWorker(2, 5));
        projectWorkers.add(new ProjectWorker(2, 6));
        projectWorkers.add(new ProjectWorker(2, 7));
        projectWorkers.add(new ProjectWorker(3, 8));
        projectWorkers.add(new ProjectWorker(4, 9));
        projectWorkers.add(new ProjectWorker(4, 10));
        projectWorkers.add(new ProjectWorker(4, 1));
        projectWorkers.add(new ProjectWorker(5, 4));
        projectWorkers.add(new ProjectWorker(5, 2));
        projectWorkers.add(new ProjectWorker(5, 3));
        projectWorkers.add(new ProjectWorker(6, 8));
        projectWorkers.add(new ProjectWorker(6, 3));
        projectWorkers.add(new ProjectWorker(6, 5));
        projectWorkers.add(new ProjectWorker(6, 7));
        projectWorkers.add(new ProjectWorker(6, 2));
        projectWorkers.add(new ProjectWorker(8, 9));
        projectWorkers.add(new ProjectWorker(8, 4));
        projectWorkers.add(new ProjectWorker(9, 3));
        projectWorkers.add(new ProjectWorker(9, 4));
        projectWorkers.add(new ProjectWorker(9, 1));
        projectWorkers.add(new ProjectWorker(9, 5));
        projectWorkers.add(new ProjectWorker(9, 6));
        projectWorkers.add(new ProjectWorker(10, 4));
        projectWorkers.add(new ProjectWorker(10, 5));
        projectWorkers.add(new ProjectWorker(10, 6));
        projectWorkers.add(new ProjectWorker(10, 7));
        projectWorkers.add(new ProjectWorker(10, 8));
        return projectWorkers;
    }

}
