package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();
}