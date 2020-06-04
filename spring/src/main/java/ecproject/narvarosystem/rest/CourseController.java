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
    public List<Course> courses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Course> courseById(@PathVariable int id) {
        return courseRepository.findAllById(Collections.singleton(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseRepository.deleteById(id);
    }

    @GetMapping("/teacher/{id}")
    public List<Course> teacherCourse(@PathVariable int id) {
        return courseRepository.findAllByTeacher_id(id);
    }

    @GetMapping("/student/{id}")
    public List<Course> studentCourse(@PathVariable int id) {
        return courseRepository.findAllByStudent_id(id);
    }

    @GetMapping("/education/{id}")
    public List<Course> educationCourse(@PathVariable int id) {
        return courseRepository.findAllByEducation_id(id);
    }

    @GetMapping("/teacher/my/{id}")
    public List<Course> myID(@PathVariable int id) {
        return courseRepository.findAllByTeacherUserID(id);
    }
}
