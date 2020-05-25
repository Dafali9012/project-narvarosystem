package ecproject.narvarosystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    public Student(){}

    @Column(name = "class_id")
    private int class_id;

    @Column(name = "picture")
    private String picture;

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

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
