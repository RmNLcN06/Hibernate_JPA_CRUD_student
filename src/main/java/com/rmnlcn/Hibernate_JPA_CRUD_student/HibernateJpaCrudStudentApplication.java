package com.rmnlcn.Hibernate_JPA_CRUD_student;

import com.rmnlcn.Hibernate_JPA_CRUD_student.daos.StudentDAO;
import com.rmnlcn.Hibernate_JPA_CRUD_student.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaCrudStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaCrudStudentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Romain", "Luciano", "romLuc@example.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
