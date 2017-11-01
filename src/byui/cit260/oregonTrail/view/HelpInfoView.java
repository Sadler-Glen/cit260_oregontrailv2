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
public class HelpInfoView {

    private final String helpInfoPart1;
    private final String helpInfoPart2;
    private final String helpInfoPart3;    
    private final String promptMessage;
    
    public HelpInfoView() {
        this.helpInfoPart1 =  "\n===============Oregon Trail Game================="
                        +"\n                                                 "
                        +"\n            Trail Information Part 1             "
                        +"\n                                                 "
                        +"\n  Try taking a journey by Covered wagon across   "
                        +"\n  2000 miles of plains, rivers, and mountains.   "
                        +"\n  Try! On the plans, will you slosh your Oxen    "
                        +"\n  through the mud and water-filled ruts or will  "
                        +"\n  you plod through dust six inches deep?         "
                        +"\n                                                 "                        
                        +"\n  What about supplies? Well if you're low on     " 
                        +"\n  food you can hunt. You might get a buffalo     "
                        +"\n  You might. and there are bears in the          "
                        +"\n  mountains.                                     "
                        +"\n                                                 "
                        +"\n                                                 "
                        +"\n=================================================";
                
   this.helpInfoPart2 =  "\n===============Oregon Trail Game================="
                        +"\n                                                 "
                        +"\n            Trail Information Part 2             "
                        +"\n                                                 "
                        +"\n  At the Dalles, you can try navigating the      "
                        +"\n  Columbia River, but if running the rapids      "
                        +"\n  with a makeshift raft makes you queasy,       "
                        +"\n  better take the Barlow Road.                   "
                        +"\n                                                 "
                        +"\n  If for some reason you don't survive - your    "
                        +"\n  wagon burns, you run out of provisons, or you  "
                        +"\n  die of cholera - don't give up! Try again...   "
                        +"\n  and again...until your name is up with the     "
                        +"\n  others on The Oregon Trail Top Ten.            "
                        +"\n                                                 "
                        +"\n=================================================";
                
   this.helpInfoPart3 =  "\n===============Oregon Trail Game================="
                        +"\n                                                 "
                        +"\n            Trail Information Part 3             "
                        +"\n                                                 "
                        +"\n  You may turn the sound on or off during the    "
                        +"\n  program by pressing Control-S                  "
                        +"\n                                                 "
                        +"\n  You may want to quit in the middle of the      "
                        +"\n  program. If so press the Escape(Esc) key       "
                        +"\n  twice whenever the computer is waiting for a   "
                        +"\n  response.                                      "
                        +"\n                                                 "
                        +"\n  The Software team responsible for the          "
                        +"\n  creation of this product include:              "
                        +"\n                                                 "
                        +"\n  Ignacio Pineda Diaz                            "
                        +"\n  Casper Brouwer                                 "
                        +"\n  Felix Achina                                   "
                        +"\n  Glen Sadler                                    "
                        +"\n                                                 "
                        +"\n=================================================";
                                
        this.promptMessage = "Please press 'C' to continue...";       
    }

    public void displayHelpInfo() {
        boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String displayHelpInfoPart1 = this.getHelpInfoPart1();
            if(displayHelpInfoPart1.toUpperCase().equals("C"))// user wants to return to main menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(displayHelpInfoPart1);
        } while(!done);
    
        //boolean done = false; // set flag to not done
        do{
            // continue will exit
            String displayHelpInfoPart2 = this.getHelpInfoPart2();
            if(displayHelpInfoPart2.toUpperCase().equals("C"))// user wants to return to main menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(displayHelpInfoPart2);
        } while(!done);

        do{
            // continue will return to main menu
            String displayHelpInfoPart3 = this.getHelpInfoPart3();
            if(displayHelpInfoPart3.toUpperCase().equals("C"))// user wants to return to main menu
                
                    return; // return to main menu
                            
            // do the requested action and display the next view
            done = this.doAction(displayHelpInfoPart3);
        } while(!done);
    }
    
        private String getHelpInfoPart1() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.helpInfoPart1);
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
    
    private String getHelpInfoPart2() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.helpInfoPart2);
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
    
    private String getHelpInfoPart3() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.helpInfoPart3);
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
