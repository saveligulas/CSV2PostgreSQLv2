package gulas.saveli.CSV2PostgreSQL.repo;

import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicCategoryRepository extends JpaRepository<DynamicCategory, Long> {
    @Query("SELECT d FROM DynamicCategory d WHERE d.name = :name")
    DynamicCategory findByName(@Param("name") String name);
}
