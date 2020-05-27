package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.CityRepository;
import ecproject.narvarosystem.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityRepository cityRepository;


    @GetMapping
    public List<City> cities(){return (List<City>) this.cityRepository.findAll();}
}
