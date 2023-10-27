package it.unive.dais.po1.dandd.weapons;

/**
 * This class is aimed at representing a weapon in D&D
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class Weapon {

    /**
     * @invariant damage >= 0 && damage <= pre(damage)
     */
    private int damage;

    /**
     * Creates a weapon with the given damage
     * @param i the given damage
     * @requires i > 0
     */
    public Weapon(int i) {
        if(i>0)
            this.damage = i;
        else this.damage = 1;
    }

    /**
     * Update the damage of the weapon to the given value
     * @param i the updated damage
     *
     * invariant -> @requires damage >= 0
     * invariant -> @ensures damage >= 0 && damage <= pre(damage)
     * @requires i > 0
     * @ensures this.damage == i
     */
    public void setDamage(int i) {
        if(i > 0 && i <= this.damage)
            this.damage = i;
    }

    /**
     * invariant -> @requires damage >= 0
     * invariant -> @ensures damage >= 0 && damage <= pre(damage)
     * @ensures result >= 0
     */
    public int getDamage() {
        return this.damage;
    }
}
