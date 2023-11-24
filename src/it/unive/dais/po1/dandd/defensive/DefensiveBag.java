package it.unive.dais.po1.dandd.defensive;

import it.unive.dais.po1.dandd.characters.Bag;

public class DefensiveBag<T extends DefensiveObject> extends Bag<T> {


    public T getBestDefensiveObject() {
        T result = this.get(0);
        for(int i = 1; i < this.length(); i++) {
            T current = this.get(i);
            if(current.getInfoDefence() > result.getInfoDefence())
                result = current;
        }
        return result;
    }
}
