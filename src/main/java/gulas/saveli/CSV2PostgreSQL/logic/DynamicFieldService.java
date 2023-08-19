package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.errorHandler.handler.ApiRequestException;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.model.DynamicField;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicCategoryRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DynamicFieldService {
    @Autowired
    private final DynamicFieldRepository dynamicFieldRepository;
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;

    public void saveDynamicFields(List<DynamicField> fields, DynamicCategory category) { //REDO
        category.setDynamicFields(fields);
        dynamicCategoryRepository.save(category);
    }

    @Transactional
    public void changeDynamicFieldValue(String newValue, Long id) {
        DynamicField dynamicField = dynamicFieldRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("DynamicField with id " + id + " does not exist"));
        dynamicField.setValue(newValue);
    }
}
