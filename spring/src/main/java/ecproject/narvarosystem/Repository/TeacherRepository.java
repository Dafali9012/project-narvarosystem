package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.City;
import ecproject.narvarosystem.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    /*List<Teacher> findAll();*/


}
