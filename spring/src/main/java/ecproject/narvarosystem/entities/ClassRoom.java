package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name ="class")
public class ClassRoom {

    public ClassRoom(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "education_id", referencedColumnName = "id", nullable = false)
    private Education education;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", referencedColumnName = "user_id", nullable = false)
    private ECpersonnel eCpersonnel;

    @OneToMany(mappedBy = "eclasses", cascade = CascadeType.ALL)
    private Set<Student> students;

    public long getId() {
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public ECpersonnel geteCpersonnel() {
        return eCpersonnel;
    }

    public void seteCpersonnel(ECpersonnel eCpersonnel) {
        this.eCpersonnel = eCpersonnel;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
