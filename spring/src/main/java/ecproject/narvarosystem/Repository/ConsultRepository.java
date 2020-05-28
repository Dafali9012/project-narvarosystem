package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Integer> {
    List<Consult> findAll();
}
