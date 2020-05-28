package ecproject.narvarosystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private ECpersonnel educationManager;

    @OneToMany(mappedBy = "educationOfClass", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<EdClass> edClasses;

    @OneToMany(mappedBy = "education", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Course> courses;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public ECpersonnel getEducationManager() {
        return educationManager;
    }

    public void setEducationManager(ECpersonnel educationManager) {
        this.educationManager = educationManager;
    }

    public Set<EdClass> getEdClasses() {
        return edClasses;
    }

    public void setEdClasses(Set<EdClass> edClasses) {
        this.edClasses = edClasses;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


}
