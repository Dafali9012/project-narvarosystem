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

    @OneToMany(mappedBy = "education")
    private Set<EdClass> edClasses;


    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "education")
    private Set<Course> courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ECpersonnel geteCpersonnelEd() {
        return eCpersonnelEd;
    }

    public void seteCpersonnelEd(ECpersonnel eCpersonnelEd) {
        this.eCpersonnelEd = eCpersonnelEd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<EdClass> getEdClasses() {
        return edClasses;
    }

    public void setEdClasses(Set<EdClass> edClasses) {
        this.edClasses = edClasses;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
