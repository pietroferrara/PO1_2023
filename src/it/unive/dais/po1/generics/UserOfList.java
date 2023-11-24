package it.unive.dais.po1.generics;

import it.unive.dais.po1.dandd.characters.Fighter;
import it.unive.dais.po1.dandd.characters.Figure;
import it.unive.dais.po1.dandd.characters.magicians.Wizard;
import it.unive.dais.po1.dandd.protection.Armor;
import it.unive.dais.po1.dandd.weapon.fighter.Sword;
import it.unive.dais.po1.dandd.weapon.magic.Magic;

public class UserOfList {

    public static void foo() {
        List<String> l = new List<String>();
        l.add("Hello world");
        l.add("foo2");
        String s = l.get(1);
    }

    public static void foo2() {
        List<Figure> f = new List<Figure>();
        Sword s = null;
        Armor a = null;
        f.add(new Fighter(s, a));
        Magic m = null;
        f.add(new Wizard(m));
    }

    public static void foo3() {
        List<Fighter> f = new List<Fighter>();
        Sword s = null;
        Armor a = null;
        f.add(new Fighter(s, a));
    }

    public static void foo4() {
        List<Wizard> f = new List<Wizard>();
        Magic m = null;
        f.add(new Wizard(m));
    }

    public static void foo5() {
        List<Wizard> f = new List<Wizard>();
        Magic m = null;
        f.add(new Wizard(m));
        /*List<Figure> f2 = f;
        Sword s = null;
        Armor a = null;
        f2.add(new Fighter(s, a));*/
        Wizard w = f.get(1);
    }

    public static void foo6() {
        Wizard[] f = new Wizard[2];
        Magic m = null;
        f[0]=new Wizard(m);
        Figure[] f2 = f;
        Sword s = null;
        Armor a = null;
        f2[1] = new Fighter(s, a);
        Wizard w = f[1];
    }
    public static void foo7() {
        List<Wizard> f = new List<>();
        Magic m = null;
        var w  = new Wizard(m);
    }
    public static void foo8() {
        ListFigure<Wizard> f = new ListFigure<>();
        Magic m = null;
        var w  = new Wizard(m);
        f.add(w);
        w = f.get(0);
        f.add(new Wizard(null));

        Wizard winner = f.fight();
    }

    public static Figure foo9() {
        ListFigure<Figure> f = new ListFigure<>();
        Sword s = null;
        Armor a = null;
        f.add(new Fighter(s, a));
        Magic m = null;
        f.add(new Wizard(m));
        return f.fight();
    }

    public static void foo2() {
        List<Wizard> f = new List<Wizard>();
        Magic m = null;
        f.add(new Wizard(m));

        //List<Figure> listFigure = f;
        List<? extends Figure> listBoh = f;
        Figure s1 = listBoh.get(0);
        //This does not work since the question mark might be (and indeed is) a Wizard!
        //listBoh.add(new Fighter(null, null));

    }


    public static void main(String [] args) {
        foo6();
    }
}
