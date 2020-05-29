package ecproject.narvarosystem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ec_personnel")
public class ECpersonnel implements Serializable {

    public ECpersonnel(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User userec;

    @OneToOne(mappedBy = "eCpersonnel", cascade = CascadeType.ALL)
    @JsonIgnore
    private Teacher teacher;

   
    @OneToMany(mappedBy = "classManager", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<EdClass> edClasses;

    @OneToMany(mappedBy = "educationManager", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Education> educations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserec(User userec) {
        this.userec = userec;
    }

    public User getUserec() {
        return userec;
    }

    public Set<EdClass> getEdClasses() {
        return edClasses;
    }

    public void setEdClasses(Set<EdClass> edClasses) {
        this.edClasses = edClasses;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
