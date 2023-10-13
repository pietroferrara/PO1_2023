package it.unive.dais.po1.dandd.characters;

import it.unive.dais.po1.dandd.armors.Armor;
import it.unive.dais.po1.dandd.weapons.Weapon;

import java.util.Random;

/**
 * This class is aimed at representing a fighter in D&D
 * Inspired by <a href="https://www.dndbeyond.com/classes/fighter">this webpage</a>
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class Fighter {

    private static int number_of_instantiated_fighters = 0;

    private static final int MAX_ID = 100;

    /**
     * The identifier of the fighter
     */
    public final int id;
    private int experience_points;
    private Weapon weapon;
    private Armor armor;
    private int life_points;


    /**
     * Initializes a fighter without any experience and with full life points
     * @param w1 The initial weapon of the fighter
     * @param a1 The initial armor of the fighter
     */
    public Fighter(Weapon w1, Armor a1) {
        this(0, 100, w1, a1);
    }

    /**
     * Creates a fighter
     * @param experience_points The initial amount of experience points
     * @param life_points The initial amount of life points
     * @param w1 The initial weapon of the fighter
     * @param a1 The initial armor of the fighter
     */
    Fighter(int experience_points, int life_points, Weapon w1, Armor a1) {
        this.experience_points = experience_points;
        this.life_points = life_points;
        this.weapon = w1;
        this.armor = a1;
        this.id = this.number_of_instantiated_fighters;
        Fighter.number_of_instantiated_fighters = Fighter.number_of_instantiated_fighters+1;
    }

    /**
     *
     * @return true iff the current fighter is alive
     */
    public boolean isAlive() {
        return this.life_points>0;
    }

    /**
     * Provides the experience level of the fighter
     * @return The number representing the level of the fighter
     */
    public int getLevel() {
        return experience_points/1000+1;
    }

    /**
     * The fighter got damaged by the given amount of life points.
     * If the amount of subtracted life points is greater than the number of
     * available life points, the fighter dies with no life points.
     * @param damaged_life_points the amount of life points to be subtracted.
     */
    //
    public void getDamaged(int damaged_life_points) {
        int overallDamage = damaged_life_points-armor.getDefense();
        this.armor.setDefense(this.armor.getDefense()-1);
        if(overallDamage>0) {
            if (overallDamage <= life_points)
                life_points = life_points - overallDamage;
            else life_points = 0;
        }
    }

    /**
     * The current fighter defeated the fighter passed as parameter increasing the
     * experience points accordingly.
     * @param f The defeated fighter
     */
    //
    public void defeated(Fighter f) {
        //isAlive()
        //! f.isAlive()
        experience_points = experience_points + f.experience_points/10+10;
    }


    /**
     * Return the damage inflicted by the weapon of the fighter
     * @return the damage inflicted
     */
    public int getWeaponDamage() {
        return this.weapon.getDamage();
    }

    /**
     * Returns the id of the fighter
     * @return the id of the fighter
     */
    public int getId() {
        return this.id;
    }

    /**
     * Changes the damage of the fighter's weapon with the given value
     * @param i The new damage of the weapon
     * @since 1.0
     */
    public void setWeaponDamage(int i) {
        this.weapon.setDamage(i);
    }
}
