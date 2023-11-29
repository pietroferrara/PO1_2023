package it.unive.dais.po1.generics;

import java.util.Arrays;

public class List<T> {
    private T[] elements = null;

    protected T get(int index) {
        return elements[index];
    }

    protected int length() {
        return elements.length;
    }

    public static <T1>  T1 getFirst(List<T1> l) {
        return l.get(0);
    }

    public void add(T el) {
        if(elements==null) {
            elements = (T[]) new Object[0];
        }
        elements = Arrays.copyOf(elements, elements.length+1);
        elements[elements.length-1]=el;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
