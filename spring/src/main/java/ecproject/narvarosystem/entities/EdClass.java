package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.util.List;
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

    @Column(name = "manager_id")
    private Integer manager_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    private Education educationclass;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ECpersonnel eCpersonnelclass;

    @OneToMany(mappedBy = "eclasses", cascade = CascadeType.ALL)
    private Set<Student> students;

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
}
