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


}