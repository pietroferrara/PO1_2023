package it.unive.dais.po1.dandd;


public class UnrestorableException extends RuntimeException {
    public UnrestorableException(String message) {
        super(message);
    }

    public UnrestorableException(String message, Throwable cause) {
        super(message, cause);
    }
}
