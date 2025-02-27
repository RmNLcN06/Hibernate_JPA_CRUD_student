package com.rmnlcn.Hibernate_JPA_CRUD_student;

import com.rmnlcn.Hibernate_JPA_CRUD_student.daos.StudentDAO;
import com.rmnlcn.Hibernate_JPA_CRUD_student.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");

		// retrieve the number of deleted rows
		int numRowsDeleted = studentDAO.deleteAll();

		// print the number of deleted rows
		System.out.println("Deleting row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 6;
		System.out.println("Deleting student with id: " + studentId);

		// delete the student
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Paul" then back to "Romain"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Romain");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Faure");

		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Lilas", "Luciano", "lilLuc@example.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
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
