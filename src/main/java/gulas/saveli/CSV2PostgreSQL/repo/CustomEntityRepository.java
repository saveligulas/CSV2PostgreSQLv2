package gulas.saveli.CSV2PostgreSQL.repo;

import gulas.saveli.CSV2PostgreSQL.custom.CustomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomEntityRepository extends JpaRepository<CustomEntity, Long> {
}
