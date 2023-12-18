package it.unive.dais.po1.reflection;

import it.unive.dais.po1.dandd.objects.offensive.magic.Magic;

import java.lang.reflect.*;

public class RunnerReflection {

    public static void main(String[] args ) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Magic m = new Magic(3, 5, 10);
        Class cls1 = Magic.class;
        Class cls = m.getClass();

        for (Constructor c : cls.getDeclaredConstructors())
            System.out.println("Construttore con "+c.getParameterCount()+" parametri");
        for(Method mt : cls.getDeclaredMethods()) {
            System.out.println("Metodo "+mt.getName());
        }
        for(Field fd : cls.getDeclaredFields())
            System.out.println("Campo "+fd.getName());

        Field f = cls.getDeclaredField("recovery");
        f.setAccessible(true);
        f.set(m, 0);
        System.out.println("Is private: "+ Modifier.isPrivate(f.getModifiers()));
        System.out.println("Type: "+f.getType());

        Method m1 = cls.getDeclaredMethod("getInfoDefense");
        Object result = m1.invoke(m);
        System.out.println("Risultato: "+result.toString());

        Method m2 = cls.getDeclaredMethod("restoreMagic");
        m2.setAccessible(true);
        result = m2.invoke(m);

        Constructor c = cls.getConstructor(int.class, int.class, int.class);
        Object o = c.newInstance(1, 2, 3);
        if(o instanceof Magic)
            System.out.println("The defense of my magic is "+((Magic) o).getInfoDefense());

    }



}
