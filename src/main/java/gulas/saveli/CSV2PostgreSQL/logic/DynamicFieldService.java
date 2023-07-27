package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.model.DynamicField;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicCategoryRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DynamicFieldService {
    @Autowired
    private final DynamicFieldRepository dynamicFieldRepository;
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;

    public void createDynamicField(String value) { //TODO redo method
        DynamicField field = new DynamicField();
        field.setValues(List.of(value));
        dynamicFieldRepository.save(field);
    }
}
