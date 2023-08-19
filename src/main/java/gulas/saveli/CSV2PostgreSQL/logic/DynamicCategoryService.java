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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DynamicCategoryService {
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;
    private final DynamicFieldRepository dynamicFieldRepository;

    public void saveDynamicCategories(List<String> names, CustomTable table) { //REDO
        String finalName;
        List<DynamicCategory> dynamicCategories = new ArrayList<>();
        for (String name : names) {
            DynamicCategory category = new DynamicCategory(); //TODO put in seperate method to have option to save a single dynamic category
            category.setName(name);
            category.setCustomTable(table);
            dynamicCategories.add(category);
        }
        for (DynamicCategory dynamicCategory : dynamicCategories) {
            Optional<DynamicCategory> optional = dynamicCategoryRepository.findByName(dynamicCategory.getName());
            optional.ifPresent(category -> dynamicCategory.setName(manipulateName(category.getName()));
        }
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
