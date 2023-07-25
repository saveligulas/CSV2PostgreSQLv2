package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicField;
import gulas.saveli.CSV2PostgreSQL.repo.CustomTableRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addDynamicFieldToTable(String name, Long dynamicFieldId) {
        DynamicField dynamicField = dynamicFieldRepository.findById(dynamicFieldId)
                .orElseThrow(() -> new RuntimeException("DynamicField could not be found"));
    }
}
