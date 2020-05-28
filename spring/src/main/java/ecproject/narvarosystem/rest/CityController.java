package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.CityRepository;
import ecproject.narvarosystem.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityRepository cityRepository;

    @GetMapping
    public List<City> cities(){
        return (List<City>) cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<City> cityById(@PathVariable int id){
        return (List<City>) cityRepository.findAllById(Collections.singleton(id));
    }

    @PostMapping
    public City addCity(@RequestBody City city){
        return cityRepository.save(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable int id){
        cityRepository.deleteById(id);
    }

}
