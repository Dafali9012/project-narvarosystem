package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
    List<Attendance> findAll();
}
