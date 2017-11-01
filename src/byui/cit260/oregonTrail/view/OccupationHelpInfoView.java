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
public class OccupationHelpInfoView {

    private String helpInfo;
    private String promptMessage;
    
    public OccupationHelpInfoView() {
        this.helpInfo =  "\n===============Oregon Trail Game================="
                        +"\n                                                 "
                        +"\n             Occupation Information              "
                        +"\n                                                 "
                        +"\n  Travelling to Oregon isn't easy! but if you're "
                        +"\n  a banker, you'll have more money for supplies  "
                        +"\n  and services than a carpenter or a farmer.     "
                        +"\n                                                 " 
                        +"\n  However, the harder you have to try, the more  "
                        +"\n  points you deserve! Therefore, the farmer      "
                        +"\n  earns the greatest number of points and the    "                        
                        +"\n  banker earns the least.                        " 
                        +"\n                                                 "
                        +"\n                                                 "
                        +"\n=================================================";
                                
        this.promptMessage = "Please press 'C' to continue...";       
    }

    public void displayOccupationHelpInfo() {
        boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String displayHelpInfo = this.getHelpInfo();
            if(displayHelpInfo.toUpperCase().equals("C"))// user wants to return to main menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(displayHelpInfo);
        } while(!done);
    }
    
        private String getHelpInfo() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.helpInfo);
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
    
    private boolean doAction(String choice) {        
        System.out.println("\n*** Invalid selection *** Try again");
        return false;
    }
}
