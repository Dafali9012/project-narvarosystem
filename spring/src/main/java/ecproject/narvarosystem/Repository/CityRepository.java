package ecproject.narvarosystem.Repository;

import ecproject.narvarosystem.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
    /*List<City> findAll();*/

}
