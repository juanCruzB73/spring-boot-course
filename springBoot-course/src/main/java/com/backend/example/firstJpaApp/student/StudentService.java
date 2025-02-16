package com.backend.example.firstJpaApp.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository=studentRepository;
        this.studentMapper=studentMapper;
    }
    //SAVE STUDENT
    public StudentResposeDto saveStudent(StudentaDto studentDto){
        var student=studentMapper.toStudent(studentDto);
        var savedStudent=studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }
    //FIND ALL STUDENTS
    public List<StudentResposeDto> findAllStudents(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }
    public StudentResposeDto studentById(Integer id){

        return studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }
    //FIND BY NAME
    public List<StudentResposeDto> studentByName(String name){
        return studentRepository.findAllByNameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }
    //DELETE BY ID
    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }
}
