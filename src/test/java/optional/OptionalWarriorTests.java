package optional;

import domain.warrior.Warrior;
import domain.warrior.weapon.type.weapon.Axe;
import domain.warrior.weapon.type.weapon.Shield;
import domain.warrior.weapon.type.weapon.Sword;
import domain.warrior.Weapon;
import domain.warrior.weapon.type.WeaponType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// EJERCICIO:
//
// Dado un guerrero que está equipado con diferentes armas, queremos calcular
// sus puntos de ataque.
//
// Sabemos que los puntos de ataque de un guerrero dependen del arma que tenga
// equipada en ese momento.
//
// Cada arma posee ciertos puntos de filo (edgePoints), que dependen del herrero que la forjo,
// y se definen al momento de crear el arma.
//
// Si el arma es de tipo defensiva los puntos de ataque son cero. Sino, son el doble
// de sus puntos de filo.
//
// Si un guerrero no está equipado con ninguna arma entonces sus puntos de ataque
// también son cero.
//
// Nota: Por simplicidad, si no existe el guerrero (es null), entonces asumiremos
// que sus puntos de ataque también son cero.

class OptionalWarriorTests {
	public int calcularPuntosDeAtaque(Warrior warrior) {
		if (warrior != null) {
			Weapon weapon = warrior.equippedWeapon();
			if (weapon != null) {
				if (weapon.type() != null && weapon.type() != WeaponType.DEFENSIVE) {
					return weapon.edgePoints() * 2;
				}
			}
			return 0;
		} else return 0;
	}

//	public int calcularPuntosDeAtaque(Warrior warrior) {
//		return Optional.ofNullable(warrior)
//				.map(weapon -> weapon.equippedWeapon())
//				.filter(weapon -> weapon.type() != WeaponType.DEFENSIVE)
//				.map(weapon -> weapon.edgePoints() * 2)
//				.orElse(0);
//	}
	
	@Test
	@DisplayName("Si un guerrero tiene una espada de 70 puntos de arma como arma principal entonces tiene 140 puntos de ataque.")
	void siLaEspadaEsElArmaPrincipalLosPuntosDeAtaqueSon140() {
		//	Creo a las armas
		Weapon sword = new Sword(70);
		Weapon axe = new Axe(30);
		Weapon shield = new Shield(30);

		// Creo al guerrero
		Warrior warrior = new Warrior(sword, axe, shield);
		int result = calcularPuntosDeAtaque(warrior);

		System.out.println(result);

		assertEquals(140, result);
	}

	@Test
	@DisplayName("Si el guerrero no está equipado con ningún arma entonces sus puntos de ataque son cero")
	void unGuerreroSinNingunArmaTieneCeroPuntosDeAtaque() {

		// Creo al guerrero
		Warrior warrior = new Warrior();
		int result = calcularPuntosDeAtaque(warrior);

		System.out.println(result);

		assertEquals(0, result);
	}
}
