package com.backend.example.firstJpaApp.school;

import com.backend.example.firstJpaApp.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Integer id;

    private String schoolName;
    @OneToMany(mappedBy = "school")
    @JsonManagedReference//the parent is in charge of seriaizing the child
    private List<Student>students;

    public School(){}
    public School(String schoolName) {

        this.schoolName = schoolName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
