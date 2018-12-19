package exceptions;

public class WaterException extends Exception {
    private double amount ;
    public WaterException(double amount){
        super("Not enough water, water is less than " + amount + "cups");
        this.amount = amount;
    }
}
