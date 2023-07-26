package gulas.saveli.CSV2PostgreSQL.repo;

import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicCategoryRepository extends JpaRepository<DynamicCategory, Long> {
    DynamicCategory findByName(String name);
}
