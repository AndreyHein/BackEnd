package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import staff.administration.Director;
import staff.administration.ProductChief;
import staff.administration.SalesChief;
import staff.specialists.prodaction.MachineOperator;
import staff.specialists.prodaction.Storekeeper;
import staff.specialists.sales.Merchandiser;
import staff.specialists.sales.SalesManager;

@Configuration
public class AppConfiguration {

    @Bean
    public Director director() {
        return new Director();
    }

    @Bean
    public SalesChief salesChief() {
        return new SalesChief();
    }

    @Bean
    public ProductChief productChief() {
        return new ProductChief();
    }

    @Bean
    public MachineOperator machineOperator() {
        return new MachineOperator();
    }

    @Bean
    public Storekeeper storekeeper() {
        return new Storekeeper();
    }

    @Bean
    public Merchandiser merchandiser() {
        return new Merchandiser();
    }

    @Bean
    public SalesManager salesManager() {
        return new SalesManager();
    }
}
