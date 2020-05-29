package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    List<Lecture> findAll();

    /*@Query(value="SELECT * FROM student st INNER JOIN class cl ON st.classID = cl.classID INNER JOIN course co ON cl.edID = co.edID INNER JOIN lecture le ON co.courseID = le.courseID WHERE st.studentID = :id", nativeQuery=true)
    List<Lecture> findAllByUserID(int id);*/

    /* @Query(value = "SELECT * FROM attendance att INNER JOIN lecture lr ON  att.lecture_id = lr.id INNER JOIN course cr ON lr.course_id=cr.id WHERE cr.id = :id", nativeQuery = true)
    List<Attendance> findAllByCourse_id(int id); */

    @Query(value = " SELECT * FROM lecture lc INNER JOIN course cr ON lc.course_id = cr.id WHERE cr.teacher_id = :id", nativeQuery = true)
    List<Lecture> findAllByTeacher_id(int id);

    @Query(value = " SELECT * FROM lecture lc INNER JOIN course cr ON lc.course_id = cr.id INNER JOIN class cl ON cr.education_id = cl.education_id INNER JOIN student st ON st.class_id = cl.id WHERE st.id = :id", nativeQuery = true)
    List<Lecture> findAllByStudent_id(int id);


}
