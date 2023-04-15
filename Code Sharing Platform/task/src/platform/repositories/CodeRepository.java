package platform.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.models.Code;
import platform.models.DTOs.CodeApiGetDto;

import java.util.List;
import java.util.UUID;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {
    Code findCodeById(UUID id);
    List<Code> findAll();
    @Query(value = "SELECT * FROM code.code WHERE is_time_restriction = false and is_views_restriction = false ORDER BY last_update DESC LIMIT 10", nativeQuery = true)
    List<Code> findLastTenCodes();

    Code findById(UUID id);
}
