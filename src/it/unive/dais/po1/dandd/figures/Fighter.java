package it.unive.dais.po1.dandd.figures;

import it.unive.dais.po1.dandd.objects.defensive.Armor;
import it.unive.dais.po1.dandd.objects.defensive.DefensiveBag;
import it.unive.dais.po1.dandd.objects.defensive.DefensiveObject;
import it.unive.dais.po1.dandd.objects.offensive.OffensiveBag;
import it.unive.dais.po1.dandd.objects.offensive.OffensiveObject;
import it.unive.dais.po1.dandd.objects.offensive.fighter.Sword;

/**
 * This class is aimed at representing a fighter in D&D
 * Inspired by <a href="https://www.dndbeyond.com/classes/fighter">this webpage</a>
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class Fighter extends Figure {

    private static int numberOfFighters = 0;

    public static int getNumberOfInstantiatedFigures() {
        return Fighter.numberOfFighters;
    }

    private OffensiveBag<Sword> swords;
    private DefensiveBag<Armor> armors;

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
        numberOfFighters++;
        this.swords = new OffensiveBag<>();
        this.swords.add(w1);
        this.armors = new DefensiveBag<>();
        this.armors.add(a1);
    }

    @Override
    public int getDamage() {
        return this.getCurrentOffensiveObject().getDamage();
    }

    @Override
    public void collectOffensiveObject(OffensiveObject offensiveweap) {
        if(offensiveweap instanceof Sword) {
            this.swords.add((Sword) offensiveweap);
        }
    }

    @Override
    public String toString() {
        return "Fighter " +
                "swords=" + swords +
                ", armors=" + armors +", "+super.toString();
    }

    @Restore(amount = 1)
    public void restoreOffensiveWeapons() {
        for(Sword s : swords)
            s.restore(1);
    }

    @Restore(amount = 1)
    @SuppressWarnings({"unused"})
    public void restoreDefensiveWeapons() {
        for(Armor a : armors)
            a.restore(1);
    }


    @Override
    public void collectDefensiveObject(DefensiveObject defeatedprot) {
        if(defeatedprot instanceof Armor)
            this.armors.add((Armor) defeatedprot);
    }

    @Override
    public OffensiveObject getCurrentOffensiveObject() {
        return this.swords.getBestOffensiveObject();
    }

    @Override
    public DefensiveObject getCurrentDefensiveObject() {
        return this.armors.getBestDefensiveObject();
    }
}
