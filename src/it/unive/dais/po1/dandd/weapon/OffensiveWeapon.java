package it.unive.dais.po1.dandd.weapon;

public interface OffensiveWeapon {
    default public int getDamage() {
        return this.getInnerDamage();
    }

    default public int getInfoDamage() {
        return this.getInnerDamage();
    }

    /*public*/ int getInnerDamage();


}
