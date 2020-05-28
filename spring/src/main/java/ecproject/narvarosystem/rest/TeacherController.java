package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.TeacherRepository;
import ecproject.narvarosystem.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> teachers() {
        return teacherRepository.findAll();
    }
    @GetMapping("/{id}")
    public List<Teacher> teacherById(@PathVariable int id) {
        return teacherRepository.findAllById(Collections.singleton(id));
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id) {
        teacherRepository.deleteById(id);
    }
}
