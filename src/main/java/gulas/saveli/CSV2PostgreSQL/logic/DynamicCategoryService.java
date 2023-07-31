package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.errorHandler.handler.ApiRequestException;
import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.model.DynamicField;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicCategoryRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DynamicCategoryService {
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;

    public void createAndSaveDynamicCategory(String name, CustomTable table) {
        DynamicCategory category = new DynamicCategory();
        category.setName(name);
        category.setCustomTable(table);
        dynamicCategoryRepository.save(category);
    }

    @Transactional
    public void changeDynamicCategoryName(String name, Long id) {
        DynamicCategory category = dynamicCategoryRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Dynamic category with id " + id + " not found"));
        category.setName(name);
    }

    @Transactional
    public void addDynamicField(Long id, DynamicField field) {
        DynamicCategory category = dynamicCategoryRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Dynamic category with id " + id + " not found"));
        category.addDynamicField(field);
    }
}
