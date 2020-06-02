package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.AttendanceRepository;
import ecproject.narvarosystem.entities.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping
    public List<Attendance> attendances(){
        return attendanceRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Attendance> attendanceById(@PathVariable int id){
        return attendanceRepository.findAllById(Collections.singleton(id));
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable int id){
        attendanceRepository.deleteById(id);
    }

    @GetMapping("/student/{id}")
    public List<Attendance> studentAttendance(@PathVariable int id){
        return attendanceRepository.findAllByStudent_id(id);
    }

    @GetMapping("/lecture/{id}")
    public List<Attendance> lectureAttendance(@PathVariable int id){
        return attendanceRepository.findAllByLecture_id(id);
    }

    @GetMapping("/present/{integer}")
    public List<Attendance> presentAttendance(@PathVariable int integer){
        return attendanceRepository.findAllByPresent(integer);
    }

    @GetMapping("/course/{id}")
    public List<Attendance> courseAttendance(@PathVariable int id){
        return attendanceRepository.findAllByCourse_id(id);
    }

    @GetMapping("/class/{id}")
    public List<Attendance> classAttendance(@PathVariable int id){
        return attendanceRepository.findAllByClass_id(id);
    }

}
