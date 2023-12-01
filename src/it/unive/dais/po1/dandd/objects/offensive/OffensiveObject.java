package it.unive.dais.po1.dandd.objects.offensive;

import it.unive.dais.po1.dandd.objects.DaDObject;

public interface OffensiveObject extends DaDObject {
    default public int getDamage() {
        return this.getInnerDamage();
    }

    default public int getInfoDamage() {
        return this.getInnerDamage();
    }

    /*public*/ int getInnerDamage();


}
