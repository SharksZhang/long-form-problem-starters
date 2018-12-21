package main;

import model.CoffeeMaker;


public class Main {

    public static void main(String[] args){
        // TODO: complete the implementation of Main

        CoffeeMaker c  = new CoffeeMaker();
        try {
            c.brew(2.5,15);
            c.pourCoffee();
            c.setTimeSinceLastBrew(20);
            c.pourCoffee();
        } catch (Exception e) {
            System.out.println("brew fail");
        }

        try {
            c.brew(1, 15);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            c.brew(2.65, 14);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            c.brew(2.5,15);
            for (int i =0;i <20; i++){
                c.pourCoffee();
            }
            c.pourCoffee();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}