package gulas.saveli.CSV2PostgreSQL.reader;

import gulas.saveli.CSV2PostgreSQL.logic.CustomTableService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicCategoryService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicFieldService;
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

    private String createSourcePath(String fileNameWithoutExtension) {
        return "src/main/resources/files/" + fileNameWithoutExtension + ".txt";
    }
    public void readAndSaveTxtFile(String fileNameWithoutExtension) throws FileNotFoundException {
        FileReader fileReader = new FileReader(createSourcePath(fileNameWithoutExtension));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            service.createAndSaveCustomTable(fileNameWithoutExtension);
            se
            String line;
            while ((line = bufferedReader.readLine()) != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
