package ecproject.narvarosystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "ec_personnel")
    private Set<ECpersonnel> eCpersonnels;



    @Column(name = "description")
    private String description;


    @JsonIgnore
    @OneToMany(mappedBy = "education",
            cascade = CascadeType.ALL)
    private Set<City> cities;

    public Set<ECpersonnel> geteCpersonnels() {
        return eCpersonnels;
    }

    public void seteCpersonnels(Set<ECpersonnel> eCpersonnels) {
        this.eCpersonnels = eCpersonnels;
    }


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

    public void setBookings(Set<City> cities) {
        this.cities = cities;

    }
}
