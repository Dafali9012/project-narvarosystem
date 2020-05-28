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

}
