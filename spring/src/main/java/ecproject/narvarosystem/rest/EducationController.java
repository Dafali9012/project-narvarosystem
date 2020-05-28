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
    EducationRepository educationRepository;


    @GetMapping()
    public List<Education> educations() {
        return educationRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Education> educationsById(@PathVariable int id) {
        return (List<Education>) educationRepository.findAllById(Collections.singleton(id));
    }

    @PostMapping
    public Education addEducation(@RequestBody Education education) {
        return educationRepository.save(education);
    }

    @DeleteMapping("/{id}")
    public void  deleteEducation(@PathVariable int id){
        educationRepository.deleteById(id);
    }



}