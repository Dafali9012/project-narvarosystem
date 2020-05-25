package ecproject.narvarosystem.entities;

import javax.persistence.*;


@Entity
@Table(name ="classroom")
public class ClassRoom {
    public ClassRoom(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "class_id")
    private int class_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}