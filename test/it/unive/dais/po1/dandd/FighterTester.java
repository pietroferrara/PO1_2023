package it.unive.dais.po1.dandd;

import it.unive.dais.po1.dandd.figures.Fighter;
import it.unive.dais.po1.dandd.figures.Figure;
import it.unive.dais.po1.dandd.figures.Wizard;
import it.unive.dais.po1.dandd.objects.defensive.Armor;
import it.unive.dais.po1.dandd.objects.offensive.fighter.Sword;
import it.unive.dais.po1.dandd.objects.offensive.magic.Magic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FighterTester {

    @Test
    public void test1() {
        Sword w1 = new Sword(10);
        Armor a1 = new Armor(2);
        Figure figure1 = new Fighter(w1,a1);
        Assertions.assertTrue(figure1.isAlive());//MUST BE TRUE
    }

    @Test
    public void test2() {
        Magic m1 = new Magic(3, 5, 3);
        Figure figure2 = new Wizard(m1);
        Assertions.assertTrue(figure2.isAlive());//MUST BE TRUE
    }


    @Test
    public void test3() {
        Sword w1 = new Sword(10);
        Armor a1 = new Armor(2);
        Figure figure1 = new Fighter(w1,a1);
        Assertions.assertTrue(figure1.isAlive());//MUST BE TRUE
    }
}
