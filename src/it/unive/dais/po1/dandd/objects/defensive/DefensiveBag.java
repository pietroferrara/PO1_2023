package it.unive.dais.po1.dandd.objects.defensive;

import it.unive.dais.po1.dandd.characters.Bag;

public class DefensiveBag<T extends DefensiveObject> extends Bag<T> {


    public T getBestDefensiveObject() {
        T result = null;
        for(T el : this) {
            if(result == null)
                result = el;
            else {
                if(el.getInfoDefense() > result.getInfoDefense())
                    result = el;
            }
        }
        return result;
    }
}
