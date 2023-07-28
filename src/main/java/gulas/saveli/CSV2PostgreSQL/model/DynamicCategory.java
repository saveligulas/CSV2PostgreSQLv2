package gulas.saveli.CSV2PostgreSQL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class DynamicCategory {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private List<DynamicField> dynamicFields = new ArrayList<>();
}
