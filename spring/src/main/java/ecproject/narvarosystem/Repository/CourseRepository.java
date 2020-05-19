package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();

    @Query(value = "SELECT * FROM course co INNER JOIN class cl ON co.EdID = cl.EdId INNER JOIN student st ON st.classID = cl.classID WHERE st.studentID = :id", nativeQuery= true)
    List<Course> findAllByUserId(int id);
}