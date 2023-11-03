package it.unive.dais.po1.quadrilateral;

public class Quadrilateral {
    int edge1, edge2, edge3, edge4;

    public int getPerimeter() {
        return this.edge1+this.edge2+this.edge3+this.edge4;
    }
}
