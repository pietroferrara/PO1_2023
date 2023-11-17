package it.unive.dais.po1.dandd.characters.magicians;

import it.unive.dais.po1.dandd.characters.Fighter;
import it.unive.dais.po1.dandd.characters.Figure;
import it.unive.dais.po1.dandd.protection.Protection;
import it.unive.dais.po1.dandd.weapon.OffensiveWeapon;
import it.unive.dais.po1.dandd.weapon.magic.Magic;

/**
 * https://www.dndbeyond.com/classes/wizard
 */
final public class Wizard extends Figure {
    private static int numberOfWizards = 0;

    public static int getNumberOfInstantiatedFigures() {
        return Wizard.numberOfWizards;
    }


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
        Wizard.numberOfWizards++;
        this.magia = m1;
    }



    @Override
    public int getDamage() {
        return this.magia.getDamage();
    }

    public Magic getMagia() {
        return this.magia;
    }

    @Override
    public void setOffensiveWeapon(OffensiveWeapon offensiveweap) {
        if(offensiveweap instanceof Magic)
            this.magia = (Magic) offensiveweap;
    }

    @Override
    public void setProtection(Protection defeatedprot) {
        if(defeatedprot instanceof Magic)
            this.magia = (Magic) defeatedprot;

    }

    @Override
    public OffensiveWeapon getOffensiveWeapon() {
        return this.magia;
    }

    @Override
    public Protection getProtection() {
        return this.magia;
    }
}
