package model;

public abstract class Choice {

    protected String optionMessage;

    public Choice(String optionMessage) {
        this.optionMessage = optionMessage;
    }

    //EFFECTS: prints a message representing this possible next choice
    public void printOptionMessage() {
        System.out.println(optionMessage);
    }
    public abstract void printOutcome() ;
}
