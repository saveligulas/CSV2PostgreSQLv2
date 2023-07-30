package gulas.saveli.CSV2PostgreSQL.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "dynamic_category", schema = "converter")
public class DynamicCategory {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "customTable_id")
    private CustomTable customTable;

    @OneToMany(mappedBy = "dynamicCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn
    @ToString.Exclude
    private List<DynamicField> dynamicFields = new ArrayList<>();

    public void addDynamicField(DynamicField field) {
        this.dynamicFields.add(field);
    }
}
