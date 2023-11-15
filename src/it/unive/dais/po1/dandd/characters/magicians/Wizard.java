package it.unive.dais.po1.dandd.characters.magicians;

import it.unive.dais.po1.dandd.characters.Fighter;
import it.unive.dais.po1.dandd.characters.Figure;
import it.unive.dais.po1.dandd.weapon.magic.Magic;

/**
 * https://www.dndbeyond.com/classes/wizard
 */
final public class Wizard extends Figure {

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
        super(experience_points, life_points);
        this.magia = m1;
    }


    /**
     * The fighter got damaged by the given amount of life points.
     * If the amount of subtracted life points is greater than the number of
     * available life points, the fighter dies with no life points.
     * @param damaged_life_points the amount of life points to be subtracted.
     */
    //
    /*public void getDamaged(int damaged_life_points) {
        int overallDamage = damaged_life_points-magia.getDefense();
        this.magia.setDefense(this.magia.getDefense()-1);
        if(overallDamage>0) {
            if (overallDamage <= life_points)
                life_points = life_points - overallDamage;
            else life_points = 0;
        }
    }*/

    @Override
    public int getDamage() {
        return this.magia.getDamage();
    }

    public Magic getMagia() {
        return this.magia;
    }

    @Override
    public void defeated(Figure f) {
        super.defeated(f);
        if (f instanceof Wizard) {
            Wizard w = (Wizard) f;
            Magic m = w.getMagia();
            if(m.getInfoDamage()+m.getInfoDefence() >
                this.magia.getInfoDefence()+this.magia.getInfoDamage())
                this.magia = m;
        }
    }
}
