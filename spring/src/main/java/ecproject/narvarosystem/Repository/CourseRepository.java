package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAll();
    /*
    @Query(value = "SELECT * FROM course co INNER JOIN class cl ON co.EdID = cl.EdID INNER JOIN student st ON st.classID = cl.classID INNER JOIN user us ON us.userID = st.userID WHERE us.userID = :id", nativeQuery= true)
    List<Course> findAllByUserId(int id);

    @Query(value = "SELECT * FROM course WHERE Teacher = :id", nativeQuery= true)
    List<Course> findAllByTeacherId(int id);

     */
}