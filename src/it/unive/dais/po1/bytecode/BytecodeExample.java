package it.unive.dais.po1.bytecode;

public class BytecodeExample {

    public static void main(String[] args) {
        //System.out.println(sum(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }

    int field;

    void increment() {
        this.field++;
    }


    int sum2(int i) {
        int result = 0;
        for(int j = 0; j < i; j++) {
            result = sum(result, j);
        }
        return result;
    }

    int sum(int a, int b) {
        int result = a+b;
        return result;
    }
}
