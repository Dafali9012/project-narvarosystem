package ecproject.narvarosystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Integer role_id;

    @OneToOne(mappedBy = "userconsult", cascade = CascadeType.ALL)
    @JsonIgnore
    private Consult consult;

    @OneToOne(mappedBy = "userstudent", cascade = CascadeType.ALL)
    @JsonIgnore
    private Student student;

   @OneToOne(mappedBy = "userec", cascade = CascadeType.ALL)
   @JsonIgnore
    private ECpersonnel eCpersonnel;

    @ManyToOne(optional = false)
    @JoinColumn (name = "role_id", nullable = false, insertable = false, updatable = false)
    private Role role;

    public User(String email, String password) {
        this.email = email;
        this. password = password;
    }


    public User() {}

    public User(User user) {
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.phone_number = user.getPhone_number();
        this.ssn = user.getSsn();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Consult getConsult() {
        return consult;
    }

    public void setConsult(Consult consult) {
        this.consult = consult;
    }

    public ECpersonnel geteCpersonnel() {
        return eCpersonnel;
    }

    public void seteCpersonnel(ECpersonnel eCpersonnel) {
        this.eCpersonnel = eCpersonnel;
    }


    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}



