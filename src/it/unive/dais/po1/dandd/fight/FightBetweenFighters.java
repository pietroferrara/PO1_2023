package it.unive.dais.po1.dandd.fight;

import it.unive.dais.po1.dandd.characters.Fighter;

import java.util.Random;


/**
 * This class is aimed at representing a fight between two
 * fighters in D&D
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class FightBetweenFighters {
    private Fighter f1, f2;

    public FightBetweenFighters(Fighter f1, Fighter f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    /**
     *
     * @requires true
     * @ensures
     *     (f2.getLifePoints() == pre(f2.getLifePoints())-f1.weapon.damage AND
     *       f1.getWeapon().getDamage() == pre(f1.getWeapon().getDamage())-1)
     *     OR
     *     (f1.life_points == pre(f1.life_points)-f2.weapon.damage AND
     *       f2.weapon.damage == pre(f2.weapon.damage)-1)
     */
    private boolean singleFight() {
        Random random = new Random();
        if(f1.isAlive() && f2.isAlive()) {
            if(random.nextDouble()>=0.5) {
                f2.getDamaged(f1.getWeaponDamage());
                f1.setWeaponDamage(f1.getWeaponDamage()-1);
            }
            else {
                f1.getDamaged(f2.getWeaponDamage());
                f2.setWeaponDamage(f2.getWeaponDamage()-1);
            }
        }
        return f1.isAlive() && f2.isAlive();
    }

    /**
     *
     * @requires true
     * @ensures
     *      (return == 1 ->
     *          f1.isAlive() && ! f2.isAlive() &&
     *          f1.getLevel() >= pre(f1.getLevel()))
     *         &&
     *      (return == 2 ->
     *          f2.isAlive() && ! f1.isAlive() &&
     *          f2.getLevel() >= pre(f2.getLevel()))
     */
    public int fight() {
        while(this.singleFight());
        if(f1.isAlive()) {
            f1.defeated(f2);
            return 1;
        }
        else {f2.defeated(f1);
            return 2;
        }
    }

}
