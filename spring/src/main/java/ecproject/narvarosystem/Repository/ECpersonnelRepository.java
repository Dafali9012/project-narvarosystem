package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.ECpersonnel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ECpersonnelRepository extends CrudRepository<ECpersonnel, Integer> {
        List<ECpersonnel> findAll();
        }