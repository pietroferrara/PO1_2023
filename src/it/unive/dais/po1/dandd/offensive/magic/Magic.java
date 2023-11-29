package it.unive.dais.po1.dandd.offensive.magic;

import it.unive.dais.po1.dandd.defensive.DefensiveObject;
import it.unive.dais.po1.dandd.offensive.OffensiveObject;

public class Magic implements OffensiveObject, DefensiveObject {
    private int defense;
    private int damage;
    private int recovery;

    private int skip_next_rounds;

    public Magic(int defense, int damage, int recovery) {
        if(damage>=0)
            this.damage = damage;
        else this.damage = 1;
        if(defense>=0)
            this.defense = defense;
        else this.defense = 0;
        if(recovery>=0)
            this.recovery = recovery;
        else recovery = 0;
        skip_next_rounds = 0;
    }

    public int getDefense() {
        if(this.skip_next_rounds>0)
            return 0;
        else
            return this.defense;
    }

    @Override
    public String toString() {
        return "Magic{" +
                "defense=" + defense +
                ", damage=" + damage +
                ", recovery=" + recovery +
                ", skip_next_rounds=" + skip_next_rounds +
                '}';
    }

    @Override
    public int getDamage() {
        int damage = this.getInnerDamage();
        if(this.skip_next_rounds>0) {
            this.skip_next_rounds --;
            return 0;
        }
        this.skip_next_rounds = this.recovery;
        return damage;
    }

    @Override
    public int getInnerDamage() {
        return this.damage;
    }


    public int getInfoDefence() {
        return this.defense;
    }
}
