package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.StudentRepository;
import ecproject.narvarosystem.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> students(){
        return (List<Student>) this.studentRepository.findAll();
    }

    @GetMapping("{id}")
    public Iterable<Student> studentById(@PathVariable long id){
        return this.studentRepository.findAllById(Collections.singleton(id));
    }
}
