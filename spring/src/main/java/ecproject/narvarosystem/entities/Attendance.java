package ecproject.narvarosystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    public Attendance(){}

    @Column(name = "present")
    private Boolean present;

    @Column(name = "lecture_id")
    private int lecture_id;

    @Column(name = "student_id")
    private int student_id;

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
