package it.unive.dais.po1.dandd;

import it.unive.dais.po1.dandd.figures.Figure;
import it.unive.dais.po1.dandd.fight.MissingFigureException;
import it.unive.dais.po1.dandd.objects.defensive.Armor;
import it.unive.dais.po1.dandd.figures.Fighter;
import it.unive.dais.po1.dandd.figures.Wizard;
import it.unive.dais.po1.dandd.fight.FightBetweenFigure;
import it.unive.dais.po1.dandd.objects.offensive.fighter.Sword;
import it.unive.dais.po1.dandd.objects.offensive.magic.Magic;

import java.util.Random;

public class RunnerFigures {
    int i;

    public static void main(String[] args) throws MissingFigureException {

        new FightBetweenFigure(null, null);

        Sword w1 = new Sword(10);
        Armor a1 = new Armor(2);
        Figure figure1 = new Fighter(w1,a1);

        Magic m1 = new Magic(3, 5, 3);
        Figure figure2 = new Wizard(m1);




        for(int j = 0; j < 3; j++) {

            for(int i = 0; i < 150; i++) {
                int winner = new FightBetweenFigure(figure1, figure2).fight();
                switch(winner) {
                    case 1:
                        System.out.println("The fighter " + figure1 + " won!");
                        figure2 = new Random().nextDouble()>=0.5 ?
                                new Wizard(m1) :
                                new Fighter(w1,a1);
                        break;
                    case 2:
                        System.out.println("The wizard " + figure2 + " won!");
                        figure1 = new Random().nextDouble()>=0.5 ?
                                new Wizard(m1) :
                                new Fighter(w1,a1);
                        break;
                    default: System.err.println("This looks odd");
                }
            }
        }

        System.out.println("Created "+Fighter.getNumberOfInstantiatedFigures()+" fighters");

        System.out.println("Created "+Wizard.getNumberOfInstantiatedFigures()+" wizards");
    }

}
