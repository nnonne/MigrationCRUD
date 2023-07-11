import db.service.ClientService;
import org.flywaydb.core.Flyway;


public class JDBSTest {

    public static void main(String[] args) {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:./JDBC_HW4", null, null)
                .load();

        flyway.migrate();

        ClientService clientService = new ClientService();
        System.out.println(clientService.create("Ann"));
        //System.out.println(clientService.getById(-1));
        System.out.println(clientService.getById(1));
        System.out.println(clientService.listAll());
        //System.out.println(clientService.getById(100));
        //clientService.setName(-1, "Bill");
        //clientService.setName(100, "Bill");
        clientService.setName(1, "Bill");
        System.out.println(clientService.listAll());
        clientService.deleteById(1);
        //.deleteById(-1);
        //clientService.deleteById(100);
        System.out.println(clientService.listAll());
    }
}

