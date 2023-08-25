package gulas.saveli.CSV2PostgreSQL.logic;

import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import gulas.saveli.CSV2PostgreSQL.model.DistinctName;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
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

    public void saveUniqueName(DynamicCategory category) {

        Optional<DistinctName> distinctNameOptional = nameRepository.findByTypeAndName()
    }

    public void saveUniqueName(CustomTable table) {

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
