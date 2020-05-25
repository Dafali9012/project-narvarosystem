package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Attendance.class)
@Table(name = "attendance")
public class Attendance implements Serializable {

    public Attendance(){}

    @Column(name = "present")
    private Boolean present;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "lecture_id", referencedColumnName = "id", nullable = false)
    private Lecture lecture;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student student;

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
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
