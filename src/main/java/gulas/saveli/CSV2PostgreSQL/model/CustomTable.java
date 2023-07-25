package gulas.saveli.CSV2PostgreSQL.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    private String name;

    @OrderColumn
    private List<String> orderedKeys = new ArrayList<>();

    @OneToMany(mappedBy = "customTable", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "fieldName")
    @OrderBy("id")
    @ToString.Exclude
    private Map<String, List<DynamicField>> dynamicFields = new HashMap<>();
}
