package gulas.saveli.CSV2PostgreSQL.reader;

import gulas.saveli.CSV2PostgreSQL.logic.CustomTableService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicCategoryService;
import gulas.saveli.CSV2PostgreSQL.logic.DynamicFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TXTReaderService {
    @Autowired
    private final CustomTableService service;
    @Autowired
    private final DynamicCategoryService dynamicCategoryService;
    @Autowired
    private final DynamicFieldService dynamicFieldService;
    public void readAndSaveTxtFile(String path) {

    }
}
