import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import staff.administration.Director;
import staff.administration.ProductChief;
import staff.administration.SalesChief;
import staff.specialists.prodaction.MachineOperator;
import staff.specialists.prodaction.Storekeeper;
import staff.specialists.sales.Merchandiser;
import staff.specialists.sales.SalesManager;

public class Main {
    public static void main(String[] args) {
//        MachineOperator machineOperator = new MachineOperator();
//        Storekeeper storekeeper = new Storekeeper();
//        SalesManager salesManager = new SalesManager();
//        Merchandiser merchandiser = new Merchandiser();
//        SalesChief salesChief = new SalesChief();
//
//        salesChief.setSalesManager(salesManager);
//        salesChief.setMerchandiser(merchandiser);
//
//        ProductChief productChief = new ProductChief();
//        productChief.setStorekeeper(storekeeper);
//        productChief.setMachineOperator(machineOperator);
//
//        Director director = new Director();
//        director.setSalesChief(salesChief);
//        director.setProductChief(productChief);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(".config");
        Director director = context.getBean(Director.class);
        director.manageCompany();
    }
}