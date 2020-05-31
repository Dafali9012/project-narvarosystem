package ecproject.narvarosystem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    public Teacher(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /*@JoinColumn(name = "consult_id", nullable = true)
    private Integer consult_id;

    @JoinColumn(name = "ec_id", nullable = true)
    private Integer ec_id;*/

    @OneToOne(optional = false)
    @JoinColumn(name = "consult_id", nullable = true, insertable = false, updatable = false)
    private Consult consult;

    @OneToOne(optional = false)
    @JoinColumn(name = "ec_id", nullable = true, insertable = false, updatable = false)
    private ECpersonnel eCpersonnel;


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Course> courses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setConsult(Consult consult) {
        this.consult = consult;
    }

    public Consult getConsult() {
        return consult;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public ECpersonnel geteCpersonnel() {
        return eCpersonnel;
    }

    public void seteCpersonnel(ECpersonnel eCpersonnel) {
        this.eCpersonnel = eCpersonnel;
    }

    /*public Integer getConsult_id() {
        return consult_id;
    }

    public void setConsult_id(Integer consult_id) {
        this.consult_id = consult_id;
    }

    public Integer getEc_id() {
        return ec_id;
    }

    public void setEc_id(Integer ec_id) {
        this.ec_id = ec_id;
    }*/
}
