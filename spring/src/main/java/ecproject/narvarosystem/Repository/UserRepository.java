package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
   //@Query(value="SELECT * FROM user WHERE first_name = :firstName", nativeQuery=true)
   // List<User> findAllByFirstName(String firstname);
    List<User> findAll();
  // @Query(value="SELECT TOP 1 * FROM user WHERE first_name = :firstName", nativeQuery=true)
   // List<User> findByFirstName(String firstname);
    User findByEmail(String email);
}
