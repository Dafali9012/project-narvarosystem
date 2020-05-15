package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    User findByName(String name);
    List<User> findAllByName(String name);
    List<User> findAll();
    Optional<User> findByName(String name);
}

