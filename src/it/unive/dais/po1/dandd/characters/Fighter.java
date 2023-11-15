package it.unive.dais.po1.dandd.characters;

import it.unive.dais.po1.dandd.characters.magicians.Wizard;
import it.unive.dais.po1.dandd.protection.Armor;
import it.unive.dais.po1.dandd.weapon.fighter.Sword;
import it.unive.dais.po1.dandd.weapon.magic.Magic;

/**
 * This class is aimed at representing a fighter in D&D
 * Inspired by <a href="https://www.dndbeyond.com/classes/fighter">this webpage</a>
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class Fighter extends Figure {



    private Sword weapon;
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
        this.weapon = w1;
        this.armor = a1;
    }

    /**
     * The fighter got damaged by the given amount of life points.
     * If the amount of subtracted life points is greater than the number of
     * available life points, the fighter dies with no life points.
     *  damaged_life_points the amount of life points to be subtracted.
     */
    //
    /*public void getDamaged(int damaged_life_points) {
        int overallDamage = damaged_life_points-armor.getDefense();
        this.armor.setDefense(this.armor.getDefense()-1);
        if(overallDamage>0) {
            if (overallDamage <= life_points)
                life_points = life_points - overallDamage;
            else life_points = 0;
        }
    }*/


    @Override
    public int getDamage() {
        return this.weapon.getDamage();
    }

    @Override
    public void defeated(Figure f) {
        super.defeated(f);
        if (f instanceof Fighter) {
            Fighter f1 = (Fighter) f;
            Sword s = f1.weapon;
            Armor a = f1.armor;
            if(s.getInfoDamage() > this.weapon.getInfoDamage())
                this.weapon = s;
            if(a.getInfoDefence() > this.armor.getInfoDefence())
                this.armor = a;
        }
    }
}
