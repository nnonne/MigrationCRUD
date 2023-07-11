package entities;

public class Client {
    private long id;
    private final String name;

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
