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
@Table(name= "custom_table", schema= "converter", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class CustomTable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String extension;

    @OneToMany(mappedBy = "customTable", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OrderColumn
    @ToString.Exclude
    private List<DynamicCategory> dynamicCategories = new ArrayList<>();

    public void addDynamicCategory(DynamicCategory category) {
        this.dynamicCategories.add(category);
    }
}
