package it.unive.dais.po1.dandd.characters;

import it.unive.dais.po1.dandd.characters.magicians.Wizard;
import it.unive.dais.po1.dandd.protection.Protection;
import it.unive.dais.po1.dandd.weapon.OffensiveWeapon;
import it.unive.dais.po1.dandd.weapon.magic.Magic;

/**
 * This class is aimed at representing a fighter in D&D
 * Inspired by <a href="https://www.dndbeyond.com/classes/fighter">this webpage</a>
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public abstract class Figure {

    private static int number_of_instantiated_characters = 0;


    /**
     * The identifier of the fighter
     */
    public final int id;

    /**
     * @invariant experience_points >= 0
     *          && experience_points >= pre(experience_points)
     */
    private int experience_points;

    /**
     * @invariant life_points >= 0
     */
    private int life_points;



    /**
     * Creates a fighter
     * @param experience_points The initial amount of experience points
     * @param life_points The initial amount of life points
     */
    protected Figure(int experience_points, int life_points) {
        this.experience_points = experience_points;
        this.life_points = life_points;
        this.id = this.number_of_instantiated_characters;
        Figure.number_of_instantiated_characters = Figure.number_of_instantiated_characters+1;
    }

    /**
     * Return the damage inflicted by the figure's offensive mean
     * @return the damage inflicted
     */
    abstract public int getDamage();

    /**
     *
     * @return true iff the current fighter is alive
     */
    final public boolean isAlive() {
        return this.life_points>0;
    }

    /**
     * Provides the experience level of the fighter
     * @return The number representing the level of the fighter
     */
    final public int getLevel() {
        return experience_points/1000+1;
    }

    /**
     * The fighter got damaged by the given amount of life points.
     * If the amount of subtracted life points is greater than the number of
     * available life points, the fighter dies with no life points.
     * @param damaged_life_points the amount of life points to be subtracted.
     */
    //
    public void decreaseLifePoints(int damaged_life_points) {
        if(damaged_life_points>0) {
            if (damaged_life_points <= life_points)
                life_points = life_points - damaged_life_points;
            else life_points = 0;
        }
    }

    /**
     * The current fighter defeated the fighter passed as parameter increasing the
     * experience points accordingly.
     * @param f The defeated fighter
     */
    //
    final public void defeated(Figure f) {
        //isAlive()
        //! f.isAlive()
        experience_points = experience_points + f.experience_points/10+10;
        Protection defeatedprot = f.getProtection();
        OffensiveWeapon offensiveweap = f.getOffensiveWeapon();
        if(defeatedprot.getInfoDefence() > this.getProtection().getInfoDefence())
            this.setProtection(defeatedprot);
        if(offensiveweap.getInfoDamage()>this.getOffensiveWeapon().getInfoDamage())
            this.setOffensiveWeapon(offensiveweap);
    }

    public abstract void setOffensiveWeapon(OffensiveWeapon offensiveweap);

    public abstract void setProtection(Protection defeatedprot);

    public abstract OffensiveWeapon getOffensiveWeapon();

    public abstract Protection getProtection();


    /**
     * Returns the id of the fighter
     * @return the id of the fighter
     */
    public int getId() {
        return this.id;
    }

}
