package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.AttendanceRepository;
import ecproject.narvarosystem.entities.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @GetMapping
    public List<Attendance> classRooms(){
        return (List<Attendance>) this.attendanceRepository.findAll();
    }

}
