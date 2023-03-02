package domain.warrior;

import domain.warrior.weapon.type.WeaponType;

public abstract class Weapon {
	private int edgePoints;
	private WeaponType type;

	public Weapon(int edgePoints, WeaponType type) {
		this.edgePoints = edgePoints;
		this.type = type;
	}

	public int edgePoints() {
		return this.edgePoints;
	}

	public WeaponType type() {
		return this.type;
	}
}
