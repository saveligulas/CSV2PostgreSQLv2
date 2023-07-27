package gulas.saveli.CSV2PostgreSQL.logic;

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

    public void createCustomTable(List<String> fieldKeys, String name) {
        CustomTable customTable = new CustomTable();
        customTable.setOrderedKeys(fieldKeys);
        customTable.setName(name);
        customTableRepository.save(customTable);
    }

    @Transactional
    public void addDynamicFieldToTableTest(String name, Long fieldId, Long categoryId) {
        DynamicCategory dynamicCategory = dynamicCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("DynamicCategory could not be found"));
        DynamicField dynamicField = dynamicFieldRepository.findById(fieldId)
                .orElseThrow(() -> new RuntimeException("DynamicField could not be found"));
        CustomTable customTable = customTableRepository.findByName(name);
        if(customTable == null) {
            throw new RuntimeException("CustomTable could not be found");
        }

        customTable.getDynamicFields().put(dynamicCategory, dynamicField);
    }

    public void testCreateAndSaveCustomTable(String name, DynamicCategory category, DynamicField field) {
        CustomTable customTable = new CustomTable();
        customTable.setName(name);

    }
}
