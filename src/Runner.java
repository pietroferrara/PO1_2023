import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        Weapon w1 = new Weapon(10);
        Armor a1 = new Armor(2);
        Fighter f1 = new Fighter(w1,a1);
        Weapon w2 = new Weapon(5);
        Armor a2 = new Armor(4);

        Fighter f2 = new Fighter(w2, a2);

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
