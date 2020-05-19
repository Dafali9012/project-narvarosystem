package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Lecture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    List<Lecture> findAll();

    @Query(value="SELECT * FROM student st INNER JOIN class cl ON st.classID = cl.classID INNER JOIN course co ON cl.edID = co.edID INNER JOIN lecture le ON co.courseID = le.courseID WHERE st.studentID = :id", nativeQuery=true)
    List<Lecture> findAllByUserID(int id);
}
