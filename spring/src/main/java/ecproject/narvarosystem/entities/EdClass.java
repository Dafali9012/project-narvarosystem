package ecproject.narvarosystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name ="class")
public class EdClass {

    public EdClass(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_id")
    private Integer manager_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "education_id",nullable=false)
    private Education educationclass;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", insertable = false, updatable = false)
    private ECpersonnel eCpersonnelclass;

    @OneToMany(mappedBy = "eclasses", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public Education getEducationclass() {
        return educationclass;
    }

    public void setEducationclass(Education educationclass) {
        this.educationclass = educationclass;
    }

    public ECpersonnel geteCpersonnelclass() {
        return eCpersonnelclass;
    }

    public void seteCpersonnelclass(ECpersonnel eCpersonnelclass) {
        this.eCpersonnelclass = eCpersonnelclass;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
