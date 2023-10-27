package it.unive.dais.po1.dandd;

import it.unive.dais.po1.dandd.armors.Armor;
import it.unive.dais.po1.dandd.characters.Fighter;
import it.unive.dais.po1.dandd.characters.Wizard;
import it.unive.dais.po1.dandd.fight.FightBetweenFighters;
import it.unive.dais.po1.dandd.fight.FightBetweenWizards;
import it.unive.dais.po1.dandd.magic.Magic;
import it.unive.dais.po1.dandd.weapons.Weapon;

import java.util.Arrays;

public class RunnerWizard {
    int i;

    public static void main(String[] args) {
        int[] foo = {3, 10, -1, 4};

        Arrays.sort(foo);

        Magic m1 = new Magic(10, 3, 3);
        Wizard w1 = new Wizard(m1);
        Magic m2 = new Magic(5, 2, 2);
        Wizard w2 = new Wizard(m2);

        for(int j = 0; j < 3; j++) {

            for(int i = 0; i < 150; i++) {
                int winner = new FightBetweenWizards(w1, w2).fight();
                switch(winner) {
                    case 1:
                        System.out.println("The wizard " + w1.getId() + " won!");
                        w2 = new Wizard(m2);
                        break;
                    case 2:
                        System.out.println("The wizard " + w2.getId() + " won!");
                        w1 = new Wizard(m1);
                        break;
                    default: System.err.println("This looks odd");
                }
            }
        }
    }

}
