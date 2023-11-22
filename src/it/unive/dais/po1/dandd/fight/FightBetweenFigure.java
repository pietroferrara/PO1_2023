package it.unive.dais.po1.dandd.fight;

import it.unive.dais.po1.dandd.characters.Fighter;
import it.unive.dais.po1.dandd.characters.Figure;
import it.unive.dais.po1.dandd.characters.magicians.Wizard;

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
    public boolean singleFight() {
        Random random = new Random();
        if(c1.isAlive() && c2.isAlive()) {
            if(random.nextDouble()>=0.5) {
                if(c2 instanceof Wizard)
                    this.damageFirstFigure((Wizard) c2, c1);
                else this.damageFirstFigure(c2, c1);
            }
            else {
                damageFirstFigure(c1, c2);
            }
        }
        return c1.isAlive() && c2.isAlive();
    }

    private void damageFirstFigure(Figure f1, Figure f2) {
        System.out.println("Damage between two figures");
        f1.decreaseLifePoints(f2.getDamage());
    }

    private void damageFirstFigure(Fighter f1, Fighter f2) {
        System.out.println("Damage between two fighters");
        f1.decreaseLifePoints(f2.getDamage());
    }

    private void damageFirstFigure(Wizard f1, Wizard f2) {
        System.out.println("Damage between two wizard");
        f1.decreaseLifePoints(f2.getDamage());
    }


    private void damageFirstFigure(Figure f1, Fighter f2) {
        System.out.println("Damage between a figure and a fighter");
        f1.decreaseLifePoints(f2.getDamage());
    }

    private void damageFirstFigure(Wizard f1, Figure f2) {
        System.out.println("Damage between a wizard and a figure");
        f1.decreaseLifePoints(f2.getDamage());
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
