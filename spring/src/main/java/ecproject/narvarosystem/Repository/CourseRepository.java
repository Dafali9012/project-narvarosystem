package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAll();

    @Query(value = "SELECT * FROM course WHERE teacher_id = :id", nativeQuery= true)
    List<Course> findAllByTeacher_id(int id);

    @Query(value = "SELECT * FROM course cr INNER JOIN class cl ON cl.education_id = cr.education_id INNER JOIN student st ON st.class_id=cl.id INNER JOIN user us ON us.id = st.user_id WHERE us.id = :id" , nativeQuery = true)
    List<Course> findAllByStudent_id(int id);

    @Query( value = "SELECT * FROM course WHERE education_id = :id", nativeQuery = true)
    List<Course> findAllByEducation_id(int id);

    @Query( value = "SELECT * FROM course cr INNER JOIN teacher tr ON tr.id = cr.teacher_id INNER JOIN consult co ON co.id = tr.consult_id INNER JOIN user us ON us.id = co.user_id WHERE us.id = :id UNION SELECT * FROM course cr INNER JOIN teacher tr ON tr.id = cr.teacher_id INNER JOIN ec_personnel ec ON ec.id = tr.ec_id INNER JOIN user us ON us.id = ec.user_id WHERE us.id = :id", nativeQuery = true)
    List<Course> findAllByTeacherUserID(int id);



}