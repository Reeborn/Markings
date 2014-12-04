package fr.miage.coo.factories;

import java.util.ArrayList;
import java.util.List;

import fr.miage.coo.entities.StudyBranch;
import fr.miage.coo.exceptions.EntityException;

public class StudyBranchFactory {
	private static final String STUDY_BRANCH_ALREADY_EXIST = "Student already exists";

	private static StudyBranchFactory instance;
	private final List<StudyBranch> studyBranchList;

	private StudyBranchFactory() {
		studyBranchList = new ArrayList<StudyBranch>();
	}

	public static StudyBranchFactory getInstance() {
		if (instance == null) {
			instance = new StudyBranchFactory();
		}
		return instance;
	}

	private StudyBranch createStudyBranch(final int id, final String label) throws EntityException {
		StudyBranch studyBranch = searchStudyBranch(id);
		if (studyBranch == null) {
			return new StudyBranch(id, label);
		}
		throw new EntityException(STUDY_BRANCH_ALREADY_EXIST);
	}

	private StudyBranch searchStudyBranch(final int id) throws EntityException {
		for (StudyBranch studyBranch : studyBranchList) {
			if (studyBranch.getBranchId() == id) {
				return studyBranch;
			}
		}
		throw new EntityException(STUDY_BRANCH_ALREADY_EXIST);
	}

}
