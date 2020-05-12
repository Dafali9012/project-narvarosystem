package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.CourseRepository;
import ecproject.narvarosystem.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> courses(){
        return (List<Course>) this.courseRepository.findAll();
    }
    @GetMapping("{id}")
    public Iterable<Course> courseByID(@PathVariable long id){
        return this.courseRepository.findAllById(Collections.singleton(id));
    }
}
