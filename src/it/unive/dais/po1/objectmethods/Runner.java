package it.unive.dais.po1.objectmethods;

public class Runner {

    public static void foo() {
        String a = "pippo";
        String b = "pippo";
        a = a + "pippo2";
        a = a.concat("pippo2");
    }

    public static void main(String[] args) {
        foo();
        A obj1 = new A();
        A obj2 = new A();
        System.out.println(obj1==obj2);
        System.out.println(obj1.equals(obj2));
    }
}
