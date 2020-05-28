package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    List<ClassRoom> findAll();
    /*
    @Query(value = "SELECT * FROM class GROUP BY :edId",
    nativeQuery = true)
    List<ClassRoom> findAllByEducationId(long edId);


    @Query( value = " SELECT  * FROM class cl INNER JOIN course co ON co.EdID = cl.edID WHERE co.Teacher = :id GROUP BY cl.classID", nativeQuery= true)
    List<ClassRoom> findAllByUserId(int id);

     */
}
