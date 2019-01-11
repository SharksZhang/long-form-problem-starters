package model;

import java.util.ArrayList;
import java.util.List;

public class  Room extends Choice {

    private List<Choice> choices;
    private int id;

    public Room(int id) {
        super( "Enter Room " + id + ".");
        this.id = id;
        choices = new ArrayList<>();
    }

    //EFFECTS: prints a message representing this possible next choice
    public void printOptionMessage() {
        System.out.println(optionMessage);
    }

    //EFFECTS: prints all possible next choices
    public void printOutcome() {
        System.out.println("You are now in Room " + id + ".\n");
        System.out.println("You have the following options: ");

        for (int i = 0; i< choices.size(); i ++) {
            int j = i +1;
            System.out.print("\tOption " + j + ": ");
            choices.get(i).printOptionMessage();
        }

    }

    public List<Choice> getChoices() {
        return  choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Choice getChoice(int i){
        return choices.get(i - 1);
    }
    public void addChoice(Choice choice){
         choices.add(choice);
    }
}
