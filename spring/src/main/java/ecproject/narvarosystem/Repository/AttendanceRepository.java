package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Attendance;
import ecproject.narvarosystem.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    List<Attendance> findAll();

    @Query(value = "SELECT * FROM attendance WHERE lecture_id= :id", nativeQuery= true)
    List<Attendance> findAllByLecture_id(int id);

    @Query(value = "SELECT * FROM attendance WHERE student_id= :id", nativeQuery= true)
    List<Attendance> findAllByStudent_id(int id);

    @Query(value = "SELECT * FROM attendance WHERE present= :integer ", nativeQuery= true)
    List<Attendance> findAllByPresent(int integer);

    @Query(value = "SELECT * FROM attendance att INNER JOIN lecture lr ON  att.lecture_id = lr.id INNER JOIN course cr ON lr.course_id=cr.id WHERE cr.id = :id", nativeQuery = true)
    List<Attendance> findAllByCourse_id(int id);

    @Query(value = "SELECT * FROM attendance att INNER JOIN lecture lr ON  att.lecture_id = lr.id INNER JOIN course cr ON lr.course_id = cr.id INNER JOIN class cl ON cr.education_id = cl.education_id WHERE cl.id = :id", nativeQuery = true)
    List<Attendance> findAllByClass_id(int id);



}
