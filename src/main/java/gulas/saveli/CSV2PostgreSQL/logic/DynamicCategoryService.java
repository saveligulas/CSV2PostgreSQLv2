package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicCategoryRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DynamicCategoryService {
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;

    public void createDynamicCategory(String name) {
        DynamicCategory dynamicCategory = new DynamicCategory();
        dynamicCategory.setName(name);
        dynamicCategoryRepository.save(dynamicCategory); //TODO not save if with same name exists
    }
}
