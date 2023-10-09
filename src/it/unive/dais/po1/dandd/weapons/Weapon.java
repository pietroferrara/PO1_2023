package it.unive.dais.po1.dandd.weapons;

public class Weapon {
    private int damage;

    public Weapon(int i) {
        if(i>0)
            this.damage = i;
        else this.damage = 1;
    }

    public void setDamage(int i) {
        if(i > 0)
            this.damage = i;
    }

    public int getDamage() {
        return this.damage;
    }
}
