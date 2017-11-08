/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.model.Player;
import java.util.Scanner;
/**
 *
 * @author Glen Sadler
 */
public class StartProgramView {
    
    private String promptMessage;
    
    public StartProgramView(){
        
        this.promptMessage = "\nPlease enter your name: ";
        // display the banner when view is created
        this.displayBanner();
        
    }   

    private void displayBanner() {
        
        System.out.println(
                "\n================================================"
              + "\n                                                "
              + "\n    Welcome to the Game of The Oregon Trail     "
              + "\n                                                "
              + "\n           Good Luck on your journey            "
              + "\n                                                "          
              + "\n================================================"
              );
    }

    public void displayStartProgramView() {
        boolean done = false; // set flag to not done
        do{
            // prompt for and get players name
            String playersName = this.getPlayersName();
            if(playersName.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            // do the requested action and display the next view
            done = this.doAction(playersName);
                    
        } while (!done);
    }

    private String getPlayersName() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.print(" " + this.promptMessage);
            
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

    private boolean doAction(String playersName) {
        if(playersName.length() < 2 ){
            System.out.println("\nInvalid players name: "
                    +"The name must be greater than one charater in length");
        return false;
        }
    // call createPlayer() control function
    Player player = GameControl.createPlayer(playersName);
    
    if(player == null) { // if unsuccessful
        System.out.println("\nError creating player");
        return false;
    }
    
    // display next view
        this.displayNextView(player);
    
    return true; // success!
    }

    private void displayNextView(Player player) {
        // display a custom welcome message
        System.out.println("\n================================================"
                          +"\n                                                "
                          +"\n    Welcome to the Oregon Trail "+ player.getName()
                          +"\n                                                "
                          +"\n    We wish you God Speed!                      "
                          +"\n                                                "
                          +"\n================================================");
        
        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
        
        // Display the main menu view
        mainMenuView.display();
    }    
    
}
