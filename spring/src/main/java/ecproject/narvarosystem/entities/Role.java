package ecproject.narvarosystem.entities;

import javax.persistence.*;

@Entity
@Table(name ="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RoleID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Setting1")
    private int setting1;

    @Column(name = "Setting2")
    private int setting2;

    public Role(){}

    public long getRoleID() {
        return RoleID;
    }

    public void setRoleID(long roleID) {
        RoleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSetting1() {
        return setting1;
    }

    public void setSetting1(int setting1) {
        this.setting1 = setting1;
    }

    public int getSetting2() {
        return setting2;
    }

    public void setSetting2(int setting2) {
        this.setting2 = setting2;
    }
}
