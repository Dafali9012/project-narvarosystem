package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAll();

    @Query(value="SELECT * FROM student WHERE class_id = :id", nativeQuery=true)
    List<Student> findByClassId(int id);

    @Query(value="SELECT * FROM student st INNER JOIN class cl ON st.class_id = cl.id INNER JOIN course cr On cl.education_id = cr.education_id WHERE cr.id = :id", nativeQuery=true)
    List<Student> findByCourse_id(int id);

    @Query(value="SELECT * FROM student st INNER JOIN class cl ON st.class_id = cl.id INNER JOIN education ed ON cl.education_id=ed.id WHERE ed.id= :id", nativeQuery=true)
    List<Student> findByEducation_id(int id);

    @Query(value = " SELECT * FROM student st INNER JOIN user us ON us.id = st.user_id WHERE us.id = :id", nativeQuery=true)
    List<Student> findByStudentUserId(int id);
}
