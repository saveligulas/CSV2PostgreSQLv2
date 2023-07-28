package gulas.saveli.CSV2PostgreSQL.repo;

import gulas.saveli.CSV2PostgreSQL.model.CustomTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomTableRepository extends JpaRepository<CustomTable, Long> {
    @Query("SELECT c FROM CustomTable c WHERE c.name = :name")
    CustomTable findByName(@Param("name") String name);
}
