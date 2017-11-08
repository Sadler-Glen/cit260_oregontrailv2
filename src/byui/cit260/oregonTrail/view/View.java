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
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    protected String displayPrompt;
    
    public View(){
    }
    
    public View(String message, String prompt){
        this.displayMessage = message;
        this.displayPrompt = prompt;
    }
    
    @Override
    public void display(){
                boolean done = false; // set flag to not done
        do{
            // prompt for and get menu option
            String value = this.getInput();
            if(value.toUpperCase().equals("Q"))// user wants to quit
                return; // exit the game
            if(value.toUpperCase().equals("X"))// user wants to quit
                return; // return to previous
            if(value.toUpperCase().equals("C"))// user wants to quit
                return; // rturn to previous            
            // do the requested action and display the next view
            done = this.doAction(value);
            
        } while (!done);
    }
    
    @Override
    public String getInput(){
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.displayMessage);
            System.out.print(this.displayPrompt);
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
}
