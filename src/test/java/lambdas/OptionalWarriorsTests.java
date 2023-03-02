package lambdas;

import domain.Soldier;
import domain.Warrior;
import domain.weapon.Sword;
import domain.weapon.Weapon;
import domain.weapon.type.WeaponType;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalWarriorsTests {
    @Test
    void test() {
        Weapon sword = new Sword(100, WeaponType.ATTACK);
        Warrior warrior = new Soldier(List.of(sword));
        int result = m2Optional(warrior);
        System.out.println(result);
        assertEquals(result, 200);
    }

    public int m2(Warrior warrior) {
        if (warrior != null) {
            if (warrior instanceof Soldier) {
                Weapon weapon = warrior.firstWeapon();
                if (weapon != null) {
                    if (weapon.type() != null && weapon.type() != WeaponType.DEFENSIVE) {
                        int weaponPoints = weapon.points();
                        return weaponPoints != -1 ? weaponPoints * 2: 0;
                    }
                }
            }
            return 0;
        } else return 0;
    }

    public int m2Optional(Warrior warrior) {
        return Optional.ofNullable(warrior)
                .filter(warrior1 -> warrior1 instanceof Soldier)
                .map(weapon -> weapon.firstWeapon())
                .filter(weapon -> weapon.type() != WeaponType.DEFENSIVE)
                .map(weapon -> weapon.points() * 2)
                .orElse(0);
    }

}
