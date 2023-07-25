package gulas.saveli.CSV2PostgreSQL.config;

import gulas.saveli.CSV2PostgreSQL.logic.CustomTableService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicFieldService;
import gulas.saveli.CSV2PostgreSQL.repo.CustomTableRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class TestConfig {
    @Autowired
    private final CustomTableRepository customTableRepository;
    @Autowired
    private final DynamicFieldRepository dynamicFieldRepository;

    @Autowired
    private final CustomTableService customTableService;
    @Autowired
    private final DynamicFieldService dynamicFieldService;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            dynamicFieldService.createDynamicField("testValue");
            customTableService.createCustomTable(List.of("testKey"), "testTable");
        };
    }
}
