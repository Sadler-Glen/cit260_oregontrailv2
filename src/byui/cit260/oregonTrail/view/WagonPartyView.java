/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.model.Actor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author sadss
 */
public class WagonPartyView extends View{

    private final String partyList;
    private final String promptMessage;
    private final String promptMessage1;
//    protected final BufferedReader keyboard = OregonTrailv2.getInFile();
//    protected final PrintWriter console = OregonTrailv2.getOutFile();
    
    public WagonPartyView() {

        this.partyList = "\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n      Enter the names of those in your party     "
                + "\n                                                 "
                + "\n  1 - "
                + "\n  2 - "
                + "\n  3 - "
                + "\n  4 - "
                + "\n  5 - "
                + "\n                                                 "
                + "\n================================================="
                + "Please enter party members";

        this.promptMessage = "\nPlease enter party member ";
        this.promptMessage1 = "\nPlease press 'C' to continue: ";

    }

    public void displayPartyList() throws IOException {
        boolean done = false; // set flag to not done
        do {
            // continue will exit loop
            String displayPartyList = this.getPartyList();
            if (displayPartyList.toUpperCase().equals("X"))// user wants to return to main menu
            {
                break; // exit loop
            }
            // do the requested action and display the next view
            done = this.doAction(displayPartyList);
        } while (!done);

        ChooseMonthView chooseMonth = new ChooseMonthView();
        chooseMonth.display();
    }

    private String getPartyList() throws IOException {
        String actorName = null;
        this.console.println("\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n      Enter the names of those in your party     "
                + "\n                                                 "
                + "\n  1 - " + OregonTrailv2.getPlayer().getName() + " - The "+GameControl.getOccupation()
                + "\n  2 - "
                + "\n  3 - "
                + "\n  4 - "
                + "\n  5 - "
                + "\n                                                 "
                + "\n=================================================");

//        Scanner keyboard = new Scanner(System.in);
        
        for (int i = 1; i < 5; i++) {
            
            this.console.printf("\nPlease enter party member " + (i + 1) + ": ");
            actorName = keyboard.readLine();
            boolean valid = false;
            while(!valid){
                if (actorName.length() < 1) { // value is blank
                    ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    return "";
                    
                }valid = true;
            }
            // get the actorName entered from keyboard
            // trim off leading and trailing blanks
            actorName = actorName.trim();
            //create an instance of Actor
            Actor actor = new Actor();
            actor.setName(actorName);
            GameControl.createActor(actor);
//            if (i == 0) {
//                this.console.println("\n===============Oregon Trail Game================="
//                        + "\n                                                 "
//                        + "\n      Enter the names of those in your party     "
//                        + "\n                                                 "
//                        + "\n  1 - " + OregonTrailv2.getPlayer().getName() + " - The "+GameControl.getOccupation()
//                        + "\n  2 - "
//                        + "\n  3 - "
//                        + "\n  4 - "
//                        + "\n  5 - "
//                        + "\n                                                 "
//                        + "\n=================================================");
            if (i == 1) {
                this.console.println("\n===============Oregon Trail Game================="
                        + "\n                                                 "
                        + "\n      Enter the names of those in your party     "
                        + "\n                                                 "
                        + "\n  1 - " + OregonTrailv2.getPlayer().getName() + " - The "+GameControl.getOccupation()
                        + "\n  2 - " + GameControl.getActors().get(0).getName()
                        + "\n  3 - "
                        + "\n  4 - "
                        + "\n  5 - "
                        + "\n                                                 "
                        + "\n=================================================");
            } else if (i == 2) {
                this.console.println("\n===============Oregon Trail Game================="
                        + "\n                                                 "
                        + "\n      Enter the names of those in your party     "
                        + "\n                                                 "
                        + "\n  1 - " + OregonTrailv2.getPlayer().getName() + " - The "+GameControl.getOccupation()
                        + "\n  2 - " + GameControl.getActors().get(0).getName()
                        + "\n  3 - " + GameControl.getActors().get(1).getName()
                        + "\n  4 - "
                        + "\n  5 - "
                        + "\n                                                 "
                        + "\n=================================================");
            } else if (i == 3) {
                this.console.println("\n===============Oregon Trail Game================="
                        + "\n                                                 "
                        + "\n      Enter the names of those in your party     "
                        + "\n                                                 "
                        + "\n  1 - " + OregonTrailv2.getPlayer().getName() + " - The "+GameControl.getOccupation()
                        + "\n  2 - " + GameControl.getActors().get(0).getName()
                        + "\n  3 - " + GameControl.getActors().get(1).getName()
                        + "\n  4 - " + GameControl.getActors().get(2).getName()
                        + "\n  5 - "
                        + "\n                                                 "
                        + "\n=================================================");
            } else if (i == 4) {
                this.console.println("\n===============Oregon Trail Game================="
                        + "\n                                                 "
                        + "\n      Enter the names of those in your party     "
                        + "\n                                                 "
                        + "\n  1 - " + OregonTrailv2.getPlayer().getName() + " - The "+GameControl.getOccupation()
                        + "\n  2 - " + GameControl.getActors().get(0).getName()
                        + "\n  3 - " + GameControl.getActors().get(1).getName()
                        + "\n  4 - " + GameControl.getActors().get(2).getName()
                        + "\n  5 - " + GameControl.getActors().get(3).getName()
                        + "\n                                                 "
                        + "\n=================================================");
            }
        }

        this.console.printf(this.promptMessage1);
        String prompt = keyboard.readLine();
        return actorName = "X";
    }

    public boolean doAction(String choice) {
        ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        return false;
    }
}
