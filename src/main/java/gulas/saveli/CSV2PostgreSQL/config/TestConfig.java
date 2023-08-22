package gulas.saveli.CSV2PostgreSQL.config;

import gulas.saveli.CSV2PostgreSQL.logic.CustomTableService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicCategoryService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicFieldService;
import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.reader.CSVReaderService;
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
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class TestConfig {
    @Autowired
    private final CustomTableRepository customTableRepository;
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;
    @Autowired
    private final DynamicFieldRepository dynamicFieldRepository;

    @Autowired
    private final CustomTableService customTableService;
    @Autowired
    private final DynamicFieldService dynamicFieldService;
    @Autowired
    private final DynamicCategoryService dynamicCategoryService;
    @Autowired
    private final TXTReaderService txtReaderService;
    @Autowired
    private final CSVReaderService csvReaderService;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            csvReaderService.readAndSaveCSVFile("organizations-100");
//            Optional<CustomTable> optional = customTableRepository.findById(352L);
//            optional.ifPresent(body -> System.out.println(body.getDynamicCategories()));
        };
    }
}
