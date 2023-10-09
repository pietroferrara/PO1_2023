package it.unive.dais.po1.dandd.characters;

import it.unive.dais.po1.dandd.armors.Armor;
import it.unive.dais.po1.dandd.weapons.Weapon;

import java.util.Random;

//Inspired by https://www.dndbeyond.com/classes/fighter
public class Fighter {

    private static int number_of_instantiated_fighters = 0;

    private static final int MAX_ID = 100;

    private final int id;
    private int experience_points;
    private Weapon weapon;
    private Armor armor;
    private int life_points;


    public Fighter(Weapon w1, Armor a1) {
        this(0, 100, w1, a1);
    }

    Fighter(int experience_points, int life_points, Weapon w1, Armor a1) {
        this.experience_points = experience_points;
        this.life_points = life_points;
        this.weapon = w1;
        this.armor = a1;
        this.id = this.number_of_instantiated_fighters;
        Fighter.number_of_instantiated_fighters = Fighter.number_of_instantiated_fighters+1;
        if(Fighter.number_of_instantiated_fighters > Fighter.MAX_ID)
            Fighter.reset_world();
    }

    //Return true iff the current fighter is alive
    public boolean isAlive() {
        return this.life_points>0;
    }

    //Returns the level of the current fighter
    public int getLevel() {
        return experience_points/1000+1;
    }

    //The current fighter got damaged by the given weapon
    public void getDamaged(int damaged_life_points) {
        int overallDamage = damaged_life_points-armor.getDefense();
        this.armor.setDefense(this.armor.getDefense()-1);
        if(overallDamage>0) {
            if (overallDamage <= life_points)
                life_points = life_points - overallDamage;
            else life_points = 0;
        }
    }

    //The current fighter defeated the fighter passed as parameter
    public void defeated(Fighter f) {
        //isAlive()
        //! f.isAlive()
        experience_points = experience_points + f.experience_points/10+10;
    }

    static void reset_world() {
        Fighter.number_of_instantiated_fighters = 0;
    }

    public int getWeaponDamage() {
        return this.weapon.getDamage();
    }

    public int getId() {
        return this.id;
    }

    public void setWeaponDamage(int i) {
        this.weapon.setDamage(i);
    }
}
