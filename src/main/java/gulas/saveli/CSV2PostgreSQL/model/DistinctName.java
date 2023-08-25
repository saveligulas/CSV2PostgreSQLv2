package gulas.saveli.CSV2PostgreSQL.model;

import gulas.saveli.CSV2PostgreSQL.model.enums.ModelType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DistinctName {
    @Id
    @GeneratedValue
    private Long id;

    private Long uses;
    private ModelType modelType;
}
