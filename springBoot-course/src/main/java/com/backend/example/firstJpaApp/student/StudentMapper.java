package com.backend.example.firstJpaApp.student;

import com.backend.example.firstJpaApp.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentaDto studentDto){

        var student=new Student();
        student.setName(studentDto.name());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        var school=new School();
        school.setId(studentDto.schoolId());

        student.setSchool(school);

        return student;
    }
    public StudentResposeDto toStudentResponseDto(Student student){
        return new StudentResposeDto(student.getName(), student.getLastName(), student.getEmail());
    }
}
