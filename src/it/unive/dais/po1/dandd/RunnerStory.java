package it.unive.dais.po1.dandd;

import it.unive.dais.po1.dandd.characters.Figure;

public class RunnerStory
{

    public static void main(String[] args) {
        Figure myself = Factory.getFigure();
        for(Room r : Factory.story()) {
            if(! r.enter(myself))
                return;
            else System.out.println("Went through a room successfully");
        }
    }
}
