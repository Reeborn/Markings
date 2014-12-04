package fr.miage.coo.factories;

import java.util.ArrayList;
import java.util.List;

import fr.miage.coo.entities.Student;
import fr.miage.coo.exceptions.EntityException;

public class StudentFactory {
	private static final String STUDENT_NOT_EXIST = "Student does not exists";
	private static final String STUDENT_ALREADY_EXIST = "Student already exists";

	private static StudentFactory instance;
	private final List<Student> studentList;

	private StudentFactory() {
		studentList = new ArrayList<Student>();
	}

	public static StudentFactory getInstance() {
		if (instance == null) {
			instance = new StudentFactory();
		}
		return instance;
	}

	@SuppressWarnings("unused")
	// A revoir tous les cas possibles
	private Student createStudent(int id, String firstName, String lastName) throws EntityException {
		Student student = searchStudent(id);
		if (student == null) {
			if (searchStudent(firstName, lastName) == null)
				return new Student(id, firstName, lastName);
		}
		throw new EntityException(STUDENT_ALREADY_EXIST);
	}

	private Student searchStudent(int id) throws EntityException {
		for (Student student : studentList) {
			if (student.getStudentId() == id) {
				return student;
			}
		}
		throw new EntityException(STUDENT_NOT_EXIST);
	}

	private Student searchStudent(String firstName, String lastName) throws EntityException {
		for (Student student : studentList) {
			if (student.getLastName().equals(lastName) && student.getFirstName().equals(firstName)) {
				return student;
			}
		}
		throw new EntityException(STUDENT_NOT_EXIST);
	}

}
