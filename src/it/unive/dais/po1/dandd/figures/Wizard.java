package it.unive.dais.po1.dandd.figures;

import it.unive.dais.po1.dandd.objects.defensive.DefensiveBag;
import it.unive.dais.po1.dandd.objects.defensive.DefensiveObject;
import it.unive.dais.po1.dandd.objects.offensive.OffensiveBag;
import it.unive.dais.po1.dandd.objects.offensive.OffensiveObject;
import it.unive.dais.po1.dandd.objects.offensive.magic.Magic;

/**
 * https://www.dndbeyond.com/classes/wizard
 */
final public class Wizard extends Figure {
    private static int numberOfWizards = 0;

    public static int getNumberOfInstantiatedFigures() {
        return Wizard.numberOfWizards;
    }


    private OffensiveBag<Magic> offensiveMagic;
    private DefensiveBag<Magic> defensiveMagic;


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
        this.defensiveMagic = new DefensiveBag<Magic>();
        this.defensiveMagic.add(m1);
        this.offensiveMagic = new OffensiveBag<Magic>();
        this.offensiveMagic.add(m1);
    }



    @Override
    public int getDamage() {
        return this.getCurrentOffensiveObject().getDamage();
    }

    @Override
    public void collectOffensiveObject(OffensiveObject offensiveweap) {
        if(offensiveweap instanceof Magic) {
            this.defensiveMagic.add((Magic) offensiveweap);
            this.offensiveMagic.add((Magic) offensiveweap);
        }
    }

    @Override
    public void collectDefensiveObject(DefensiveObject defeatedprot) {
        if(defeatedprot instanceof Magic) {
            this.defensiveMagic.add((Magic) defeatedprot);
            this.offensiveMagic.add((Magic) defeatedprot);
        }
    }

    @Override
    public OffensiveObject getCurrentOffensiveObject() {
        return this.offensiveMagic.getBestOffensiveObject();
    }

    @Override
    public DefensiveObject getCurrentDefensiveObject() {
        return this.defensiveMagic.getBestDefensiveObject();
    }

    @Override
    public Wizard clone() throws CloneNotSupportedException {
        return new Wizard(this.experience_points, this.life_points, this.defensiveMagic.getBestDefensiveObject());
    }

    @Override
    public String toString() {
        return "Wizard " +" magic=" + offensiveMagic + ", "+super.toString();
    }
}
