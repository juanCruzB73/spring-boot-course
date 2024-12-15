package com.dbexample.jdbcExample.service;

import com.dbexample.jdbcExample.model.Student;
import com.dbexample.jdbcExample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    public void addStudent(Student student){
        repository.save(student);
        System.out.println("it worked");
    }

    public StudentRepository getRepository() {
        return repository;
    }

    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }
}
