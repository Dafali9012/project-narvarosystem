package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "consult")
public class Consult implements Serializable {

    public Consult(){}

    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

