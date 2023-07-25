package gulas.saveli.CSV2PostgreSQL.config;

import gulas.saveli.CSV2PostgreSQL.repo.CustomTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TestConfig {
    @Autowired
    private final CustomTableRepository customTableRepository;

    @Bean
    CommandLineRunner commandLineRunner() {

    }
}
