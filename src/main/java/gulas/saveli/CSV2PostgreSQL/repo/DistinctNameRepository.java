package gulas.saveli.CSV2PostgreSQL.repo;

import gulas.saveli.CSV2PostgreSQL.model.DistinctName;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistinctNameRepository extends JpaRepository<DistinctName, Long> {
    @Query("SELECT d FROM DistinctName d WHERE d.modelType = ?1 AND d.name = :name")
    Optional<DistinctName> findByTypeAndName(String typeString, @Param("name") String name);
}
