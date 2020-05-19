package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.CourseRepository;
import ecproject.narvarosystem.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping
    public List<Course> courses(){
        return (List<Course>) this.courseRepository.findAll();
    }

    /*
    @GetMapping("{id}")
    public Iterable<Course> courseByID(@PathVariable long id){
        return this.courseRepository.findAllById(Collections.singleton(id));
    }
    */

  @GetMapping("/user/{id}")
    public Iterable<Course> courseByUserID(@PathVariable int id) {
      return this.courseRepository.findAllByUserId(id);
  }
}
