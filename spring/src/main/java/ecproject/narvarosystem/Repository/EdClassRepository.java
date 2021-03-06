package ecproject.narvarosystem.Repository;


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


    @Query(value = "SELECT * FROM class cl INNER JOIN course cr ON cr.education_id = cl.education_id INNER JOIN teacher tr ON tr.id = cr.teacher_id INNER JOIN consult co ON co.id = tr.consult_id INNER JOIN user us ON us.id = co.user_id WHERE us.id = :id UNION SELECT * FROM class cl INNER JOIN course cr ON cr.education_id = cl.education_id INNER JOIN teacher tr ON tr.id = cr.teacher_id INNER JOIN ec_personnel ec ON ec.id = tr.ec_id INNER JOIN user us ON us.id = ec.user_id WHERE us.id = :id", nativeQuery = true)
    List<EdClass> findAllByTeacher_id(int id);
}
