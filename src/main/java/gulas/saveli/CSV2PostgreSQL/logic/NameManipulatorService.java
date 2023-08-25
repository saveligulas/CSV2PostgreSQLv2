package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import gulas.saveli.CSV2PostgreSQL.repo.DistinctNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NameManipulatorService {
    @Autowired
    private final DistinctNameRepository nameRepository;

    public void saveUniqueName(String name) {

    }

    public String getOriginalName(DynamicCategory dynamicCategory) {

    }

    public String getOriginalName(CustomTable customTable) {

    }

    private String encryptString(String decryptedString) {

    }

    private String decodeString(String encryptedString) {

    }
}
