package fr.miage.coo.factories;

import java.util.ArrayList;
import java.util.List;

import fr.miage.coo.entities.TeachingUnit;
import fr.miage.coo.exceptions.EntityException;

public class TeachingUnitFactory {
	private static final String TEACHING_UNIT_ALREADY_EXIST = "Teaching unit already exists";

	private static TeachingUnitFactory instance;
	private final List<TeachingUnit> teachingUnitList;

	private TeachingUnitFactory() {
		teachingUnitList = new ArrayList<TeachingUnit>();
	}

	public static TeachingUnitFactory getInstance() {
		if (instance == null) {
			instance = new TeachingUnitFactory();
		}
		return instance;
	}

	private TeachingUnit createTeachingUnit(final int id, final String label) throws EntityException {
		TeachingUnit teachingUnit = searchTeachingUnit(id);
		if (teachingUnit == null) {
			return new TeachingUnit(id, label);
		}
		throw new EntityException(TEACHING_UNIT_ALREADY_EXIST);
	}

	private TeachingUnit searchTeachingUnit(final int id) throws EntityException {
		for (TeachingUnit teachingUnit : teachingUnitList) {
			if (teachingUnit.getUnitId() == id) {
				return teachingUnit;
			}
		}
		throw new EntityException(TEACHING_UNIT_ALREADY_EXIST);
	}
}
