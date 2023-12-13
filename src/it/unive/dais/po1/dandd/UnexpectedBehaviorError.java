package it.unive.dais.po1.dandd;

public class UnexpectedBehaviorError extends Error {
    public UnexpectedBehaviorError(String message) {
        super(message);
    }
    public UnexpectedBehaviorError(String message, Throwable cause) {
        super(message, cause);
    }

}
