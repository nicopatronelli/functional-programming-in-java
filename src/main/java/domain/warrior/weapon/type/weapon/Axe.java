package domain.warrior.weapon.type.weapon;

import domain.warrior.Weapon;
import domain.warrior.weapon.type.WeaponType;

public class Axe extends Weapon {
	public Axe(int edgePoints) {
		super(edgePoints, WeaponType.ATTACK);
	}
}
