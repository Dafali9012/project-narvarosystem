package ecproject.narvarosystem.rest;


import ecproject.narvarosystem.Repository.EdClassRepository;
import ecproject.narvarosystem.entities.Course;
import ecproject.narvarosystem.entities.EdClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/class")
public class EdClassController {
    @Autowired
    EdClassRepository eDClassRepository;

    @PostMapping
    public EdClass addEdClass(@RequestBody EdClass edclass){
        return eDClassRepository.save(edclass);
    }

    @GetMapping
    public List<EdClass> edclasses(){
        return this.eDClassRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<EdClass> edclasById(@PathVariable int id){
        return eDClassRepository.findAllById(Collections.singleton(id));
    }

    @DeleteMapping("/{id}")
    public void deleteEdClass(@PathVariable int id){
        eDClassRepository.deleteById(id);
    }

    @GetMapping("/manager/{id}")
    public List<EdClass> managerEdClass(@PathVariable int id){
        return eDClassRepository.findAllByManager_id(id);
    }

    @GetMapping("/education/{id}")
    public List<EdClass> educationEdClass(@PathVariable int id){
        return eDClassRepository.findAllByEducation_id(id);
    }

    @GetMapping("/teacher/my/{id}")
    public List<EdClass> teacherEdClass(@PathVariable int id){
        return eDClassRepository.findAllByTeacher_id(id);
    }



}