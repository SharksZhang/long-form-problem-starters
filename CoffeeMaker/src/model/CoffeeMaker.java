package model;

import model.exceptions.*;
/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {
    private int timeSinceLastBrew;
    private int cupsRemaining;

    public CoffeeMaker(){
        this.timeSinceLastBrew = 0;
        this.cupsRemaining = 0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return this.timeSinceLastBrew;
    }
    public int getCupsRemaining() {
        return this.cupsRemaining;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        // TODO: complete the implementation of this method
        return false;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time)  {
        timeSinceLastBrew = time;
    }

    //REQUIRES: beans between 2.40 and 2.60 cups, water > 14.75 cups
    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    public void brew(double beans, double water) throws TooManyBeansException, NotEnoughBeansException, WaterException{
        if (water <= 14.75){
            throw new WaterException(water);
        }
        if (beans < 2.4){
            throw new NotEnoughBeansException(beans);
        }
        if (beans > 2.6){
            throw new TooManyBeansException(beans);
        }
        timeSinceLastBrew = 0;
        cupsRemaining = 20;
    }

    ///REQUIRES: cups remaining > 0, time since last brew < 60
    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //          throws NoCupsRemainingException if cups remaining <=0
    //          throws StaleCofeeException if time since last brew  >=60
    public void pourCoffee() throws NoCupsRemainingException, StaleCofeeException {
        if (timeSinceLastBrew >= 60){
            throw new StaleCofeeException(timeSinceLastBrew);
        }
        if (cupsRemaining <= 0){
            throw new NoCupsRemainingException();
        }
        cupsRemaining --;
    }


}
