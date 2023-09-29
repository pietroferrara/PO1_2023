public class Fighter {
    int experience_points = 0;
    Weapon weapon;
    Armor armor;
    int life_points = 100;

    Fighter(Weapon w1, Armor a1) {
        this.weapon = w1;
        this.armor = a1;
    }

    //Return true iff the current fighter is alive
    boolean isAlive() {
        return life_points>0;
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
}
