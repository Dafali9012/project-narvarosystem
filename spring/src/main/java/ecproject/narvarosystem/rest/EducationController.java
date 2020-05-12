package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.EducationRepository;
import ecproject.narvarosystem.entities.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    private EducationRepository educationRepository;


    @GetMapping()
    public List<Education> educations() {
        return (List<Education>) this.educationRepository.findAll();
    }

    @GetMapping("{id}")
    public Iterable<Education> educationsById(@PathVariable long id) {
        return this.educationRepository.findAllById(Collections.singleton(id));
    }
}