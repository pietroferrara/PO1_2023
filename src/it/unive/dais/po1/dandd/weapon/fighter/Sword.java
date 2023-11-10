package it.unive.dais.po1.dandd.weapon.fighter;

import it.unive.dais.po1.dandd.weapon.OffensiveWeapon;

/**
 * This class is aimed at representing a weapon in D&D
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class Sword extends OffensiveWeapon  {


    /**
     * Creates a weapon with the given damage
     * @param i the given damage
     * @requires i > 0
     */
    public Sword(int i) {
        if(i>0)
            this.damage = i;
        else this.damage = 1;
    }


    /**
     * invariant -> @requires damage >= 0
     * invariant -> @ensures damage >= 0 && damage <= pre(damage)
     * @ensures result >= 0
     */
    public int getDamage() {
        int result = this.damage;
        if(result > 1)
            this.damage = this.damage - 1;
        return result;
    }
}