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

    @Column(name = "education_id")
    private Integer education_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "education_id",nullable=false, insertable = false, updatable = false)
    //@JsonIgnore
    private Education educationOfClass;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", nullable=false, insertable = false, updatable = false)
    //@JsonIgnore
    private ECpersonnel classManager;

    @JsonIgnore
    @OneToMany(mappedBy = "EdClass", cascade = CascadeType.ALL)
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

    public Education getEducationOfClass() {
        return educationOfClass;
    }

    public void setEducationOfClass(Education educationOfClass) {
        this.educationOfClass = educationOfClass;
    }

    public ECpersonnel getClassManager() {
        return classManager;
    }

    public void setClassManager(ECpersonnel classManager) {
        this.classManager = classManager;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Integer getEducation_id() {
        return education_id;
    }

    public void setEducation_id(Integer education_id) {
        this.education_id = education_id;
    }
}
