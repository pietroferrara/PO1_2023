package it.unive.dais.po1.dandd.defensive;


/**
 * This class is aimed at representing an armor in D&D
 *
 * @since 1.0
 * @author Pietro Ferrara pietro.ferrara@unive.it
 */
public class Armor implements DefensiveObject {

    private int defense;

    public Armor(int i) {
        if(i>=0)
            this.defense = i;
        else this.defense = 0;
    }

    public int getDefense() {
        return this.defense;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "defense=" + defense +
                '}';
    }

    @Override
    public int getInfoDefence() {
        return this.defense;
    }


}
