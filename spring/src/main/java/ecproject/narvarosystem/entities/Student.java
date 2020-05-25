package ecproject.narvarosystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    public Student(){}

    @Column(name = "picture")
    private String picture;

    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    private Class classes;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }
}
