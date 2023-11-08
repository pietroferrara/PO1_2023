package it.unive.dais.po1.quadrilateral;

import java.util.Random;

public class RunnerQuadrilateral {
    public static void main(String[] args) {
        Quadrilateral q;
        if(new Random().nextDouble() <= 1.0/3.0)
            q = new Square(3);
        else if(new Random().nextDouble()<=1.0/2.0)
            q = new Rhombus(4, 2, 6);
        else q=new Rectangle(5,6);

        int perimeter = q.getPerimeter();
        int area = q.getArea();
        System.out.println("Perimeter:"+perimeter+"\nArea:"+area);
    }

}
