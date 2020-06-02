package ecproject.narvarosystem.Repository;


import ecproject.narvarosystem.entities.Course;
import ecproject.narvarosystem.entities.EdClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EdClassRepository extends JpaRepository<EdClass, Integer> {


    @Query(value = "SELECT * FROM class WHERE manager_id = :id", nativeQuery= true)
    List<EdClass> findAllByManager_id(int id);

    @Query(value = "SELECT * FROM class WHERE education_id = :id", nativeQuery= true)
    List<EdClass> findAllByEducation_id(int id);

    @Query(value = "SELECT * FROM class cr INNER JOIN class cl ON cl.education_id = cr.education_id INNER JOIN student st ON st.class_id=cl.id WHERE st.id = :id" , nativeQuery = true)
    List<Course> findAllByStudent_id(int id);
}
