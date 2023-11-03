package it.unive.dais.po1.dandd.fight;

import it.unive.dais.po1.dandd.characters.Figure;

import java.util.Random;


/**
 * This class is aimed at representing a fight between two
 * fighters in D&D
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class FightBetweenFigure {
    private Figure c1, c2;

    public FightBetweenFigure(Figure c1, Figure c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    /**
     *
     * @requires true
     * @ensures
     *     (c2.getLifePoints() == pre(c2.getLifePoints())-c1.weapon.damage AND
     *       c1.getWeapon().getDamage() == pre(c1.getWeapon().getDamage())-1)
     *     OR
     *     (c1.life_points == pre(c1.life_points)-c2.weapon.damage AND
     *       c2.weapon.damage == pre(c2.weapon.damage)-1)
     */
    private boolean singleFight() {
        Random random = new Random();
        if(c1.isAlive() && c2.isAlive()) {
            if(random.nextDouble()>=0.5) {
                //c2.getDamaged(c1.getWeaponDamage());
                //c1.setWeaponDamage(c1.getWeaponDamage()-1);
            }
            else {
                //c1.getDamaged(c2.getWeaponDamage());
                //c2.setWeaponDamage(c2.getWeaponDamage()-1);
            }
        }
        return c1.isAlive() && c2.isAlive();
    }

    /**
     *
     * @requires true
     * @ensures
     *      (return == 1 ->
     *          c1.isAlive() && ! c2.isAlive() &&
     *          c1.getLevel() >= pre(c1.getLevel()))
     *         &&
     *      (return == 2 ->
     *          c2.isAlive() && ! c1.isAlive() &&
     *          c2.getLevel() >= pre(c2.getLevel()))
     */
    public int fight() {
        while(this.singleFight());
        if(c1.isAlive()) {
            c1.defeated(c2);
            return 1;
        }
        else {c2.defeated(c1);
            return 2;
        }
    }

}
