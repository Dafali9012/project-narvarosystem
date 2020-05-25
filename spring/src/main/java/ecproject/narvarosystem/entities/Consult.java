package ecproject.narvarosystem.entities;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consult")
public class Consult {

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
