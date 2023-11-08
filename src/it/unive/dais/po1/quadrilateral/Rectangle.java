package it.unive.dais.po1.quadrilateral;

public class Rectangle extends Quadrilateral {
    public Rectangle(int length1, int length2) {
        super(length1, length1, length2, length2);
    }

    @Override
    public int getArea() {
        return this.edge1*this.edge3;
    }
}
