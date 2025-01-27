package com.springcourse.dokerRestDemo.controller;

import com.springcourse.dokerRestDemo.model.Student;
import com.springcourse.dokerRestDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("getstudents")
    public List<Student>getStudent(){
        return studentService.getStudents();
    }
    @RequestMapping("addstudent")
    public String addStudent(){
        Student student1 = new Student();
        student1.setName("Elliot");
        student1.setAge(29);
        studentService.addStudent(student1);
        System.out.println("student added"+student1);
        return "Student added: " + student1.getName();
    }

}
