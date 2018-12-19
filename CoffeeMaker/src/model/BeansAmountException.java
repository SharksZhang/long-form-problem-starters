package model;

public class BeansAmountException extends Exception {
    private double beans;

    public BeansAmountException(double beans){
        super(beans + "is not the right amount of beans");
    }
    public double getBeans(){return this.beans;}
}
