package ecproject.narvarosystem.Repository;
import ecproject.narvarosystem.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
   /* Education findByName(String name);
    List<Education> findAllByName(String name);
    List<Education> findAll();*/
}
