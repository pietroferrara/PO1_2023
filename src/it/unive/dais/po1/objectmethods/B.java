package it.unive.dais.po1.objectmethods;

import it.unive.dais.po1.dandd.figures.Figure;

import java.util.Objects;

public class B {
    A a;
    int i;
    Figure f;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B b = (B) o;
        return i == b.i && Objects.equals(a, b.a) && Objects.equals(f, b.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, i, f);
    }
}
