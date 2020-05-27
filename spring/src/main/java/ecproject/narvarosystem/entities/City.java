package ecproject.narvarosystem.entities;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name ="city")
public class City {

    public City(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Education> educations;


}
