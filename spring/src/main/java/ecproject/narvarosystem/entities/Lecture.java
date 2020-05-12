package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lectureID;

    @Column(name = "Date")
    private Date date;

    @Column(name = "CourseID")
    private int courseId;

    public Lecture(){}

    public long getLectureID() {
        return lectureID;
    }

    public void setLectureID(long lectureID) {
        this.lectureID = lectureID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
