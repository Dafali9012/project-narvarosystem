package ecproject.narvarosystem.entities;


import javax.persistence.*;

@Entity
@Table(name = "ec_personnel")
public class ECpersonnel {

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
