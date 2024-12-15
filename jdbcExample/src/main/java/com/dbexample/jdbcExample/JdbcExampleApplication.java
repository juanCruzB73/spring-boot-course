package com.dbexample.jdbcExample;

import com.dbexample.jdbcExample.model.Student;
import com.dbexample.jdbcExample.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JdbcExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcExampleApplication.class, args);
		Student student = context.getBean(Student.class);
		student.toString();

		student.setAge(30);
		student.setRollNo(103);
		student.setMarks(10);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(student);

		List<Student> students = service.getStudents();
		System.out.println(students);

	}

}
