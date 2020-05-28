package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.City;
import ecproject.narvarosystem.entities.ECpersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ECpersonnelRepository extends JpaRepository<ECpersonnel, Integer> {
    /*List<ECpersonnel> findAll();*/

}