package it.unive.dais.po1.generics;

import it.unive.dais.po1.dandd.figures.Figure;
import it.unive.dais.po1.dandd.fight.FightBetweenFigure;
import it.unive.dais.po1.dandd.fight.MissingFigureException;

public class ListFigure<T extends Figure> extends List<T> {

    public T fight() throws MissingFigureException {
        T winner = this.get(0);
        for(int i = 1; i < this.length(); i++) {
            new FightBetweenFigure(winner, this.get(i)).singleFight();
            if(! winner.isAlive())
                winner = this.get(i);
        }
        return winner;
    }
}
