package fr.miage.coo.factories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.miage.coo.entities.Student;

public class StudentFactory {
	private static StudentFactory instance;
	private final PreparedStatement createQuery;
	private final PreparedStatement searchByIdQuery;
	private final PreparedStatement searchByNameQuery;
	private final PreparedStatement searchByStudyBranchQuery;
	private Connection conn;

	private StudentFactory() throws SQLException {
		createQuery = conn.prepareStatement("insert into student(lastName, firstName, studyBranch) values (?,?,?)");
		searchByIdQuery = conn.prepareStatement("select * from student where id=?");
		searchByNameQuery = conn.prepareStatement("select * from student where firstName=? and lastName=?");
		searchByStudyBranchQuery = conn.prepareStatement("select * from student where studyBranch=?");
	}

	public static StudentFactory getInstance() throws SQLException {
		if (instance == null) {
			instance = new StudentFactory();
		}
		return instance;
	}

	@SuppressWarnings("unused")
	private Student createStudent(int id, String firstName, String lastName, int branchId) throws SQLException {
		Student student = searchStudentByName(firstName, lastName);
		if (student == null) {
			createQuery.clearParameters();
			createQuery.setString(1, lastName);
			createQuery.setString(2, firstName);
			createQuery.setInt(3, branchId);
			createQuery.executeUpdate();
			student = new Student(id, firstName, lastName);
		}
		return student;
	}

	private Student searchStudentById(int id) throws SQLException {
		searchByIdQuery.clearParameters();
		searchByIdQuery.setInt(1, id);

		ResultSet rs = searchByIdQuery.executeQuery();
		if (!rs.next()) {
			return null;
		}

		Student student = new Student(id, rs.getString(2), rs.getString(3));
		return student;
	}

	private Student searchStudentByName(String firstName, String lastName) throws SQLException {
		searchByNameQuery.clearParameters();
		searchByNameQuery.setString(1, firstName);
		searchByNameQuery.setString(2, lastName);

		ResultSet rs = searchByNameQuery.executeQuery();
		if (!rs.next()) {
			return null;
		}

		Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
		return student;
	}

	private List<Student> searchStudentByBranch(int studyBranchId) throws SQLException {
		List<Student> studentsInBranch = new ArrayList<Student>();
		searchByStudyBranchQuery.clearParameters();
		searchByStudyBranchQuery.setInt(1, studyBranchId);

		ResultSet rs = searchByStudyBranchQuery.executeQuery();
		while (rs.next()) {
			Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
			studentsInBranch.add(student);
		}

		return studentsInBranch;
	}

}
