package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.model.DynamicField;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DynamicFieldService {
    @Autowired
    private final DynamicFieldRepository dynamicFieldRepository;

    public void createDynamicField(String value) {
        DynamicField field = new DynamicField();
        field.setValue(value);
    }
}
