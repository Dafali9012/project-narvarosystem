package ecproject.narvarosystem.rest;


import ecproject.narvarosystem.Repository.ClassRoomRepository;
import ecproject.narvarosystem.entities.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassRoomController {
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @PostMapping
    public ClassRoom addClassRoom(@RequestBody ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @GetMapping
    public List<ClassRoom> classRooms(){
        return this.classRoomRepository.findAll();
    }
    /*
    @GetMapping("/{id}")
    public Iterable<ClassRoom> getClassroomsById(@PathVariable long id) {
        return classRoomRepository.findAllById(Collections.singleton(id));
    }

    @GetMapping("/my/{id}")
    public Iterable<ClassRoom> getClassroomsByUserId(@PathVariable int id) {
        return classRoomRepository.findAllByUserId(id);
    }

    @GetMapping("/edu/{id}")
    public Iterable<ClassRoom> getClassroomsByEducationId(@PathVariable long id) {
        return classRoomRepository.findAllByEducationId(id);
    }
    */
}
