package it.unive.dais.po1.methodInvocations;

public class Examples {

    Examples() {

    }

    Examples(int i) {
        this();
    }

    void foo() {}

    void foo2(int i) {}

    static void foo3() {}

    void invocator(Examples ex1) {
        ex1.foo();
    }
    void invocator2(Examples ex1) {
        ex1.foo2(1);
    }
    void invocator3(Examples ex1) {
        ex1.foo3();
    }

    Examples instantiator() {
        return new Examples(10);
    }

}
