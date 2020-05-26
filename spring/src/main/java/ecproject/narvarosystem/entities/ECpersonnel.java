package ecproject.narvarosystem.entities;


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
    private Set<EdClass> edClasses;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
