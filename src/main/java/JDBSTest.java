import db.service.DatabaseInitService;
import db.service.DatabasePopulateService;
import db.service.DatabaseQueryService;

public class JDBSTest {
    public static void main(String[] args) {
        DatabaseInitService databaseInitService = new DatabaseInitService();
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        databaseInitService.initDatabase();
        databasePopulateService.populateDatabase();

        System.out.println(databaseQueryService.findLongestProject());
        System.out.println(databaseQueryService.findMaxProjectsClient());
        System.out.println(databaseQueryService.findMaxSalaryWorker());
        System.out.println(databaseQueryService.printProjectPrices());
        System.out.println(databaseQueryService.findYoungestEldestWorkers());
    }
}
