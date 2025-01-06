package com.expringJPAExample.expringJPAExample.repository;

import com.expringJPAExample.expringJPAExample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("select s from Student s where s.marks = ?1")
    List<Student> findByGrade(int grade);

}