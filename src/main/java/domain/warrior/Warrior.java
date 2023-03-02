package domain.warrior;

import java.util.Collections;
import java.util.List;

public class Warrior {
	private List<Weapon> weapons;

	public Warrior(Weapon... wpns) {
		if (wpns.length == 0) this.weapons = Collections.emptyList();
		else this.weapons = List.of(wpns);
	}

	public Weapon equippedWeapon() {
		return this.weapons.isEmpty() ? null : this.weapons.get(0);
	}
}
