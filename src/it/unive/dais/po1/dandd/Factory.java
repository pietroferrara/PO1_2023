package it.unive.dais.po1.dandd;

import it.unive.dais.po1.dandd.characters.Fighter;
import it.unive.dais.po1.dandd.characters.Figure;
import it.unive.dais.po1.dandd.characters.Wizard;
import it.unive.dais.po1.dandd.objects.DaDObject;
import it.unive.dais.po1.dandd.objects.defensive.Armor;
import it.unive.dais.po1.dandd.objects.offensive.fighter.Sword;
import it.unive.dais.po1.dandd.objects.offensive.magic.Magic;

import java.util.*;

public class Factory {
    private static final Random randomGenerator = new Random(432543);

    public static Figure getFigure() {
        if(randomGenerator.nextBoolean()) {
            Magic m1 = Factory.getMagic();
            return new Wizard(m1);
        }
        else {
            Sword sw = Factory.getSword();
            Armor arm = Factory.getArmor();
            return new Fighter(sw, arm);
        }
    }

    public static Collection<DaDObject> getDaDObjects() {
        TreeSet<DaDObject> objs = new TreeSet<>();
        for(int i = 0; i < randomGenerator.nextInt(0, 6); i++) {
            if(randomGenerator.nextBoolean()) {
                objs.add(Factory.getMagic());
            }
            else if(randomGenerator.nextBoolean()) {
                objs.add(Factory.getSword());
            }
            else objs.add(Factory.getArmor());
        }
        return objs;
    }

    public static Room getRoom() {
        Figure opponent = Factory.getFigure();
        Collection<DaDObject> objs = Factory.getDaDObjects();
        return new Room(objs, opponent);
    }

    public static List<Room> story() {
        List<Room> rooms = new ArrayList<>();
        for(int i = 0; i < randomGenerator.nextInt(2, 8); i++)
            rooms.add(Factory.getRoom());
        return rooms;
    }

    private static Sword getSword() {
        return new Sword(randomGenerator.nextInt(1, 7));
    }

    private static Armor getArmor() {
        return new Armor(randomGenerator.nextInt(1, 4));
    }
    private static Magic getMagic() {
        return new Magic(
                randomGenerator.nextInt(1, 6),
                randomGenerator.nextInt(1, 10),
                randomGenerator.nextInt(1, 4)
        );
    }
}
