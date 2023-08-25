package gulas.saveli.CSV2PostgreSQL.repo;

import gulas.saveli.CSV2PostgreSQL.model.DistinctName;
import gulas.saveli.CSV2PostgreSQL.model.DynamicCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistinctNameRepository extends JpaRepository<DistinctName, Long> {
    @Query("SELECT d FROM DistinctName d WHERE d.modelType = ?1")
    Optional<DistinctName> findByType(String typeString);
}
