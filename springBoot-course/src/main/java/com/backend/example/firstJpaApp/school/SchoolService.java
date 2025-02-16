package com.backend.example.firstJpaApp.school;

import com.backend.example.firstJpaApp.school.SchoolDto;
import com.backend.example.firstJpaApp.school.SchoolMapper;
import com.backend.example.firstJpaApp.school.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;
    public SchoolService(SchoolRepository schoolRepository,SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper=schoolMapper;
    }
    //create School
    public SchoolDto saveSchool(SchoolDto schoolDto){
        var school= schoolMapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }
    //GET ALL SCHOOLS

    public List<SchoolDto> getSchools(){
        return schoolRepository.findAll()//make a list od SchoolDto
                .stream()//makes a stream of schools
                .map(schoolMapper::toSchoolDto )//map the stream turning them to schoolDto
                .collect(Collectors.toList());//convert stream to list
    }

    public void deleteSchool(Integer id){
        schoolRepository.deleteById(id);
    }



}
