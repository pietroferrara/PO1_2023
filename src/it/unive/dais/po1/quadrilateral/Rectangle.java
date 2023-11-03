package it.unive.dais.po1.quadrilateral;

public class Rectangle extends Quadrilateral {
    public Rectangle(int length1, int length2) {
        this.edge1 = length1;
        this.edge2 = length1;
        this.edge3 = length2;
        this.edge4 = length2;
    }
}
