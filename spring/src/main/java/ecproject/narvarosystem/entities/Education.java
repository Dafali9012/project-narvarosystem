package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education")
public class Education {

    public Education(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    private ECpersonnel eCpersonnelEd;

    @Column(name = "description")
    private String description;

    /*@OneToMany(mappedBy = "educationclass")
    private Set<EdClass> edClasses;*/

    @Column(name = "manager_id", insertable = false, updatable = false)
    private Integer manager_id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "education")
    private Set<Course> courses;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ECpersonnel geteCpersonnelEd() {
        return eCpersonnelEd;
    }

    public String getDescription() {
        return description;
    }



    public Set<Course> getCourses() {
        return courses;
    }
}
