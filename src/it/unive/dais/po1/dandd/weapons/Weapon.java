package it.unive.dais.po1.dandd.weapons;

public class Weapon {
    public final int damage;

    public Weapon(int i) {
        if(i>=0)
            this.damage = i;
        else this.damage = 0;
    }
}
