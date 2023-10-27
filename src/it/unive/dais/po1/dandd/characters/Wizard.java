package it.unive.dais.po1.dandd.characters;

import it.unive.dais.po1.dandd.armors.Armor;
import it.unive.dais.po1.dandd.magic.Magic;
import it.unive.dais.po1.dandd.weapons.Weapon;

/**
 * https://www.dndbeyond.com/classes/wizard
 */
public class Wizard {


    private static int number_of_instantiated_wizards = 0;

    private static final int MAX_ID = 100;

    /**
     * The identifier of the wizard
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

    private Magic magia;


    /**
     * Initializes a fighter without any experience and with full life points
     */
    public Wizard(Magic m1) {

        this(0, 100, m1);
    }

    /**
     * Creates a fighter
     * @param experience_points The initial amount of experience points
     * @param life_points The initial amount of life points
     */
    Wizard(int experience_points, int life_points, Magic m1) {
        this.experience_points = experience_points;
        this.life_points = life_points;
        this.magia = m1;
        this.id = this.number_of_instantiated_wizards;
        Wizard.number_of_instantiated_wizards = Wizard.number_of_instantiated_wizards+1;
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
        int overallDamage = damaged_life_points-magia.getDefense();
        this.magia.setDefense(this.magia.getDefense()-1);
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

    //TODO: FIX THIS
    public void defeated(Wizard w) {
        //isAlive()
        //! f.isAlive()
        experience_points = experience_points + w.experience_points/10+10;
    }

    /**
     * Returns the id of the fighter
     * @return the id of the fighter
     */
    public int getId() {
        return this.id;
    }

    public int getMagicDamage() {
        return this.magia.getDamage();
    }

}
