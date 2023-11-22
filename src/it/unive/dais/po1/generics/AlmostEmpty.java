package it.unive.dais.po1.generics;

public class AlmostEmpty {

    public <T> T identity(T param) {
        return param;
    }

    public void foo() {
        AlmostEmpty obj = new AlmostEmpty();
        AlmostEmpty obj2 = obj.<AlmostEmpty>identity(new AlmostEmpty());
        String obj3 = obj.identity("Hello world");
        //AlmostEmpty obj4 = obj.identity("Hello world");
    }
}
