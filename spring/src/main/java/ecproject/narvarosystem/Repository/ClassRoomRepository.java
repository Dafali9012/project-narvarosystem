package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.ClassRoom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepository extends CrudRepository<ClassRoom, Long> {
    ClassRoom findByName(String name);
    List<ClassRoom> findAllByName(String name);
    List<ClassRoom> findAll();

    @Query(value = "SELECT * FROM class GROUP BY :edId",
    nativeQuery = true)
    List<ClassRoom> findAllByEducationId(long edId);
}
