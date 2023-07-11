package entities;

public class Worker {
    private long id;
    private String name;
    private final String birthday;
    private String level;
    private int salary;

    public Worker(String name, String birthday, String level, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLevel() {
        return level;
    }

    public int getSalary() {
        return salary;
    }

    public long getId() {
        return id;
    }
}
