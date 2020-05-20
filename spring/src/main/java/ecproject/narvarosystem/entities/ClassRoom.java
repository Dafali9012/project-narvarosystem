package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="class")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ClassID;
    @Column(name = "Name")
    private String name;
    @Column(name = "StartDate")
    private Date startDate;
    @Column(name = "EndDate")
    private Date endDate;
    @Column(name = "EdID")
    private int edID;
    @Column(name ="TeacherID")
    private int  teacherID;

    public ClassRoom(){}

    public ClassRoom(int edID){
        this.edID = edID;
    }

    public long getClassID() {
        return ClassID;
    }

    public void setClassID(long classID) {
        ClassID = classID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEdID() {
        return edID;
    }

    public void setEdID(int edID) {
        this.edID = edID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
