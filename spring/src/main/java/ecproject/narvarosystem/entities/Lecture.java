package ecproject.narvarosystem.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "lecture")
public class Lecture {

    public Lecture(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private Set<Attendance> attendances;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
