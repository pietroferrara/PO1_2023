package it.unive.dais.po1.dandd.weapon.magic;

import it.unive.dais.po1.dandd.weapon.OffensiveWeapon;

public class Magic extends OffensiveWeapon {
    private int defense;
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

    public int getDamage() {
        int damage = super.getDamage();
        if(this.skip_next_rounds>0) {
            this.skip_next_rounds --;
            return 0;
        }
        this.skip_next_rounds = this.recovery;
        return damage;
    }
}
