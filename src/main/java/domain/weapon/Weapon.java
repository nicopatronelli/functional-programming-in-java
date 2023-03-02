package domain.weapon;

import domain.weapon.type.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class Weapon {
    private int points;
    private WeaponType type;
}
