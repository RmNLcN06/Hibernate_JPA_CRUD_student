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
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating five student objects ...");
		Student tempStudent1 = new Student("Florian", "Luciano", "floLuc@example.com");
		Student tempStudent2 = new Student("Isabelle", "Lapraz", "isaLap@example.com");
		Student tempStudent3 = new Student("Sylvain", "Nicolas", "sylNic@example.com");
		Student tempStudent4 = new Student("Christophe", "Nicolas", "chrNic@example.com");
		Student tempStudent5 = new Student("Aurélie", "Faure", "aurFau@example.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		studentDAO.save(tempStudent5);
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
