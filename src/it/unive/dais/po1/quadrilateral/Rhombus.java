package it.unive.dais.po1.quadrilateral;

public class Rhombus extends Quadrilateral {

    private int diagonal1, diagonal2;

    public Rhombus(int edge, int diagonal1, int diagonal2) {
        super(edge, edge, edge, edge);
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    @Override
    public int getArea() {
        return this.diagonal1*this.diagonal2/2;
    }
}
