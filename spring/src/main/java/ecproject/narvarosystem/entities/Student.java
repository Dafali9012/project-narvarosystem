package ecproject.narvarosystem.entities;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    public Student(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "picture")
    private String picture;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User userstudent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    private EdClass eclasses;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
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

    public User getUserstudent() {
        return userstudent;
    }

    public void setUserstudent(User userstudent) {
        this.userstudent = userstudent;
    }

    public EdClass getEclasses() {
        return eclasses;
    }

    public void setEclasses(EdClass eclasses) {
        this.eclasses = eclasses;
    }

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
}
