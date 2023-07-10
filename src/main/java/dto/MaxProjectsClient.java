package dto;

public class MaxProjectsClient {
    public String name;
    public int projectCount;

    public MaxProjectsClient( String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectsClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
