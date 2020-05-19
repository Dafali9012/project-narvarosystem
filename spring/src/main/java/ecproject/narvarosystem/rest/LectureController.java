package ecproject.narvarosystem.rest;


import ecproject.narvarosystem.Repository.LectureRepository;
import ecproject.narvarosystem.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecture")

public class LectureController {
    @Autowired
    private LectureRepository lectureRepository;

    @PostMapping
    public Lecture addLecture(@RequestBody Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @GetMapping
    public List<Lecture> lectures() {
        return (List<Lecture>) this.lectureRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public List<Lecture> getLecturesByUserId(@PathVariable int id) {
        return lectureRepository.findAllByUserID(id);
    }
}