package com.dbexample.jdbcExample.repository;

import com.dbexample.jdbcExample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired

    private JdbcTemplate jdbc;
    public void save(Student student){
        String sql=" insert into student (rollNo,age,marks) values (?,?,?)";
        jdbc.update(sql,student.getRollNo(),student.getAge(),student.getMarks());
        System.out.println("saved");
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        RowMapper<Student> mapper = (ResultSet rs, int rowNum) -> {

            Student student = new Student();
            student.setRollNo(rs.getInt("rollno"));
            student.setAge(rs.getInt("age"));
            student.setMarks(rs.getInt("marks"));
            return student;

        };
        return jdbc.query(sql,mapper);
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
