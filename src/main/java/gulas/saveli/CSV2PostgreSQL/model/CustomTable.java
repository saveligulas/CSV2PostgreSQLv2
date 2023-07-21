package gulas.saveli.CSV2PostgreSQL.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name= "main_table", schema= "converter")
public class CustomTable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "customTable", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "fieldName")
    @OrderBy("id")
    private Map<String, List<DynamicField>> dynamicFields = new HashMap<>();
}
