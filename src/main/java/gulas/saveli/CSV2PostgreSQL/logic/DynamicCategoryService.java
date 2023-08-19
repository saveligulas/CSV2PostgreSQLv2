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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DynamicCategoryService {
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;
    @Autowired
    private final CustomTableRepository customTableRepository;

    public void saveDynamicCategories(List<DynamicCategory> categories, CustomTable table) {
        for (DynamicCategory category : categories) {
            Optional<DynamicCategory> optional = dynamicCategoryRepository.findByName(category.getName());
            optional.ifPresent(body -> category.setName(manipulateName(body.getName())));
        }
        table.setDynamicCategories(categories);
        customTableRepository.save(table);
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

    public String manipulateName(String name) {
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
