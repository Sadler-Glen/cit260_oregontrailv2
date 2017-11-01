/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import java.util.Scanner;

/**
 *
 * @author EQUIPO
 */
class MonthJuneView {
    
 private final String text;
    private final String promptMessage;


public MonthJuneView(){
this.text = "\n"
        +"\n===============Oregon Trail Game================="
        +"\n                                                 "
        +"\n    Before leaving your current location,        "
        +"\n    first you should step by Glen´s store        "
        +"\n    and buy supplies for your journey            "
        +"\n    right now you have a certain amount          "
        +"\n    of money.                                    "
        +"\n                      ***                        "
        +"\n                 Use it wisely.                  "
        +"\n                                                 "
        +"\n=================================================";
        
   this.promptMessage = "\n Please press 'C' to continue:  ";     


 }
 

    private String text() {
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.text);
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

    private boolean doAction(String text) {
        
         System.out.println("\n*** Invalid Selection. Try Again ***");
    return false;
    }

    
    void displaymonthJune() {
        boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String text = this.text();
            if(text.toUpperCase().equals("C"))// user wants to return to main menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(text);
        } while(!done);    
    }
}
