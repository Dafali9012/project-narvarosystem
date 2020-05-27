package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAll();
    @Query(value="SELECT * FROM student WHERE class_id = :id", nativeQuery=true)
    List<Student> findByClassId(int id);
}
