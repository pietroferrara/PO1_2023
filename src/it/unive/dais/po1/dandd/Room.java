package it.unive.dais.po1.dandd;

import it.unive.dais.po1.dandd.figures.Figure;
import it.unive.dais.po1.dandd.fight.FightBetweenFigure;
import it.unive.dais.po1.dandd.fight.MissingFigureException;
import it.unive.dais.po1.dandd.objects.DaDObject;
import it.unive.dais.po1.dandd.objects.defensive.DefensiveObject;
import it.unive.dais.po1.dandd.objects.offensive.OffensiveObject;

import java.util.Collection;

public class Room {
    private Collection<DaDObject> objs;
    private Figure guardian;

    public Room(Collection<DaDObject> objs, Figure guardian) {
        this.objs = objs;
        this.guardian = guardian;
    }

    public boolean enter(Figure f) {
        if(f==null)
            return false;
        if(guardian!=null) {
            try {
                int result = new FightBetweenFigure(f, guardian).fight();
                if (result != 1)
                    return false;
            }
            catch(MissingFigureException e) {
                throw new UnexpectedBehaviorError(
                        "I'm always passing two figures to the fight, but it still complains.",
                        e);
            }
        }
        for(DaDObject obj : objs) {
            if(obj instanceof DefensiveObject)
                f.collectDefensiveObject((DefensiveObject) obj);
            else if(obj instanceof OffensiveObject)
                f.collectOffensiveObject((OffensiveObject) obj);
        }
        return true;
    }
}
