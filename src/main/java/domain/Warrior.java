package domain;

import domain.weapon.Weapon;

import java.util.List;

public interface Warrior {
    List<Weapon> weapons();
    default Weapon firstWeapon() {
        return this.weapons().get(0);
    }
}
