package com.backend.example.firstJpaApp.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService=studentService;
    }

    //get method to all students
    @GetMapping("/students")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<StudentResposeDto> findAllStudents(){
        return studentService.findAllStudents();
    }
    //FIND BY ID
    @GetMapping("/students/{id}")
    public StudentResposeDto studentById(@PathVariable("id") Integer id){
        return studentService.studentById(id);
    }
    //SEARCH BY NAME
    @GetMapping("/students/search/{name}")
    public List<StudentResposeDto> studentByName(@PathVariable("name") String name){
        return studentService.studentByName(name) ;
    }
    //post method
    @PostMapping("/student")
    public StudentResposeDto saveStudent(@RequestBody StudentaDto studentDto){//converts the body from the http request into the java object needed
        return this.studentService.saveStudent(studentDto);
    }

    //deleateById
    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("id")Integer id){
        studentService.deleteStudent(id);
    }




}
