package ecproject.narvarosystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="role")
public class Role {

    public Role(){}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_class")
    private Boolean create_class;

    @Column(name = "create_account")
    private Boolean create_account;

    @Column(name = "create_course")
    private Boolean create_course;

    @Column(name = "create_education")
    private Boolean create_education;

    @Column(name = "create_role")
    private Boolean create_role;

    @Column(name = "create_lecture")
    private Boolean create_lecture;

    @Column(name = "access_overview")
    private Boolean access_overview;

    @Column(name = "access_messages")
    private Boolean access_messages;

    @Column(name = "access_classroom")
    private Boolean access_classroom;

    @Column(name = "access_report")
    private Boolean access_report;

    @Column(name = "access_teacher_info")
    private Boolean access_teacher_info;

    @Column(name = "access_student_info")
    private Boolean access_student_info;

    @Column(name = "access_calendar_teacher")
    private Boolean access_calendar_teacher;

    @Column(name = "access_calendar_student")
    private Boolean access_calendar_student;



    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<User> users;

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

    public Boolean getCreate_class() {
        return create_class;
    }

    public void setCreate_class(Boolean create_class) {
        this.create_class = create_class;
    }

    public Boolean getCreate_account() {
        return create_account;
    }

    public void setCreate_account(Boolean create_account) {
        this.create_account = create_account;
    }

    public Boolean getCreate_course() {
        return create_course;
    }

    public void setCreate_course(Boolean create_course) {
        this.create_course = create_course;
    }

    public Boolean getCreate_education() {
        return create_education;
    }

    public void setCreate_education(Boolean create_education) {
        this.create_education = create_education;
    }

    public Boolean getCreate_role() {
        return create_role;
    }

    public void setCreate_role(Boolean create_role) {
        this.create_role = create_role;
    }

    public Boolean getCreate_lecture() {
        return create_lecture;
    }

    public void setCreate_lecture(Boolean create_lecture) {
        this.create_lecture = create_lecture;
    }

    public Boolean getAccess_overview() {
        return access_overview;
    }

    public void setAccess_overview(Boolean access_overview) {
        this.access_overview = access_overview;
    }

    public Boolean getAccess_messages() {
        return access_messages;
    }

    public void setAccess_messages(Boolean access_messages) {
        this.access_messages = access_messages;
    }

    public Boolean getAccess_classroom() {
        return access_classroom;
    }

    public void setAccess_classroom(Boolean access_classroom) {
        this.access_classroom = access_classroom;
    }

    public Boolean getAccess_report() {
        return access_report;
    }

    public void setAccess_report(Boolean access_report) {
        this.access_report = access_report;
    }

    public Boolean getAccess_teacher_info() {
        return access_teacher_info;
    }

    public void setAccess_teacher_info(Boolean access_teacher_info) {
        this.access_teacher_info = access_teacher_info;
    }

    public Boolean getAccess_student_info() {
        return access_student_info;
    }

    public void setAccess_student_info(Boolean access_student_info) {
        this.access_student_info = access_student_info;
    }

    public Boolean getAccess_calendar_teacher() {
        return access_calendar_teacher;
    }

    public void setAccess_calendar_teacher(Boolean access_calendar_teacher) {
        this.access_calendar_teacher = access_calendar_teacher;
    }

    public Boolean getAccess_calendar_student() {
        return access_calendar_student;
    }

    public void setAccess_calendar_student(Boolean access_calendar_student) {
        this.access_calendar_student = access_calendar_student;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
