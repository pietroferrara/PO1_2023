package it.unive.dais.po1.dandd.armors;

public class Armor {
    private int defense;

    public Armor(int i) {
        if(i>=0)
            this.defense = i;
        else this.defense = 0;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int i) {
        if(i>=0)
            this.defense = i;

    }
}
