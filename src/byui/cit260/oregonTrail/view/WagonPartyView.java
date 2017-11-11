/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.model.Actor;
import java.util.Scanner;

/**
 *
 * @author sadss
 */
public class WagonPartyView {
    private String partyList;
    private String promptMessage;
    private String promptMessage1;

    public WagonPartyView () {
        
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
        + "\n=================================================";
    
        this.promptMessage = "\nPlease enter party member ";
        this.promptMessage1 = "\nPlease press 'C' to continue: ";

    }
    
    public void displayPartyList() {
    boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String displayPartyList = this.getPartyList();
            if(displayPartyList.toUpperCase().equals("X"))// user wants to return to main menu

                    break; // exit loop

            // do the requested action and display the next view
            done = this.doAction(displayPartyList);
        } while(!done);

        ChooseMonthView chooseMonth = new ChooseMonthView();
        chooseMonth.display();        
    }
   
    private String getPartyList() {
        String value = "";
        System.out.print("\033[H\033[2J");
            System.out.println("\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n      Enter the names of those in your party     "
            + "\n                                                 "
            + "\n  1 - "
            + "\n  2 - " 
            + "\n  3 - "
            + "\n  4 - "
            + "\n  5 - "
            + "\n                                                 "
            + "\n=================================================");
            
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0;  i < 5; i++){
            System.out.print("\nPlease enter party member " + (i + 1) + ": ");
            String actorName = keyboard.nextLine();
            // get the actorName entered from keyboard
            // trim off leading and trailing blanks
            actorName = actorName.trim(); 
            //create an instance of Actor
            Actor actor = new Actor();
            actor.setName(actorName);            
            GameControl.createActor(actor);
            if(i == 0){
                System.out.println("\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n      Enter the names of those in your party     "
                + "\n                                                 "
                + "\n  1 - " + GameControl.getActors().get(0).getName()
                + "\n  2 - " 
                + "\n  3 - "
                + "\n  4 - "
                + "\n  5 - "
                + "\n                                                 "
                + "\n=================================================");                 
            }
            else if(i == 1){
                System.out.println("\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n      Enter the names of those in your party     "
                + "\n                                                 "
                + "\n  1 - " + GameControl.getActors().get(0).getName()
                + "\n  2 - " + GameControl.getActors().get(1).getName()
                + "\n  3 - "
                + "\n  4 - "
                + "\n  5 - "
                + "\n                                                 "
                + "\n=================================================");                 
            }
            else if(i == 2){
                System.out.println("\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n      Enter the names of those in your party     "
                + "\n                                                 "
                + "\n  1 - " + GameControl.getActors().get(0).getName()
                + "\n  2 - " + GameControl.getActors().get(1).getName()
                + "\n  3 - " + GameControl.getActors().get(2).getName()
                + "\n  4 - "
                + "\n  5 - "
                + "\n                                                 "
                + "\n=================================================");                 
            }
            else if(i == 3){
                System.out.println("\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n      Enter the names of those in your party     "
                + "\n                                                 "
                + "\n  1 - " + GameControl.getActors().get(0).getName()
                + "\n  2 - " + GameControl.getActors().get(1).getName()
                + "\n  3 - " + GameControl.getActors().get(2).getName()
                + "\n  4 - " + GameControl.getActors().get(3).getName()
                + "\n  5 - "
                + "\n                                                 "
                + "\n=================================================");                 
            }
            else if(i == 4){
                System.out.println("\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n      Enter the names of those in your party     "
                + "\n                                                 "
                + "\n  1 - " + GameControl.getActors().get(0).getName()
                + "\n  2 - " + GameControl.getActors().get(1).getName()
                + "\n  3 - " + GameControl.getActors().get(2).getName()
                + "\n  4 - " + GameControl.getActors().get(3).getName()
                + "\n  5 - " + GameControl.getActors().get(4).getName()
                + "\n                                                 "
                + "\n=================================================");                 
            }         
        }   
            
        System.out.print(this.promptMessage1);
        String prompt = keyboard.nextLine();
        return value = "X";
    }

    private boolean doAction(String choice) {        
        System.out.println("\n*** Invalid selection *** Try again");
        return false;
    }
}
