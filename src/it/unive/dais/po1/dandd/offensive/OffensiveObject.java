package it.unive.dais.po1.dandd.offensive;

public interface OffensiveObject {
    default public int getDamage() {
        return this.getInnerDamage();
    }

    default public int getInfoDamage() {
        return this.getInnerDamage();
    }

    /*public*/ int getInnerDamage();


}
