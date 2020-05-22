package ecproject.narvarosystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {


    @Column(name = "user_id")
    private int user_id;

    @Column(name = "class_id")
    private int class_id;

    @Column(name = "picture")
    private String picture;

    public Student() { }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
