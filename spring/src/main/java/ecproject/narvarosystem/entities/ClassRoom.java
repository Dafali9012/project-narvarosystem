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
    @Column(name = "EdId")
    private int edID;

    public ClassRoom(){}

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
}
