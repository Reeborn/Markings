package fr.miage.coo.entities;

public class StudyBranch {

	private final int branchId;
	private final String label;

	public StudyBranch(final int branchId, final String label) {
		this.branchId = branchId;
		this.label = label;
	}

	public int getBranchId() {
		return branchId;
	}

	public String getLabel() {
		return label;
	}

}
