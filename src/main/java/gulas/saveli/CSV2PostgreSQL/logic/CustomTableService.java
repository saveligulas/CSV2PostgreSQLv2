package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicField;
import gulas.saveli.CSV2PostgreSQL.repo.CustomTableRepository;
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

    public void createCustomTable(List<String> fieldKeys, String name) {
        CustomTable customTable = new CustomTable();
        customTable.setOrderedKeys(fieldKeys);
        customTable.setName(name);
        customTableRepository.save(customTable);
    }

    @Transactional
    public void addDynamicFieldToTableTest(String name, Long dynamicFieldId, String key) {
        DynamicField dynamicField = dynamicFieldRepository.findById(dynamicFieldId)
                .orElseThrow(() -> new RuntimeException("DynamicField could not be found"));
        CustomTable customTable = customTableRepository.findByName(name);
        if(customTable == null) {
            throw new RuntimeException("CustomTable could not be found");
        }

        customTable.getDynamicFields().put(key, List.of(dynamicField)); //TODO redo method with method to add to list
    }
}
