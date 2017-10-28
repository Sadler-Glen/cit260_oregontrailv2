/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import java.util.Scanner;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author sadss
 */
public class MainMenuView {
    
    private String menu;
    private String promptMessage;
    
public MainMenuView(){
    
    this.menu = "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n                   Main Menu                     "
            + "\n                                                 "
            + "\n  T - Travel the trail                           "
            + "\n  G - Get and save an existing Game              "
            + "\n  I - Information about the trail                "
            + "\n  S - Save Game                                  "
            + "\n  Q - Quit                                       "
            + "\n                                                 "
            + "\n=================================================";
    
    this.promptMessage = "\nPlease enter your choice: ";
    
}
    /**
     * displays the start program view
     */        
    
    public void displayMainMenuView() {
        boolean done = false; // set flag to not done
        do{
            // prompt for and get menu option
            String menuOption = this.getMenuOption();
            if(menuOption.toUpperCase().equals("Q"))// user wants to quit
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
            case "T": //create and start a new game
                this.startNewGame();
                break;
            case "G": //get and start an existing game
                this.startExistingGame();
                break;
            case "I": //display information about the trail
                this.displayHelpInfo();
                break;
            case "S": //save the current game
                this.saveGame();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void startNewGame() {
        // create a new game
        GameControl.createNewGame(OregonTrailv2.getPlayer());
        
        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void startExistingGame() {
        System.out.println("\n*** startExistingGame function called ***");
    }

    private void displayHelpInfo() {
        // display the help menu
        HelpInfoView helpInfo = new HelpInfoView();
        helpInfo.displayHelpInfo();
    }

    private void saveGame() {
        System.out.println("\n*** saveGame function called ***");
    }
}
