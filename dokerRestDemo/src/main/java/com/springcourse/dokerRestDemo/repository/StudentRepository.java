package com.springcourse.dokerRestDemo.repository;

import com.springcourse.dokerRestDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
