package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.EducationRepository;
import ecproject.narvarosystem.entities.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    private EducationRepository educationRepository;

    @PostMapping
    public Education addEducation(@RequestBody Education education) {
        return educationRepository.save(education);
    }

    @GetMapping()
    public List<Education> educations() {
        return (List<Education>) this.educationRepository.findAll();
    }

    @GetMapping("{id}")
    public Iterable<Education> educationsById(@PathVariable long id) {
        return this.educationRepository.findAllById(Collections.singleton(id));
    }
}