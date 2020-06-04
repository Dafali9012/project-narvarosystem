package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAll();

    @Query(value = "SELECT * FROM course WHERE teacher_id = :id", nativeQuery= true)
    List<Course> findAllByTeacher_id(int id);

    @Query(value = "SELECT * FROM course cr INNER JOIN class cl ON cl.education_id = cr.education_id INNER JOIN student st ON st.class_id=cl.id WHERE st.id = :id" , nativeQuery = true)
    List<Course> findAllByStudent_id(int id);

    @Query( value = "SELECT * FROM course WHERE education_id = :id", nativeQuery = true)
    List<Course> findAllByEducation_id(int id);



}