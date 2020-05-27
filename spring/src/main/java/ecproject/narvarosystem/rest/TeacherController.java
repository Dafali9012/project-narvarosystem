package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.AttendanceRepository;
import ecproject.narvarosystem.Repository.TeacherRepository;
import ecproject.narvarosystem.entities.Attendance;
import ecproject.narvarosystem.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping
    public List<Teacher> teachers(){
        return (List<Teacher>) this.teacherRepository.findAll();
    }
}
