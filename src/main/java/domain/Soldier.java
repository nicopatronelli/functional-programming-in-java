package domain;

import domain.weapon.Weapon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@Getter @Accessors(fluent = true)
public class Soldier implements Warrior{
    private List<Weapon> weapons;
    @Override
    public List<Weapon> weapons() {
        return this.weapons;
    }
}
