package it.unive.dais.po1.dandd.armors;

public class Armor {
    public final int defense;

    public Armor(int i) {
        if(i>=0)
            this.defense = i;
        else this.defense = 0;
    }
}
