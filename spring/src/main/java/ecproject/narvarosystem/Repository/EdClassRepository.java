package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.EdClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EdClassRepository extends JpaRepository<EdClass, Integer> {


    /*
    @Query(value = "SELECT * FROM class GROUP BY :edId",
            nativeQuery = true)
    List<Class> findAllByEducationId(long edId);


    @Query( value = " SELECT  * FROM class cl INNER JOIN course co ON co.EdID = cl.edID WHERE co.Teacher = :id GROUP BY cl.classID", nativeQuery= true)
    List<Class> findAllByUserId(int id);
     */
}
