package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@IdClass(Attendance.class)
@Table(name = "attendance")
public class Attendance implements Serializable {

    public Attendance(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "present")
    private Boolean present;


    @ManyToOne(optional = false)
    @MapsId("lecture_id")
    private Lecture lecture;


    @ManyToOne(optional = false)
    @MapsId("student_id")
    private Student student;

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}


