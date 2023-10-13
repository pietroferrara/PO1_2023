package it.unive.dais.po1.dandd.weapons;

/**
 * This class is aimed at representing a weapon in D&D
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class Weapon {
    private int damage;

    public Weapon(int i) {
        if(i>0)
            this.damage = i;
        else this.damage = 1;
    }

    public void setDamage(int i) {
        if(i > 0)
            this.damage = i;
    }

    public int getDamage() {
        return this.damage;
    }
}
