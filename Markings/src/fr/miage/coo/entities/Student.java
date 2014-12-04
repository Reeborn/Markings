package fr.miage.coo.entities;

public class Student {

	private final int studentId;
	private final String lastName;
	private final String firstName;

	public Student(final int studentId, final String lastName, final String firstName) {
		this.studentId = studentId;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

}
