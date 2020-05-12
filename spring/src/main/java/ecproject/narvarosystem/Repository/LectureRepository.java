package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Lecture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    List<Lecture> findAll();
}
