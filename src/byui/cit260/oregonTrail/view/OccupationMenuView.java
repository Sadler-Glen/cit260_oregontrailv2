/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.model.Player;
import java.util.Scanner;

/**
 *
 * @author sadss
 */
public class OccupationMenuView {
    private String menu;
    private String promptMessage;

    public OccupationMenuView() {
        
            this.menu = "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n  Many kinds of people made the trip to Oregon   "
            + "\n                                                 "
            + "\n  You may:                                       "
            + "\n                                                 "
            + "\n  B - Be a Banker from Boston                    "
            + "\n  C - Be a Carpenter from Ohio                   "
            + "\n  F - Be a Farmer from Illinois                  "
            + "\n  D - Find out the differences between these     "
            + "\n      choices                                    "
            + "\n  X - Exit                                       "
            + "\n                                                 "
            + "\n=================================================";
    
    this.promptMessage = "\nPlease enter your choice: ";
        
    }

    /**
     * displays the occupation menu view
     */        
    
    public void displayOccupationMenuView() {
        boolean done = false; // set flag to not done
        do{
            // prompt for and get menu option
            String menuOption = this.getMenuOption();
            if(menuOption.toUpperCase().equals("X"))// user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.menu);
            System.out.print("\n" + this.promptMessage);
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if(value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            break; // end the loop
        }
        
        return value; // return the value entered
    }

    private boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper cas
        
        switch (choice) {
            case "B": //choose to be a banker
                this.banker();
                break;
            case "C": //choose to be a carpenter
                this.carpenter();
                break;
            case "F": //choose to be a farmer
                this.farmer();
                break;
            case "D": //display information abouteach occupation
                this.occupationHelpInfo();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }    

    private void banker() {
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void carpenter() {
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();       
    }

    private void farmer() {
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void occupationHelpInfo() {
        OccupationHelpInfoView helpInfo = new OccupationHelpInfoView();
        helpInfo.displayOccupationHelpInfo();
    }    
}
