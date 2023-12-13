package it.unive.dais.po1.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionalRunner {
    public static void main(String[] args) {
        try {
            String name = args.length > 0 ? args[0] : null;
            System.out.println(name.toString()+"Hello world");
        }
        /*catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ops, this should not happen");
        }*/
        finally {
            System.out.println("Let's go out from here");
        }
    }

    public String foo() throws IOException {
        try (FileReader fr = new FileReader("pippo");
             BufferedReader br = new BufferedReader(fr)) {
            return br.readLine();
        }
    }
}
