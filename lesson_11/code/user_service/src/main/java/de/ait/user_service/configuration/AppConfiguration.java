package de.ait.user_service.configuration;

import de.ait.user_service.repository.UserRepository;
import de.ait.user_service.repository.UserRepositoryImpl;
import de.ait.user_service.repository.UserRepositoryJDBCImpl;
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
    public UserRepository actualRepository() {
        if (repositoryType.equalsIgnoreCase("list")) {
            return context.getBean(UserRepositoryImpl.class);
        } else {
            return context.getBean(UserRepositoryJDBCImpl.class);
        }
    }
}
