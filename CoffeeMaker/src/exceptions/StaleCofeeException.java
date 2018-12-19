package exceptions;

public class StaleCofeeException extends Exception{
    public StaleCofeeException(int time ){
        super(time +"min since last brew,it is now stale");
    }
}
