package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name ="class")
public class EdClass {

    public EdClass(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "education_id", referencedColumnName = "id", nullable = false)
    private Education education;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    private ECpersonnel eCpersonnelclass;

    @OneToMany(mappedBy = "eclasses", cascade = CascadeType.ALL)
    private Set<Student> students;


}
