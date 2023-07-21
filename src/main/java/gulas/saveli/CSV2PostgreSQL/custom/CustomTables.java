package gulas.saveli.CSV2PostgreSQL.custom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CustomTables {
    @Id
    @GeneratedValue
    private Long id;

    private Map<String, DynamicFieldEntity>
}
