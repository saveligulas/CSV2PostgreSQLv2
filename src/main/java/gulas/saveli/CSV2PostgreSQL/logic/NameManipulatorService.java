package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.errorHandler.handler.ApiRequestException;
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
        DistinctName distinctName = new DistinctName();
        distinctName.setUses(1L);
        distinctName.setName(category.getName());
        distinctName.setModelType(ModelType.DYNAMIC_CATEGORY);
        nameRepository.save(distinctName);
        return Optional.empty();
    }

    public Optional<CustomTable> saveUniqueName(CustomTable table) {
        Optional<DistinctName> distinctNameOptional = nameRepository.findByTypeAndName(ModelType.CUSTOM_TABLE.toString(), table.getName());
        distinctNameOptional.ifPresent(value -> table.setName(encryptString(value)));
        if (distinctNameOptional.isPresent()) {
            return Optional.of(table);
        }
        DistinctName distinctName = new DistinctName();
        distinctName.setUses(1L);
        distinctName.setName(table.getName());
        distinctName.setModelType(ModelType.DYNAMIC_CATEGORY);
        nameRepository.save(distinctName);
        return Optional.empty();
    }

    public String getOriginalName(DynamicCategory dynamicCategory) {
        DistinctName distinctName = nameRepository.findByTypeAndName(ModelType.DYNAMIC_CATEGORY.toString(), dynamicCategory.getName())
                .orElseThrow(() -> new ApiRequestException("Could not find the original name"));
        return  decodeString(distinctName);
    }

    public String getOriginalName(CustomTable customTable) {
        DistinctName distinctName = nameRepository.findByTypeAndName(ModelType.CUSTOM_TABLE.toString(), customTable.getName())
                .orElseThrow(() -> new ApiRequestException("Could not find the original name"));
        return decodeString(distinctName);
    }

    private String encryptString(DistinctName distinctName) {
        Long uses = distinctName.getUses();
        distinctName.setUses(uses + 1L);
        nameRepository.save(distinctName);

        String originalName = distinctName.getName();
        return originalName + ".v" + uses.toString();
    }

    private String decodeString(DistinctName distinctName) {
        return distinctName.getName().replaceAll("\\.v\\d+$", "");
    }
}
