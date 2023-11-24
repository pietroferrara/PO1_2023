package it.unive.dais.po1.dandd.offensive;

import it.unive.dais.po1.dandd.characters.Bag;

public class OffensiveBag<T extends OffensiveObject> extends Bag<T> {

    public T getBestOffensiveObject() {
        T result = this.get(0);
        for(int i = 1; i < this.length(); i++) {
            T current = this.get(i);
            if(current.getInfoDamage() > result.getInfoDamage())
                result = current;
        }
        return result;
    }
}
