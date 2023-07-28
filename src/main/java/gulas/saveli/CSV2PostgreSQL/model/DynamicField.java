package gulas.saveli.CSV2PostgreSQL.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name= "dynamic_field", schema= "converter")
public class DynamicField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dynamic_category_id")
    private DynamicCategory dynamicCategory;

    private String value;

}
