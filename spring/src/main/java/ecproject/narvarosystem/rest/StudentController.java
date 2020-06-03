package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.StudentRepository;
import ecproject.narvarosystem.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> students(){
        return this.studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Student> studentById(@PathVariable int id){
        return studentRepository.findAllById(Collections.singleton(id));
    }

    @GetMapping("/class/{id}")
    public List<Student> studentByClassId(@PathVariable int id) {
        return studentRepository.findByClassId(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student updatedStudent = studentRepository.findAllById(Collections.singleton(id)).get(0);
        if(student.getPicture()!=null)updatedStudent.setPicture(student.getPicture());
        // klass!
        return studentRepository.save(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/education/{id}")
    public List<Student> educationStudent(@PathVariable int id) {

        return studentRepository.findByEducation_id(id);
    }

    @GetMapping("/course/{id}")
    public List<Student> courseStudent(@PathVariable int id) {

        return studentRepository.findByCourse_id(id);
    }

    @GetMapping("/user/{id}")
    public List<Student> userStudent(@PathVariable int id) {
        return studentRepository.findByStudentUserId(id);
    }

}
