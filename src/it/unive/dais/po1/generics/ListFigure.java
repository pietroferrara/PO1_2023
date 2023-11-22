package it.unive.dais.po1.generics;

import it.unive.dais.po1.dandd.characters.Figure;
import it.unive.dais.po1.dandd.fight.FightBetweenFigure;

public class ListFigure<T extends Figure> extends List<T> {

    public T fight() {
        T winner = this.get(0);
        for(int i = 1; i < this.length(); i++) {
            new FightBetweenFigure(winner, this.get(i)).singleFight();
            if(! winner.isAlive())
                winner = this.get(i);
        }
        return winner;
    }
}
