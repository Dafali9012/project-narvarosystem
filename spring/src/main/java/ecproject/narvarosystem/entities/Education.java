package ecproject.narvarosystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long edId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Point")
    private int point;

    @Column(name = "Leader")
    private int leaderId;

    @Column(name = "Description")
    private String description;

    public Education(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEdId() {
        return edId;
    }

    public void setEdId(long edId) {
        this.edId = edId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }
}