package com.backend.example.firstJpaApp.student;

import com.backend.example.firstJpaApp.school.School;
import com.backend.example.firstJpaApp.studentProfile.StudentProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)//IF STUDENT REMOVED WILL REMOVE STUDENPROFILE
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference//marks to not serialize school
    private School school;

    public Student(){}
    public Student(String name, String lastName, int age,String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email=email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
