package gulas.saveli.CSV2PostgreSQL.reader;

import au.com.bytecode.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CSVReaderService {

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

            }

        } catch (IOException e) {

        }
    }
}
