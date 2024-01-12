package guru.springframework.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "guru.springframework.webapp.repositories")
@ComponentScan(basePackages = "guru.springframework.webapp")
@EnableTransactionManagement
public class AppConfiguration {

}