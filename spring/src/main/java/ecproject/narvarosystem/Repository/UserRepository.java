package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="SELECT * FROM user WHERE first_name = :firstName", nativeQuery=true)
    List<User> findAllByFirstName(String firstName);
    List<User> findAll();
    @Query(value="SELECT TOP 1 * FROM user WHERE first_name = :firstName", nativeQuery=true)
    Optional<User> findByFirstName(String firstName);

    @Query(value="SELECT * FROM user WHERE role_id = :id", nativeQuery=true)
    List<User> findAllByRoleId(int id);
}
