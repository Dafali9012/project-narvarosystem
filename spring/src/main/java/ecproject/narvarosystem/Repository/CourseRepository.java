package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();

    @Query(value = "SELECT * FROM course co INNER JOIN class cl ON co.EdID = cl.EdID INNER JOIN student st ON st.classID = cl.classID INNER JOIN user us ON us.userID = st.userID WHERE us.userID = :id", nativeQuery= true)
    List<Course> findAllByUserId(int id);

    @Query(value = "SELECT * FROM course WHERE Teacher = :id", nativeQuery= true)
    List<Course> findAllByTeacherId(int id);
}