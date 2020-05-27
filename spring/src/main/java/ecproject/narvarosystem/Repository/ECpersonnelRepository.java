package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.ECpersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ECpersonnelRepository extends JpaRepository<ECpersonnel, Integer> {

}
