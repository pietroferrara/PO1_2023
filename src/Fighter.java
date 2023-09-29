public class Fighter {
    int experience_points = 0;
    Weapon weapon;
    Armor armor;
    int life_points = 100;

    boolean isAlive() {
        return life_points>0;
    }

    int getLevel() {
        return experience_points/1000+1;
    }

    void getDamaged(Weapon w) {
        int overallDamage = w.damage-armor.defense;
        if(overallDamage>0) {
            if (overallDamage <= life_points)
                life_points = life_points - overallDamage;
            else life_points = 0;
        }
    }

    void defeated(Fighter f) {
        //isAlive()
        //! f.isAlive()
        experience_points = experience_points + f.experience_points/10+10;
    }
}
