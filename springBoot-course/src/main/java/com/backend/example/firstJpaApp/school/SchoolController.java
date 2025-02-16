package com.backend.example.firstJpaApp.school;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto schoolDto){
        return this.schoolService.saveSchool(schoolDto);
    }
    @GetMapping("/schools")
    public List<SchoolDto> getSchools(){
        return this.schoolService.getSchools();
    }
    @DeleteMapping("/schools/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchool(@PathVariable("id")Integer id){
        schoolService.deleteSchool(id);
    }

}
