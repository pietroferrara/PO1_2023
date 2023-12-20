package it.unive.dais.po1.dandd;

import it.unive.dais.po1.dandd.figures.Fighter;
import it.unive.dais.po1.dandd.figures.Figure;
import it.unive.dais.po1.dandd.figures.Wizard;
import it.unive.dais.po1.dandd.objects.defensive.Armor;
import it.unive.dais.po1.dandd.objects.offensive.fighter.Sword;
import it.unive.dais.po1.dandd.objects.offensive.magic.Magic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Initializer {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for(Figure f : getAllExistingFigures())
            System.out.println(f);
    }

    private static Iterable<Class> getAllClasses() {
        Collection<Class> result = new HashSet<>();
        result.add(Fighter.class);
        result.add(Wizard.class);
        return result;
    }

    public static Iterable<Figure> getAllExistingFigures() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Collection<Figure> result = new HashSet<>();
        for(Class cls : getAllClasses()) {
            Constructor cons = cls.getConstructors()[0];
            Object[] params = buildParameters(cons);
            result.add((Figure) cons.newInstance(params));
        }
        return result;
    }

    private static Object[] buildParameters(Constructor cons) {
        ArrayList<Object> result = new ArrayList<>();
        for(Parameter p : cons.getParameters()) {
            result.add(getDefaultValue(p.getType()));
        }
        return result.toArray();
    }

    private static Object getDefaultValue(Class<?> type) {
        if(type==int.class)
            return 0;
        if(type== Sword.class)
            return new Sword(10);
        if(type==Armor.class)
            return new Armor(5);
        if(type==Magic.class)
            return new Magic(3,5,2);
        return null;
    }
}
