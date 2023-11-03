package it.unive.dais.po1.dandd.fight;

import it.unive.dais.po1.dandd.characters.magicians.Wizard;


/**
 * This class is aimed at representing a fight between two
 * fighters in D&D
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class FightBetweenWizards {
    private Wizard w1, w2;

    public FightBetweenWizards(Wizard w1, Wizard w2) {
        this.w1 = w1;
        this.w2 = w2;
    }

    /*private boolean singleFight() {
        Random random = new Random();
        if(w1.isAlive() && w2.isAlive()) {
            if(random.nextDouble()>=0.5) {
                w2.getDamaged(w1.getMagicDamage());
            }
            else {
                w1.getDamaged(w2.getMagicDamage());
            }
        }
        return w1.isAlive() && w2.isAlive();
    }*/

    /**
     *
     * @requires true
     * @ensures
     *      (return == 1 ->
     *          w1.isAlive() && ! w2.isAlive() &&
     *          w1.getLevel() >= pre(w1.getLevel()))
     *         &&
     *      (return == 2 ->
     *          w2.isAlive() && ! w1.isAlive() &&
     *          w2.getLevel() >= pre(w2.getLevel()))
     */
    /*public int fight() {
        while(this.singleFight());
        if(w1.isAlive()) {
            w1.defeated(w2);
            return 1;
        }
        else {w2.defeated(w1);
            return 2;
        }
    }*/

}
