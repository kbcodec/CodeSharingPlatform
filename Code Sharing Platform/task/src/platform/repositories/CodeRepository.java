package platform.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.models.Code;

import java.util.List;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {
    Code findCodeById(long id);
    List<Code> findAll();
    List<Code> findTop10ByOrderByIdDesc();
}
