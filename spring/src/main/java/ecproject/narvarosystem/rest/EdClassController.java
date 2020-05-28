package ecproject.narvarosystem.rest;


import ecproject.narvarosystem.Repository.EdClassRepository;
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

    @GetMapping
    public List<EdClass> edclasById(@PathVariable int id){
        return eDClassRepository.findAllById(Collections.singleton(id));
    }

    @DeleteMapping("/{id]")
    public void deleteEdClass(@PathVariable int id){
        eDClassRepository.deleteById(id);
    }





    /*
    @GetMapping("/{id}")
    public Iterable<ClassRoom> getClassroomsById(@PathVariable long id) {
        return classRoomRepository.findAllById(Collections.singleton(id));
    }

    @GetMapping("/my/{id}")
    public Iterable<Class> getClassroomsByUserId(@PathVariable int id) {
        return classRoomRepository.findAllByUserId(id);
    }

    @GetMapping("/edu/{id}")
    public Iterable<Class> getClassroomsByEducationId(@PathVariable long id) {
        return classRoomRepository.findAllByEducationId(id);
    }
    */

}