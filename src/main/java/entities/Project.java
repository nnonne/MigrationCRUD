package entities;

public class Project {
    private long id;
    private final String name;
    private final int clientId;
    private final String startDate;
    private final String finishDate;
    private final int projectDuration;

    public Project(String name, int clientId, String startDate, String finishDate, int projectDuration) {
        this.name = name;
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.projectDuration = projectDuration;
    }

    public String getName() {
        return name;
    }

    public int getClientId() {
        return clientId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public int getProjectDuration() {
        return projectDuration;
    }

    public long getId() {
        return id;
    }
}
