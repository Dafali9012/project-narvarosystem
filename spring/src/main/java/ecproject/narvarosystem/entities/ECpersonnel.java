package ecproject.narvarosystem.entities;


import javax.persistence.*;

@Entity
@Table(name = "ec_personnel")
public class ECpersonnel {

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "manager_id", nullable = false)
    private Education education;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
}
