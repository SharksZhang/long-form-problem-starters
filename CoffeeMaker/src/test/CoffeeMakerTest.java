package test;

import model.CoffeeMaker;
import model.exceptions.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoffeeMakerTest {
    private CoffeeMaker testCM;

    @Before
    public void setUp(){
        // TODO: instantiate your test objects here
        testCM = new CoffeeMaker();
    }

    @Test
    public void testTemplate(){
        // TODO: write some more tests
        // This is a template for unit tests
    }

    @Test
    public void testConstructor(){
        assertEquals(testCM.getCupsRemaining(), testCM.getTimeSinceLastBrew(), 0);
    }

    @Test
    public void testBrewShouldPass(){
        try {
            successfulBrew();
            assertEquals(testCM.getTimeSinceLastBrew(), 0);
            assertEquals(testCM.getCupsRemaining(), 20);
            testCM.brew(2.4, 14.9);
            testCM.brew(2.6, 14.8);

        } catch (Exception e) {
            fail();
        }
    }

    @Test(expected = NotEnoughBeansException.class)
    public void testBrewFailNotEnoughBeans() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        testCM.brew(2.3, 15);
    }

    @Test(expected = TooManyBeansException.class)
    public void testBrewFailTooManyBeans() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        testCM.brew(3, 15);
    }

    @Test(expected = WaterException.class)
    public void testBrewNotEnoughWater() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        testCM.brew(2.5, 14.75);
    }

    @Test(expected = WaterException.class)
    public void TestBrewFailBothWrongWaterFirst() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        testCM.brew(2.3, 1);
    }

    @Test
    public void TestPourCoffeePass() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        successfulBrew();
        try {
            testCM.pourCoffee();
            testCM.pourCoffee();
            testCM.setTimeSinceLastBrew(20);
            testCM.pourCoffee();
            assertEquals(testCM.getCupsRemaining(), 17);
        } catch (Exception e) {
            fail();
        }
    }

    @Test(expected = StaleCofeeException.class)
    public void TestPourCoffeeFailStaleCoffee() throws NotEnoughBeansException, TooManyBeansException, WaterException, NoCupsRemainingException, StaleCofeeException {
        successfulBrew();
        testCM.setTimeSinceLastBrew(60);
        testCM.pourCoffee();

    }

    @Test(expected = NoCupsRemainingException.class)
    public void TestPourCoffeeFailNoCupsRemaining() throws NotEnoughBeansException, TooManyBeansException, WaterException, NoCupsRemainingException, StaleCofeeException {
        successfulBrew();
        for(int i = 0; i< 20; i ++){
            testCM.pourCoffee();
        }
        testCM.pourCoffee();

    }

    private void successfulBrew() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        testCM.brew(2.5, 15);
    }


}


