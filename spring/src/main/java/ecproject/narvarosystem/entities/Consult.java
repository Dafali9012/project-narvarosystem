package ecproject.narvarosystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "consult")
public class Consult {

    public Consult(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    /*@OneToOne(optional = false)
    @MapsId("user_id")
    private User user;*/

    /*@OneToOne(mappedBy = "consult")
    @JsonIgnore
    private Teacher teacher;*/

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    /*public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }*/
}

