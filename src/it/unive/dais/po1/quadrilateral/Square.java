package it.unive.dais.po1.quadrilateral;

public class Square extends Rhombus {
    public Square(int length) {
        super(length, 0, 0);//TODO: tirare fuori il calcolo
    }

    @Override
    public int getArea() {
        return this.edge1*this.edge1;
    }
}
