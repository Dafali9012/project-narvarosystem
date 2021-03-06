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

    @Query(value = "SELECT * FROM attendance att INNER JOIN student st ON att.student_id = st.id INNER JOIN user us ON us.id = st.user_id WHERE us.id= :id", nativeQuery= true)
    List<Attendance> findAllByStudentUSER_id(int id);

    @Query(value = "SELECT * FROM attendance att INNER JOIN lecture lr ON att.lecture_id = lr.id INNER JOIN course cr ON cr.id = lr.course_id INNER JOIN teacher tr ON tr.id = cr.teacher_id INNER JOIN consult co ON co.id = tr.consult_id INNER JOIN user us ON us.id = co.user_id WHERE us.id = :id UNION SELECT * FROM attendance att INNER JOIN lecture lr ON  att.lecture_id = lr.id INNER JOIN course cr ON cr.id = lr.course_id INNER JOIN teacher tr ON tr.id = cr.teacher_id INNER JOIN ec_personnel ec ON ec.id = tr.ec_id INNER JOIN user us ON us.id = ec.user_id WHERE us.id = :id", nativeQuery= true)
    List<Attendance> findAllByTeacherUSER_id(int id);

    @Query(value = "SELECT * FROM attendance WHERE present= :integer ", nativeQuery= true)
    List<Attendance> findAllByPresent(int integer);

    @Query(value = "SELECT * FROM attendance att INNER JOIN lecture lr ON  att.lecture_id = lr.id INNER JOIN course cr ON lr.course_id=cr.id WHERE cr.id = :id", nativeQuery = true)
    List<Attendance> findAllByCourse_id(int id);

    @Query(value = "SELECT * FROM attendance att INNER JOIN lecture lr ON  att.lecture_id = lr.id INNER JOIN course cr ON lr.course_id = cr.id INNER JOIN class cl ON cr.education_id = cl.education_id WHERE cl.id = :id", nativeQuery = true)
    List<Attendance> findAllByClass_id(int id);



}
