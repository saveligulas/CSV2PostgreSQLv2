package gulas.saveli.CSV2PostgreSQL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DynamicField {
    @Id
    @GeneratedValue
    private Long id;


}
