package domain.weapon;


import domain.weapon.type.WeaponType;
import lombok.AllArgsConstructor;

public class Sword extends Weapon{
    private int points;
    private WeaponType type;

    public Sword(int points, WeaponType type) {
        super(points, type);
    }
}
