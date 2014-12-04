package fr.miage.coo.factories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.miage.coo.entities.Student;
import fr.miage.coo.exceptions.EntityException;

public class StudentFactory {
	private static final String STUDENT_NOT_EXIST = "Student does not exists";
	private static final String STUDENT_ALREADY_EXIST = "Student already exists";

	private static StudentFactory instance;
	private final List<Student> studentList;
	private final PreparedStatement createQuery;
	private final PreparedStatement searchByIdQuery;
	private final PreparedStatement searchByNameQuery;
	private final PreparedStatement searchByStudyBranchQuery;
	private Connection conn;

	private StudentFactory() throws SQLException {
		studentList = new ArrayList<Student>();
		createQuery = conn.prepareStatement("insert into student(lastName, firstName, studyBranch) values (?,?,?)");
		searchByIdQuery = conn.prepareStatement("select * from student where id=?");
		searchByNameQuery = conn.prepareStatement("select * from student where firstName=?");
		searchByStudyBranchQuery = conn.prepareStatement("select * from student where studyBranch=?");
	}

	public static StudentFactory getInstance() throws SQLException {
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
