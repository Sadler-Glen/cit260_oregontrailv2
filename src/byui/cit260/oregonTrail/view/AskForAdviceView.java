/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import java.util.Scanner;

/**
 *
 * @author Ignacio
 */
public class AskForAdviceView {
private final String info;
private final String promptMessage;


public AskForAdviceView(){
    this.info = "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                            "
            + "\n You attend a public meeting held for 'folks with           "
            + "\n the California Oregon fever'. You´re told:                 "
            + "\n If you leave too early, there won´t be any                 "
            + "\n grass for your oxen to eat. If you leave too late,         "
            + "\n you may not get to Oregon before winter comes.             "
            + "\n    **************   ***************                           "
            + "\n However, if you leave at just the right time,              "
            + "\n there will be green grass, and the weather                 "
            + "\n would still be cool. It´s your call.                       "
            + "\n                                                            "
            + "\n=================================================";
    
    this.promptMessage = "\n Press 'C' to continue: ";
    
    
}
    void displayAskForAdvice() {
    boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String info = this.info();
            if(info.toUpperCase().equals("C"))// user wants to return to main menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(info);
        } while(!done);    
        
    }

    private String info() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.info);
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

    private boolean doAction(String info) {
        System.out.println("\n*** Invalid Selection. Try Again ***");
    return false;
        
    }
    
}

