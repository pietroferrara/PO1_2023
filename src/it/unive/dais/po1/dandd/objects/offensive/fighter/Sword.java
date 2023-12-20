package it.unive.dais.po1.dandd.objects.offensive.fighter;

import it.unive.dais.po1.dandd.figures.Restore;
import it.unive.dais.po1.dandd.objects.DaDObject;
import it.unive.dais.po1.dandd.objects.offensive.OffensiveObject;

/**
 * This class is aimed at representing a weapon in D&D
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class Sword implements OffensiveObject {

    private int damage;

    private final int maximal_damage;


    /**
     * Creates a weapon with the given damage
     * @param i the given damage
     * @requires i > 0
     */
    public Sword(int i) {
        if(i>0)
            this.damage = i;
        else this.damage = 1;
        this.maximal_damage = this.damage;
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

    @Override
    public String toString() {
        return "Sword{" +
                "damage=" + damage +
                '}';
    }

    @Override
    public int getInnerDamage() {
        return this.damage;
    }


    public int getStrength() { return this.getInnerDamage();}


    @Restore(amount = 1)
    public void restore() {
        this.damage = Math.min(
                this.maximal_damage,
                this.damage+1);
    }
}
