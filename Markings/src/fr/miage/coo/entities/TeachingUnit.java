package fr.miage.coo.entities;

public class TeachingUnit {

	private int unitId;
	private String label;

	public TeachingUnit(final int unitId, final String label) {
		this.unitId = unitId;
		this.label = label;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
