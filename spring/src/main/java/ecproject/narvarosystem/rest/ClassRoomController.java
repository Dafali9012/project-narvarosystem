package ecproject.narvarosystem.rest;


import ecproject.narvarosystem.Repository.ClassRoomRepository;
import ecproject.narvarosystem.entities.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("classroom")
public class ClassRoomController {
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @GetMapping
    public List<ClassRoom> classRooms(){
        return (List<ClassRoom>) this.classRoomRepository.findAll();
    }

}
