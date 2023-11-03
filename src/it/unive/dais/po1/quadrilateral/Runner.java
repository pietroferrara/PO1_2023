package it.unive.dais.po1.quadrilateral;

public class Runner {
    public static void main(String[] args) {
        System.out.println("The perimeter of a square with edge of length 5 is:"+
                new Square(5).getPerimeter());
        System.out.println("The perimeter of a rectangle  with edges of length 4 and 5 is:"+
                new Rectangle(4, 5).getPerimeter());
    }

}
