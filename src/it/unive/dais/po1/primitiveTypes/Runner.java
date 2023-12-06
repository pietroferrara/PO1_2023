package it.unive.dais.po1.primitiveTypes;

import it.unive.dais.po1.dandd.characters.Figure;

import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        String s = "The value is ";
        int i = 1, i2 = 2;
        String s2=" is the current value";
        String s1 = s+i;

        String s3 = i + i2 + s2;
        String s4 = s + i + i2;


    }

    public void foo3() {

        int i = 1;
        Integer boxed_i = Integer.valueOf(i);
        Integer boxed_i1 = Integer.valueOf(i);
        Float boxed_f = Float.valueOf(3.0F);
        Double boxed_d = Double.valueOf(3.0);


    }

    public void foo2() {

        Integer i1 = 10;
        Double d1 = 10.0;
        Float f1 = 10.0F;
        Object o1 = 10;
        //Figure f = 10;
    }

    public void foo() {
        //List<int> list = new ArrayList<int>();
        int i1 = 12, i2 = 14;
        float f1 = 3;

        long l1 = i1;
        double d1 = f1;

        //f1 = d1;
        i1 = (int) l1;

        byte b1 = 8;

        short s1 = 16;

        s1 = b1;
        //b1 = s1;

        System.out.print((int) Long.MAX_VALUE);

        f1 = i1;
        f1 = l1;

        //i1 = f1;
        //l1 = f1;


        boolean bool1 = true;
        char c1 = 'a';

        //i1 = (int) bool1;
        //bool1 = i1;

        i1 = c1;

        //Object o = i;
    }
}
