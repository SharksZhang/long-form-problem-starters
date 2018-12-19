package exceptions;

public class WaterException extends Exception {
    public double getAmount() {
        return amount;
    }

    private double amount ;
    public WaterException(double amount){
        super("Not enough water, water is less than " + amount + "cups");
        this.amount = amount;
    }
}
