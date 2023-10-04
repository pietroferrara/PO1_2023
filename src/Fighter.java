import java.util.Random;

//Inspired by https://www.dndbeyond.com/classes/fighter
public class Fighter {

    static int number_of_instantiated_fighters = 0;

    static final int MAX_ID = 100;

    final int id;
    int experience_points;
    Weapon weapon;
    Armor armor;
    int life_points;


    Fighter(Weapon w1, Armor a1) {
        this(0, 100, w1, a1);
    }

    Fighter(int experience_points, int life_points, Weapon w1, Armor a1) {
        this.experience_points = experience_points;
        this.life_points = life_points;
        this.weapon = w1;
        this.armor = a1;
        this.id = Fighter.number_of_instantiated_fighters;
        Fighter.number_of_instantiated_fighters = Fighter.number_of_instantiated_fighters+1;
        if(Fighter.number_of_instantiated_fighters > Fighter.MAX_ID)
            Fighter.reset_world();
    }

    //Return true iff the current fighter is alive
    boolean isAlive() {
        return this.life_points>0;
    }

    void autodestroy() {
        while(this.isAlive())
            this.fight(this);
    }

    public Fighter fight(Fighter f) {
        Random random = new Random();
        while(this.isAlive() && f.isAlive()) {
            if(random.nextDouble()>=0.5)
                f.getDamaged(this.weapon);
            else this.getDamaged(f.weapon);
        }
        if(this.isAlive()) {
            this.defeated(f);
            return this;
        }
        else {
            f.defeated(this);
            return f;
        }
    }


    //Returns the level of the current fighter
    int getLevel() {
        return experience_points/1000+1;
    }

    //The current fighter got damaged by the given weapon
    void getDamaged(Weapon w) {
        int overallDamage = w.damage-armor.defense;
        if(overallDamage>0) {
            if (overallDamage <= life_points)
                life_points = life_points - overallDamage;
            else life_points = 0;
        }
    }

    //The current fighter defeated the fighter passed as parameter
    void defeated(Fighter f) {
        //isAlive()
        //! f.isAlive()
        experience_points = experience_points + f.experience_points/10+10;
    }

    static void reset_world() {
        Fighter.number_of_instantiated_fighters = 0;
    }
}
