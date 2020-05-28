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
    CourseRepository courseRepository;

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping
    public List<Course> courses(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Course> courseById(@PathVariable int id){
        return (List<Course>) courseRepository.findAllById(Collections.singleton(id));
    }

    /*
    @GetMapping("{id}")
    public Iterable<Course> courseByID(@PathVariable long id){
        return this.courseRepository.findAllById(Collections.singleton(id));
    }
    @GetMapping("teacher/{id}")
    public Iterable<Course> getByTeacherID(@PathVariable int id){
        return this.courseRepository.findAllByTeacherId(id);
    }

  @GetMapping("/user/{id}")
    public Iterable<Course> courseByUserID(@PathVariable int id) {
      return this.courseRepository.findAllByUserId(id);
  }

     */
}
