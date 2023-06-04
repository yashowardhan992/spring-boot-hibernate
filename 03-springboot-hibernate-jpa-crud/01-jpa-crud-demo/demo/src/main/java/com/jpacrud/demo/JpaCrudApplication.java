package com.jpacrud.demo;

import com.jpacrud.demo.dao.StudentDAO;
import com.jpacrud.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
   	        createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : "+numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student id : "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id:pk
		int studentId = 4;
		System.out.println("Getting student with id : "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change the first name
		System.out.println("Updating Student");
		myStudent.setFirstName("NardDogg Andy");

		//updating
		studentDAO.update(myStudent);

		System.out.println("Updated student : "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Wallace");

		//display list of students
		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display the list of students
		for(Student tempStudent: theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//creating new student
		System.out.println("Creating a student");
		Student tempStudent = new Student("David", "Wallace","demo@dmCorp.com");

		//save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//Retrieving the student id
		int id = tempStudent.getId();
		System.out.println("Saved Student. Generated id : "+id);

		System.out.println("Retrieving Student with id : "+id);
		Student myStudent = studentDAO.findById(id);

		//display student
		System.out.println("found the student : "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO){

		System.out.println("Creating 3 Student objects");
		Student tempStudent1 = new Student("Pam","Beesly","demo@artsy.com");
		Student tempStudent2 = new Student("Stanley","Hudson","demo@crossword.com");
		Student tempStudent3 = new Student("Todd","Packer","demo@packaging.com");

		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new Student object ... ");
		Student tempStudent = new Student("Yash","Pandey","demo@demo.com");

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// Save the student object
		System.out.println("Saved Student. Generated Id : " +tempStudent.getId());


	}



}
