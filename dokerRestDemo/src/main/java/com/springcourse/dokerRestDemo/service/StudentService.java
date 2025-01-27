package com.springcourse.dokerRestDemo.service;

import com.springcourse.dokerRestDemo.model.Student;
import com.springcourse.dokerRestDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student>getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        System.out.println("Saving student: " + student);
        studentRepository.save(student);
        System.out.println("Student saved successfully.");
    }
}
