package it.unive.dais.po1.diamondProblem;

public interface IntWrapper extends Wrapper {

    public int getInt();

    @Override
    default public String getValue() {
        return String.valueOf(this.getInt());
    }
}
