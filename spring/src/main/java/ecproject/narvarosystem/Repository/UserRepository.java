package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    List<User> findAllByName(String name);
    List<User> findAll();

}

