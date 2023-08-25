package gulas.saveli.CSV2PostgreSQL.repo;

import gulas.saveli.CSV2PostgreSQL.model.DistinctName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistinctNameRepository extends JpaRepository<DistinctName, Long> {
}
