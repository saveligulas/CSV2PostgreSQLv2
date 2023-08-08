package gulas.saveli.CSV2PostgreSQL.config;

import gulas.saveli.CSV2PostgreSQL.logic.CustomTableService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicCategoryService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicFieldService;
import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.reader.TXTReaderService;
import gulas.saveli.CSV2PostgreSQL.repo.CustomTableRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicCategoryRepository;
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
    private final DynamicCategoryRepository dynamicCategoryRepository;

    @Autowired
    private final CustomTableService customTableService;
    @Autowired
    private final DynamicFieldService dynamicFieldService;
    @Autowired
    private final DynamicCategoryService dynamicCategoryService;
    @Autowired
    private final TXTReaderService txtReaderService;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            txtReaderService.readAndSaveTxtFile("src/main/resources/files/test.txt");
        };
    }
}
