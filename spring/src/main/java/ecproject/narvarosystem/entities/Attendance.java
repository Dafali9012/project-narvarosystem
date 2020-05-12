package ecproject.narvarosystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attendanceID;

    @Column(name = "Status")
    private String status;

    @Column(name = "StudentID")
    private int studentId;

    @Column(name = "LectureID")
    private int lectureID;

    public Attendance(){}

    public long getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(long attendanceID) {
        this.attendanceID = attendanceID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLectureID() {
        return lectureID;
    }

    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }
}
