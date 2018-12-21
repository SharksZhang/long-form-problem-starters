package model.exceptions;

public class NoCupsRemainingException extends Exception {
    public NoCupsRemainingException(){
        super("there are no cups remaining");
    }
}
