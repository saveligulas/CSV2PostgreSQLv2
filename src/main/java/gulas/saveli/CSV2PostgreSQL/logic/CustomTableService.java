package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.errorHandler.handler.ApiRequestException;
import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.model.DynamicField;
import gulas.saveli.CSV2PostgreSQL.repo.CustomTableRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicCategoryRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomTableService {
    @Autowired
    private final CustomTableRepository customTableRepository;
    @Autowired
    private final DynamicFieldRepository dynamicFieldRepository;
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;

    public void createAndSaveCustomTable(String name) {
        CustomTable table = new CustomTable();
        table.setName(name);
        customTableRepository.save(table);
    }

    @Transactional
    public void addDynamicCategory(DynamicCategory dynamicCategory, Long id) {
        CustomTable table = customTableRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Could not find CustomTable with id " + id + " could not be found"));
        table.addDynamicCategory(dynamicCategory);
    }

    public void changeName(String name, Long id) {
        CustomTable table = customTableRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Could not find CustomTable with id " + id + " could not be found"));
    }
}
