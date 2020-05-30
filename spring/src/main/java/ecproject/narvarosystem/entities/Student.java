package ecproject.narvarosystem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    public Student(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "picture")
    private String picture;

    @Column(name = "class_id")
    private Integer class_id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable=false)
    private User userstudent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "class_id",  nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private EdClass fuck;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Attendance> attendances;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setUserstudent(User userstudent) {
        this.userstudent = userstudent;
    }

    public User getUserstudent() {
        return userstudent;
    }


    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }



    public EdClass getFuck() {
        return fuck;
    }

    public void setFuck(EdClass fuck) {
        this.fuck = fuck;
    }
}
