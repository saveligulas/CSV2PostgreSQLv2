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
    private final CustomTableService service;
    @Autowired
    private final DynamicCategoryService dynamicCategoryService;
    @Autowired
    private final DynamicFieldService dynamicFieldService;
    public void readAndSaveTxtFile(String path) throws FileNotFoundException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
