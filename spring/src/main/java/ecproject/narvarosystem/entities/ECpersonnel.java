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
    private int id;

    @OneToOne(optional = false)
    @MapsId("user_id")
    private User user;

    @OneToMany(mappedBy = "eCpersonnel", cascade = CascadeType.ALL)
    private Set<Education> educations;

    @OneToMany(mappedBy = "eCpersonnel", cascade = CascadeType.ALL)
    private Set<Class> classes;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }


    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }
}
