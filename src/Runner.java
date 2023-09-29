import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        Fighter f1 = new Fighter();
        Weapon w1 = new Weapon();
        w1.damage = 10;
        Armor a1 = new Armor();
        a1.defense = 2;
        f1.weapon = w1;
        f1.armor = a1;

        Fighter f2 = new Fighter();
        Weapon w2 = new Weapon();
        w2.damage = 5;
        Armor a2 = new Armor();
        a2.defense = 4;
        f2.weapon = w2;
        f2.armor = a2;

        Fighter winner = fight(f1, f2);
        if(f1.isAlive())
            System.out.println("The first fighter won!");
        else System.out.println("The second fighter won!");
    }

    private static Fighter fight(Fighter f1, Fighter f2) {
        Random random = new Random();
        while(f1.isAlive() && f2.isAlive()) {
            if(random.nextDouble()>=0.5)
                f2.getDamaged(f1.weapon);
            else f1.getDamaged(f2.weapon);
        }
        if(f1.isAlive()) {
            f1.defeated(f2);
            return f1;
        }
        else {f2.defeated(f1);
            return f2;
        }
    }
}
