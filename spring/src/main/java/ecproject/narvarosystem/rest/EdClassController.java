package ecproject.narvarosystem.rest;


import ecproject.narvarosystem.Repository.EdClassRepository;
import ecproject.narvarosystem.entities.EdClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class EdClassController {
    @Autowired
    private EdClassRepository eDClassRepository;

    @PostMapping
    public EdClass addEdClass(@RequestBody EdClass edclass){ return eDClassRepository.save(edclass);}


    @GetMapping
    public List<EdClass> edclasses(){
        return this.eDClassRepository.findAll();
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