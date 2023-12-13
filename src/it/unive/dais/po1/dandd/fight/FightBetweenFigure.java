package it.unive.dais.po1.dandd.fight;

import it.unive.dais.po1.dandd.UnexpectedBehaviorError;
import it.unive.dais.po1.dandd.figures.Fighter;
import it.unive.dais.po1.dandd.figures.Figure;
import it.unive.dais.po1.dandd.figures.FigureAlreadyDeadException;
import it.unive.dais.po1.dandd.figures.Wizard;

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

    /**
     *
     * @param c1 The first figure involved in the fight
     * @param c2 The second figure involved in the fight
     * @throws MissingFigureException If one of the two figures is null
     */
    public FightBetweenFigure(Figure c1, Figure c2) throws MissingFigureException {
        assert c1!=null && c2!=null : "null values not allowed here";
        if(c1==null || c2==null)
            throw new MissingFigureException("Building a fight between two figures, but passing only one or no figure at all");
        this.c1 = c1;
        this.c2 = c2;
    }

    public FightBetweenFigure(Object[] arr) throws MissingFigureException {
        for(int i=0; i<arr.length; i++) {
            if (arr[i] instanceof Figure) {
                if (this.c1 == null)
                    this.c1 = (Figure) arr[i];
                else {
                    this.c2 = (Figure) arr[i];
                    return;
                }
            }
        }
        throw new MissingFigureException("Building a fight between two figures, but passing only one or no figure at all");
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
            try {
                if (random.nextDouble() >= 0.5) {
                    if (c2 instanceof Wizard)
                        this.damageFirstFigure((Wizard) c2, c1);
                    else this.damageFirstFigure(c2, c1);
                } else {
                    damageFirstFigure(c1, c2);
                }
            }
            catch(FigureAlreadyDeadException e) {
                throw new UnexpectedBehaviorError("The two figures were alive, but then they had no life point", e);
            }
        }
        return c1.isAlive() && c2.isAlive();
    }

    private void damageFirstFigure(Figure f1, Figure f2) throws FigureAlreadyDeadException {
        System.out.println("Damage between two figures");
        f1.decreaseLifePoints(f2.getDamage());
    }

    private void damageFirstFigure(Fighter f1, Fighter f2) throws FigureAlreadyDeadException {
        System.out.println("Damage between two fighters");
        f1.decreaseLifePoints(f2.getDamage());
    }

    private void damageFirstFigure(Wizard f1, Wizard f2) throws FigureAlreadyDeadException {
        System.out.println("Damage between two wizard");
        f1.decreaseLifePoints(f2.getDamage());
    }


    private void damageFirstFigure(Figure f1, Fighter f2) throws FigureAlreadyDeadException {
        System.out.println("Damage between a figure and a fighter");
        f1.decreaseLifePoints(f2.getDamage());
    }

    private void damageFirstFigure(Wizard f1, Figure f2) throws FigureAlreadyDeadException {
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
