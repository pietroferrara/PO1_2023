package it.unive.dais.po1.dandd;

import it.unive.dais.po1.dandd.protection.Armor;
import it.unive.dais.po1.dandd.characters.Fighter;
import it.unive.dais.po1.dandd.characters.magicians.Wizard;
import it.unive.dais.po1.dandd.fight.FightBetweenFigure;
import it.unive.dais.po1.dandd.weapon.fighter.Sword;
import it.unive.dais.po1.dandd.weapon.magic.Magic;
public class RunnerFigures {
    int i;

    public static void main(String[] args) {
        Sword w1 = new Sword(10);
        Armor a1 = new Armor(2);
        Fighter f1 = new Fighter(w1,a1);

        Magic m1 = new Magic(3, 5, 3);
        Wizard wiz1 = new Wizard(m1);

        for(int j = 0; j < 3; j++) {

            for(int i = 0; i < 150; i++) {
                int winner = new FightBetweenFigure(f1, wiz1).fight();
                switch(winner) {
                    case 1:
                        System.out.println("The fighter " + f1.getId() + " won!");
                        wiz1 = new Wizard(m1);
                        break;
                    case 2:
                        System.out.println("The wizard " + wiz1.getId() + " won!");
                        f1 = new Fighter(w1, a1);
                        break;
                    default: System.err.println("This looks odd");
                }
            }
        }
    }

}
