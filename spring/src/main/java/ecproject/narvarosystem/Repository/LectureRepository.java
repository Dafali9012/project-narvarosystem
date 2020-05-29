package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    List<Lecture> findAll();

    /*@Query(value="SELECT * FROM student st INNER JOIN class cl ON st.classID = cl.classID INNER JOIN course co ON cl.edID = co.edID INNER JOIN lecture le ON co.courseID = le.courseID WHERE st.studentID = :id", nativeQuery=true)
    List<Lecture> findAllByUserID(int id);*/
}
