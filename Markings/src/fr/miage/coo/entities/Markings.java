package fr.miage.coo.entities;

public class Markings {
	private int teachingUnitId;
	private int studentId;
	private double mark;

	public Markings(final int teachingUnitId, final int studentId, double mark) {
		this.teachingUnitId = teachingUnitId;
		this.studentId = studentId;
		this.mark = mark;
	}

	public int getTeachingUnitId() {
		return teachingUnitId;
	}

	public void setTeachingUnitId(int teachingUnitId) {
		this.teachingUnitId = teachingUnitId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

}
