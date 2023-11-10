package it.unive.dais.po1.combinationModifiers;

//private not allowed - no sense to have a class accessible only by itseld
//default/package allowed
//protected not allowed - no sense to have something accessible by all subclasses, this would mean it is accessible everywhere
//static not allowed
public abstract class Example {
    int i;//abstract not allowed - the field's signature already defines its behavior


    //abstract+final not allowed - it would be impossible to implement the method
    //abstract+static not allowed - static components are tied to the class and not inherited
    //static+final allowed but warning - static methods are not inherited, therefore they cannot be overriden
    public static final void foo() { }

    //this is allowed
    static class Example1 {}

}
