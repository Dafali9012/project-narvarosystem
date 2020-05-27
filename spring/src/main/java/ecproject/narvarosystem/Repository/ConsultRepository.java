package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Consult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultRepository extends CrudRepository<Consult, Integer> {
    List<Consult> findAll();
}
