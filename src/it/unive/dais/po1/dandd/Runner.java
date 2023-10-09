package it.unive.dais.po1.dandd;

import it.unive.dais.po1.dandd.armors.Armor;
import it.unive.dais.po1.dandd.characters.Fighter;
import it.unive.dais.po1.dandd.fight.Fight;
import it.unive.dais.po1.dandd.weapons.Weapon;

import java.util.Arrays;
import java.util.Random;

public class Runner {
    int i;

    public static void main(String[] args) {
        int[] foo = {3, 10, -1, 4};

        Arrays.sort(foo);

        Weapon w1 = new Weapon(10);
        Armor a1 = new Armor(2);
        Fighter f1 = new Fighter(w1,a1);
        Weapon w2 = new Weapon(5);
        Armor a2 = new Armor(4);

        Fighter f2 = new Fighter(w2, a2);

        for(int j = 0; j < 3; j++) {

            for(int i = 0; i < 150; i++) {
                int winner = new Fight(f1, f2).fight();
                switch(winner) {
                    case 1:
                        System.out.println("The fighter " + f1.getId() + " won!");
                        f2 = new Fighter(w2, a2);
                        break;
                    case 2:
                        System.out.println("The fighter " + f2.getId() + " won!");
                        f1 = new Fighter(w1, a1);
                        break;
                    default: System.err.println("This looks odd");
                }
            }
        }
    }

}
