/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import java.util.Scanner;

/**
 *
 * @author Glen Sadler
 */
public abstract class View implements ViewInterface {

    protected String displayMessage;
    protected String displayPrompt;

    public View() {
    }

    //using principle of overloading
    public View(String message, String prompt) {
        this.displayMessage = message;
        this.displayPrompt = prompt;

    }

    @Override
    public void display() {

        boolean done = false; // set flag to not done
        do {
            // prompt for and get menu option
            String value = this.getInput();

            if (value.toUpperCase().equals("C"))// user wants to exit view                
            // do the requested action and display the next view
            {
                return; // exit view
            }
            done = this.doAction(value);
        } while (!done);
    }

    @Override
    public String getInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false; // initialize to not valid
        String value = null;

        // while a valid name has not been retrieved
        while (!valid) {

            // prompt for input
            System.out.println(" " + this.displayMessage);
            System.out.print(" " + this.displayPrompt);

            // get the value entered from keyboard
            value = keyboard.nextLine();
            // trim off leading and trailing blanks
            value = value.trim();

            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            break; // end the loop
        }

        return value; // return the value entered
    }
}
