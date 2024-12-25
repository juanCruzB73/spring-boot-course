package com.expringJPAExample.expringJPAExample;

import com.expringJPAExample.expringJPAExample.model.Student;
import com.expringJPAExample.expringJPAExample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ExpringJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ExpringJpaExampleApplication.class, args);


		StudentRepository repository = context.getBean(StudentRepository.class);

		Student student1 = context.getBean(Student.class);
		Student student2 = context.getBean(Student.class);
		Student student3 = context.getBean(Student.class);

		student1.setRollNo(1);
		student1.setAge(21);
		student1.setMarks(10);

		student2.setRollNo(2);
		student2.setAge(22);
		student2.setMarks(9);

		student3.setRollNo(3);
		student3.setAge(23);
		student3.setMarks(10);

		repository.save(student1);
		repository.save(student2);
		repository.save(student3);

		List<Student> stu = repository.findByGrade(10);
		for(Student student : stu){
			System.out.println("the student with id of  "+student.getRollNo()+" has a grade of 10");
		}
	}

}
