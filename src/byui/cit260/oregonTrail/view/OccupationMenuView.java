/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

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
            + "\n            Choose your occupation?              "
            + "\n                                                 "
            + "\n  B - Banker from Boston                         "
            + "\n  C - Carpenter from Ohio                        "
            + "\n  F - Farmer from Illinois                       "
            + "\n  W - Which one should I choose?                 "
            + "\n  X - Exit                                       "
            + "\n                                                 "
            + "\n=================================================";
    
    this.promptMessage = "\nPlease enter your choice: ";
        
    }

    /**
     * displays the occupation menu view
     */        
    
    public void displayOccupation() {
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
            case "W": //display information abouteach occupation
                this.occupationHelpInfo();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }    

    private void banker() {
        System.out.println("\n*** banker() function called ***");
    }

    private void carpenter() {
        System.out.println("\n*** carpenter() function called ***");        
    }

    private void farmer() {
        System.out.println("\n*** farmer() function called ***");
    }

    private void occupationHelpInfo() {
        OccupationHelpInfoView helpInfo = new OccupationHelpInfoView();
        helpInfo.displayOccupationHelpInfo();
    }    
}
