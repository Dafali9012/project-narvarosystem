package ecproject.narvarosystem.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ec_personnel")
public class ECpersonnel {


    public ECpersonnel(){}

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "education", cascade = CascadeType.ALL)
    private Set<Education> educations;

    @OneToMany(mappedBy = "class", cascade = CascadeType.ALL)
    private Set<Class> classes;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }
}
