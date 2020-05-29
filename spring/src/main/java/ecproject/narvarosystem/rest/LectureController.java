package ecproject.narvarosystem.rest;


import ecproject.narvarosystem.Repository.LectureRepository;
import ecproject.narvarosystem.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lecture")

public class LectureController {
    @Autowired
    LectureRepository lectureRepository;

    @PostMapping
    public Lecture addLecture(@RequestBody Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @GetMapping
    public List<Lecture> lectures() {
        return lectureRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Lecture> LecturesById(@PathVariable int id) {
       return lectureRepository.findAllById(Collections.singleton(id));
    }

    @DeleteMapping("/{id}")
    public void deleteLecture(@PathVariable int id){
        lectureRepository.deleteById(id);
    }

    @GetMapping("/teacher/{id}")
    public List<Lecture> teacherLecture(@PathVariable int id){
        return lectureRepository.findAllByTeacher_id(id);
    }

    @GetMapping("/student/{id}")
    public List<Lecture> studentLecture(@PathVariable int id){
        return lectureRepository.findAllByStudent_id(id);
    }


}