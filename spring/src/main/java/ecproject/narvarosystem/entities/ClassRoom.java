package ecproject.narvarosystem.entities;

import javax.persistence.*;

@Entity
@Table(name ="class")
public class ClassRoom {

    public ClassRoom(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
