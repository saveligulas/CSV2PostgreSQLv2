package gulas.saveli.CSV2PostgreSQL.model;

import gulas.saveli.CSV2PostgreSQL.model.enums.ModelType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "distinct_name", schema = "converter")
public class DistinctName {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Long uses;

    @Enumerated(EnumType.STRING)
    private ModelType modelType;
}
