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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DynamicCategoryService {
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;

    public void saveDynamicCategories(List<String> names, CustomTable table) { //REDO
        String finalName;
        for (String name : names) {
            DynamicCategory category = new DynamicCategory(); //
            Optional<DynamicCategory> optional = dynamicCategoryRepository.findByName(name);
            finalName = optional.map(dynamicCategory -> manipulateName(dynamicCategory.getName())).orElse(name);
            category.setName(name);
        }

        DynamicCategory category = new DynamicCategory();
        category.setName(finalName);
        category.setCustomTable(table);
        dynamicCategoryRepository.save(category);
        return dynamicCategoryRepository.findByName(finalName)
                .orElseThrow(() -> new ApiRequestException("Could not find dynamic category with name " + finalName));
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

    private String manipulateName(String name) {
        if (name.matches(".*\\.[0-9]+$")) {
            int lastIndex = name.lastIndexOf('.');
            String base = name.substring(0, lastIndex);
            int number = Integer.parseInt(name.substring(lastIndex + 1)) + 1;
            return base + "." + number;
        } else {
            return name + ".1";
        }
    }
}
