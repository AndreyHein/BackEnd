package de.home.auto_service.configuration;

import de.home.auto_service.reposirory.AutoRepository;
import de.home.auto_service.reposirory.AutoRepositoryImpl;
import de.home.auto_service.reposirory.AutoRepositoryJDBCImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class AppConfiguration {
    @Value("${repository.type}")
    private String repositoryType;
    private final ConfigurableApplicationContext context;

    @Bean
    public AutoRepository actualRepository() {
        if (repositoryType.equalsIgnoreCase("list")) {
            return context.getBean(AutoRepositoryImpl.class);
        } else if (repositoryType.equalsIgnoreCase("jdbc")) {
            return context.getBean(AutoRepositoryJDBCImpl.class);
        }
        return null;
    }
}
