/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.model.Player;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author Glen Sadler
 */
public class StartProgramView {
    
    protected final BufferedReader keyboard = OregonTrailv2.getInFile();
    protected final PrintWriter console = OregonTrailv2.getOutFile();

    private String promptMessage;

    public StartProgramView() {

        this.promptMessage = "\nPlease enter your name: ";
        // display the banner when view is created
        this.displayBanner();

    }

    private void displayBanner() {

        this.console.println(
                "\n================================================"
                + "\n                                                "
                + "\n    Welcome to the Game of The Oregon Trail     "
                + "\n                                                "
                + "\n           Good Luck on your journey            "
                + "\n                                                "
                + "\n================================================"
        );
    }

    public void display() {
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q")) // user wants to quit
            {
                return; // exit the game
            }            // do the requested action and display the next view
            done = this.doAction(playersName);

        } while (!done);
    }

    public String getPlayersName() {

        //Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = null; // value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                this.console.printf(this.promptMessage);/*(this.promptMessage)*/


                value = keyboard.readLine(); // get next line typed on keyboard
                value = value.trim(); // trim off leading and trailing blanks

                if (value.length() < 1) { // value is blank
                    ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }
                break; // end the loop
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());

        }

        return value; // return the value entered
    }

    private boolean doAction(String playersName) {
        try {
            if (playersName.length() < 2) {
                ErrorView.display(this.getClass().getName(), "Input must be greater than"
                        + " one character");
                return false;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);

        try {
            if (player == null) { // if unsuccessful
                ErrorView.display(this.getClass().getName(), "\nError creating player");
                return false;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());  
        }
        
        // display next view
        this.displayNextView(player);
        return true; // success!
    }
    
    private void displayNextView(Player player) {
        // display a custom welcome message
        this.console.println("\n================================================"
                + "\n                                                "
                + "\n    Welcome to the Oregon Trail " + player.getName()
                + "\n                                                "
                + "\n    We wish you God Speed!                      "
                + "\n                                                "
                + "\n================================================");

        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();

        // Display the main menu view
        mainMenuView.display();
    }

}
