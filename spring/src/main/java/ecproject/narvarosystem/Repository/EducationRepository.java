package ecproject.narvarosystem.Repository;


import ecproject.narvarosystem.entities.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends CrudRepository<Education, Integer> {
    Education findByName(String name);
    List<Education> findAllByName(String name);
    List<Education> findAll();
}
