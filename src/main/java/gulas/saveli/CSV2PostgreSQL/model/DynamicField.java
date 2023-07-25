package gulas.saveli.CSV2PostgreSQL.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name= "main_table", schema= "converter")
public class DynamicField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fieldName;

    @ManyToOne
    @JoinColumn(name = "custom_entity_id") // This specifies the column with the foreign key to the main_table
    private CustomTable customTable;

    @OrderColumn
    private List<String> values;

}
