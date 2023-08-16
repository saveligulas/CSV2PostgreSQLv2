package gulas.saveli.CSV2PostgreSQL.reader;

import gulas.saveli.CSV2PostgreSQL.errorHandler.handler.ApiRequestException;
import gulas.saveli.CSV2PostgreSQL.logic.CustomTableService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicCategoryService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicFieldService;
import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.repo.CustomTableRepository;
import gulas.saveli.CSV2PostgreSQL.repo.DynamicCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TXTReaderService {
    @Autowired
    private final CustomTableService customTableService;
    @Autowired
    private final DynamicCategoryService dynamicCategoryService;
    @Autowired
    private final DynamicFieldService dynamicFieldService;
    @Autowired
    private final CustomTableRepository customTableRepository;
    @Autowired
    private final DynamicCategoryRepository dynamicCategoryRepository;

    private String createSourcePath(String fileNameWithoutExtension) {
        return "src/main/resources/files/" + fileNameWithoutExtension + ".txt";
    }
    public void readAndSaveTxtFile(String fileNameWithoutExtension) throws FileNotFoundException {
        FileReader fileReader = new FileReader(createSourcePath(fileNameWithoutExtension));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String categoryName = "TXT_Body";
        try {
            CustomTable table = customTableService.createSaveAndGetCustomTable(fileNameWithoutExtension, "txt");
            DynamicCategory category = dynamicCategoryService.createSaveAndGetDynamicCategory(categoryName, table);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            String text = builder.toString();
            dynamicFieldService.createAndSaveDynamicField(text, category);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
