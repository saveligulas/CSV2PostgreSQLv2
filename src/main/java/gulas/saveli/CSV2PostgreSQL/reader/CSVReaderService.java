package gulas.saveli.CSV2PostgreSQL.reader;

import au.com.bytecode.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CSVReaderService {

    private String createSourcePath(String fileNameWithoutExtension) {
        return "src/main/resources/files/" + fileNameWithoutExtension + ".csv";
    }
    public void readAndSaveCSVFile(String fileNameWithoutExtension) {
        String path = createSourcePath(fileNameWithoutExtension);

    }
}
