package domain.warrior.weapon.type.weapon;

import domain.warrior.Weapon;
import domain.warrior.weapon.type.WeaponType;

public class Shield extends Weapon {
	public Shield(int edgePoints) {
		super(edgePoints, WeaponType.DEFENSIVE);
	}
}
