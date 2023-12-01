package it.unive.dais.po1.dandd.objects.offensive;

import it.unive.dais.po1.dandd.characters.Bag;

import java.util.Iterator;

public class OffensiveBag<T extends OffensiveObject> extends Bag<T> {

    public T getBestOffensiveObject() {
        Iterator<T> it = this.iterator();
        T result = it.next();
        while(it.hasNext()) {
            T current = it.next();
            if(current.getInfoDamage() > result.getInfoDamage())
                result = current;
        }
        return result;

        /*T result = this.get(0);
        for(int i = 1; i < this.length(); i++) {
            T current = this.get(i);
            if(current.getInfoDamage() > result.getInfoDamage())
                result = current;
        }
        return result;*/
    }
}
