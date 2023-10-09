package it.unive.dais.po1.accessmodifiers;

import it.unive.dais.po1.accessmodifiers.a.A;

public class C2 {
    public int pblc;
    int dft;
    private int prvt;

    public void foo(C1 c1, C2 c2, A a) {
        int i = this.pblc;
        i = this.dft;
        i = this.prvt;
        i = c2.prvt;

        i = c1.pblc;
        i = c1.dft;
        //i = c1.prvt;

        i = a.pblc;
        //i = a.dft;
        //i = a.prvt;
    }
}
