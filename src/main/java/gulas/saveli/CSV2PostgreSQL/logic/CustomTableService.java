package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.errorHandler.handler.ApiRequestException;
import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.repo.CustomTableRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicCategoryRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CustomTableService {
    @Autowired
    private final DynamicCategoryService categoryService;
    @Autowired
    private final NameManipulatorService nameManipulatorService;

    @Autowired
    private final CustomTableRepository customTableRepository;
    @Autowired
    private final DynamicFieldRepository dynamicFieldRepository;
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;

    public CustomTable createSaveAndGetCustomTable(String name, String extension) {
        String pattern = "\\.v\\d+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(name);
        if(m.find()) {
            throw new ApiRequestException("CustomTable name ends with a .v followed by a number");
        }

        CustomTable table = new CustomTable();
        table.setName(name);
        table.setExtension(extension);
        Optional<CustomTable> optional = nameManipulatorService.saveUniqueName(table);
        if(optional.isPresent()) {
            customTableRepository.save(optional.get());
            return customTableRepository.findByName(optional.get().getName())
                    .orElseThrow(() -> new ApiRequestException("Could not find CustomTable with name " + name));
        }
        customTableRepository.save(table);
        return customTableRepository.findByName(name)
                .orElseThrow(() -> new ApiRequestException("Could not find CustomTable with name " + name));
    }

    @Transactional
    public void addDynamicCategory(DynamicCategory dynamicCategory, Long id) {
        CustomTable table = customTableRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Could not find CustomTable with id " + id + " could not be found"));
        table.addDynamicCategory(dynamicCategory);
    }

    @Transactional
    public void changeName(String name, Long id) {
        CustomTable table = customTableRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Could not find CustomTable with id " + id + " could not be found"));
        table.setName(name);
    }
}
