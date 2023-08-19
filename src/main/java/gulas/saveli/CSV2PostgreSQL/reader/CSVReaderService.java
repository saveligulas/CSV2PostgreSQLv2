package gulas.saveli.CSV2PostgreSQL.reader;

import au.com.bytecode.opencsv.CSVReader;
import gulas.saveli.CSV2PostgreSQL.logic.CustomTableService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicCategoryService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicFieldService;
import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.model.DynamicField;
import gulas.saveli.CSV2PostgreSQL.repo.CustomTableRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CSVReaderService {
    @Autowired
    private final CustomTableService customTableService;
    @Autowired
    private final DynamicCategoryService categoryService;
    @Autowired
    private final DynamicFieldService fieldService;

    @Autowired
    private final CustomTableRepository customTableRepository;
    @Autowired
    private final DynamicCategoryRepository categoryRepository;

    private String createSourcePath(String fileNameWithoutExtension) {
        return "src/main/resources/files/" + fileNameWithoutExtension + ".csv";
    }
    public void readAndSaveCSVFile(String fileNameWithoutExtension) throws FileNotFoundException {
        String path = createSourcePath(fileNameWithoutExtension);
        CSVReader reader = new CSVReader(new FileReader(path));
        try {
            String[] headers = reader.readNext();
            Map<String, List<String>> columns = new HashMap<>();
            if (headers != null) {
                for (String header : headers) {
                    columns.put(header, new ArrayList<>());
                }
                String[] line;
                while ((line = reader.readNext()) != null) {
                    for (int i = 0; i < line.length; i++) {
                        String header = headers[i];
                        if (columns.containsKey(header)) {
                            columns.get(header).add(line[i]);
                        }
                    }
                }
                CustomTable table = customTableService.createSaveAndGetCustomTable(fileNameWithoutExtension, "csv");
                List<DynamicCategory> unsavedCategories = new ArrayList<>();
                for (String header : headers) {
                    DynamicCategory category = new DynamicCategory();
                    category.setName(header);
                    List<String> fieldStrings = columns.get(header);
                    List<DynamicField> unsavedFields = new ArrayList<>();
                    for (String field : fieldStrings) {
                        DynamicField dynamicField = new DynamicField();
                        dynamicField.setValue(field);
                        dynamicField.setDynamicCategory(category);
                        unsavedFields.add(dynamicField);
                    }
                    category.setDynamicFields(unsavedFields);
                    unsavedCategories.add(category);
                }
                categoryService.saveDynamicCategories(unsavedCategories, table);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
