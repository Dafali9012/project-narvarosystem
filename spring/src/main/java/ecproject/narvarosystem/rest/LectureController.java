package ecproject.narvarosystem.rest;


import ecproject.narvarosystem.Repository.LectureRepository;
import ecproject.narvarosystem.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lecture")

public class LectureController {
    @Autowired
    private LectureRepository lectureRepository;

    @GetMapping
    public List<Lecture> lectures() {
        return (List<Lecture>) this.lectureRepository.findAll();
    }
}