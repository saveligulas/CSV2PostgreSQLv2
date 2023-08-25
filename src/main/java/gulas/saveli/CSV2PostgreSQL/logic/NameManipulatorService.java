package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DistinctName;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.model.enums.ModelType;
import gulas.saveli.CSV2PostgreSQL.repo.DistinctNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NameManipulatorService {
    @Autowired
    private final DistinctNameRepository nameRepository;

    public Optional<DynamicCategory> saveUniqueName(DynamicCategory category) {
        Optional<DistinctName> distinctNameOptional = nameRepository.findByTypeAndName(ModelType.DYNAMIC_CATEGORY.toString(), category.getName());
        distinctNameOptional.ifPresent(value -> category.setName(encryptString(value)));
        if (distinctNameOptional.isPresent()) {
            return Optional.of(category);
        }

        return Optional.empty();
    }

    public void saveUniqueName(CustomTable table) {

    }

    public String getOriginalName(DynamicCategory dynamicCategory) {

    }

    public String getOriginalName(CustomTable customTable) {

    }

    private String encryptString(DistinctName distinctName) {
        Long uses = distinctName.getUses();
        distinctName.setUses(uses + 1L);
        nameRepository.save(distinctName);
    }

    private String decodeString(DistinctName distinctName) {

    }
}
