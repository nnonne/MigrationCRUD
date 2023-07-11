package domains;

public class Project {
    private String name;
    private int client_id;
    private String start_date;
    private String finish_date;
    private int project_duration;

    public Project(String name, int client_id, String start_date, String finish_date, int project_duration) {
        this.name = name;
        this.client_id = client_id;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.project_duration = project_duration;
    }

    public String getName() {
        return name;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getFinish_date() {
        return finish_date;
    }

    public int getProject_duration() {
        return project_duration;
    }
}
