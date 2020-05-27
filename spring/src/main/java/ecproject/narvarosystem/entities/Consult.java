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
    @Column(name = "id")
    private int id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User userconsult;

    @OneToOne(mappedBy = "consult", cascade = CascadeType.ALL)
    @JsonIgnore
    private Teacher teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserconsult(User userconsult) {
        this.userconsult = userconsult;
    }

    public User getUserconsult() {
        return userconsult;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

