package gulas.saveli.CSV2PostgreSQL.custom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CustomEntity {
    @Id
    @GeneratedValue
    private Long id;
}
