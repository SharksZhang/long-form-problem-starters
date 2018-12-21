package model.exceptions;

public class StaleCofeeException extends Exception{
    int time;

    public int getTime() {
        return time;
    }

    public StaleCofeeException(int time ){
        super(time +"min since last brew,it is now stale");
    }
}
