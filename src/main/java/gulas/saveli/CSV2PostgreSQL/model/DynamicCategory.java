package gulas.saveli.CSV2PostgreSQL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DynamicCategory {
    @Id
    @GeneratedValue
    private Long id;

    private String categoryName;
}
