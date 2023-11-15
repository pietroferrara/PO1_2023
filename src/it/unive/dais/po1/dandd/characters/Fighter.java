package it.unive.dais.po1.dandd.characters;

import it.unive.dais.po1.dandd.protection.Armor;
import it.unive.dais.po1.dandd.protection.Protection;
import it.unive.dais.po1.dandd.weapon.OffensiveWeapon;
import it.unive.dais.po1.dandd.weapon.fighter.Sword;

/**
 * This class is aimed at representing a fighter in D&D
 * Inspired by <a href="https://www.dndbeyond.com/classes/fighter">this webpage</a>
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class Fighter extends Figure {



    private Sword sword;
    private Armor armor;

    /**
     * Initializes a fighter without any experience and with full life points
     * @param w1 The initial weapon of the fighter
     * @param a1 The initial armor of the fighter
     */
    public Fighter(Sword w1, Armor a1) {
        this(0, 100, w1, a1);
    }

    /**
     * Creates a fighter
     * @param experience_points The initial amount of experience points
     * @param life_points The initial amount of life points
     * @param w1 The initial weapon of the fighter
     * @param a1 The initial armor of the fighter
     */
    Fighter(int experience_points, int life_points, Sword w1, Armor a1) {
        super(experience_points, life_points);
        this.sword = w1;
        this.armor = a1;
    }

    @Override
    public int getDamage() {
        return this.sword.getDamage();
    }

    @Override
    public void setOffensiveWeapon(OffensiveWeapon offensiveweap) {
        if(offensiveweap instanceof Sword)
            this.sword = (Sword) offensiveweap;
    }

    @Override
    public void setProtection(Protection defeatedprot) {
        if(defeatedprot instanceof Armor)
            this.armor = (Armor) defeatedprot;
    }

    @Override
    public OffensiveWeapon getOffensiveWeapon() {
        return this.sword;
    }

    @Override
    public Protection getProtection() {
        return this.armor;
    }
}
