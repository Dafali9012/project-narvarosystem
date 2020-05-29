package ecproject.narvarosystem.Repository;
import ecproject.narvarosystem.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
   /* Education findByName(String name);
    List<Education> findAllByName(String name);
    List<Education> findAll();*/

    @Query(value = "SELECT * FROM education WHERE manager_id = :id", nativeQuery= true)
    List<Education> findAllByManager_id(int id);

    @Query(value = "SELECT * FROM education WHERE city_id = :id", nativeQuery= true)
    List<Education> findAllByCAndCity_id(int id);



}
