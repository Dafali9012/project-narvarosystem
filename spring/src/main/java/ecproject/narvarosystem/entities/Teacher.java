package ecproject.narvarosystem.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    public Teacher(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @OneToOne(optional = false)
    @JoinColumn(name = "consult_id", referencedColumnName = "id", nullable = false)
    private Consult consult;


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Course> courses;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consult getConsult() {
        return consult;
    }

    public void setConsult(Consult consult) {
        this.consult = consult;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
