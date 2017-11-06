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
public class WagonPartyView {
    private String partyList1;
    private String partyList2;
    private String partyList3;
    private String partyList4;
    private String partyList5;
    private String promptMessage;
    private String promptMessage1;

    public WagonPartyView() {

        this.partyList1 = "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n      Enter the names of those in your party     "
            + "\n                                                 "
            + "\n  1 - Glen"
            + "\n  2 - "
            + "\n  3 - "
            + "\n  4 - "
            + "\n  5 - "
            + "\n                                                 "
            + "\n=================================================";
    
    this.promptMessage1 = "\nPlease enter name: ";
    this.promptMessage = "\nPlease press 'C' to continue...";

            this.partyList2 = "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n      Enter the names of those in your party     "
            + "\n                                                 "
            + "\n  1 - Glen"
            + "\n  2 - John"
            + "\n  3 - "
            + "\n  4 - "
            + "\n  5 - "
            + "\n                                                 "
            + "\n=================================================";
            
             this.partyList3 = "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n      Enter the names of those in your party     "
            + "\n                                                 "
            + "\n  1 - Glen"
            + "\n  2 - John"
            + "\n  3 - Felicia"
            + "\n  4 - "
            + "\n  5 - "
            + "\n                                                 "
            + "\n=================================================";  
             
            this.partyList4 = "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n      Enter the names of those in your party     "
            + "\n                                                 "
            + "\n  1 - Glen"
            + "\n  2 - John"
            + "\n  3 - Felicia"
            + "\n  4 - Janet"
            + "\n  5 - "
            + "\n                                                 "
            + "\n=================================================";
            
            this.partyList5 = "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n      Enter the names of those in your party     "
            + "\n                                                 "
            + "\n  1 - Glen"
            + "\n  2 - John"
            + "\n  3 - Felicia"
            + "\n  4 - Janet"
            + "\n  5 - Peter"
            + "\n                                                 "
            + "\n=================================================";
            
            
    
    }
    
        public void displayPartyList() {
        boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String displayPartyList1 = this.getPartyList1();
            if(displayPartyList1.toUpperCase().equals("C"))// user wants to return to main menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(displayPartyList1);
        } while(!done);
    
        //boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String displayPartyList2 = this.getPartyList2();
            if(displayPartyList2.toUpperCase().equals("C"))// user wants to return to main menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(displayPartyList2);
        } while(!done);

        do{
            // continue will exit loop
            String displayPartyList3 = this.getPartyList3();
            if(displayPartyList3.toUpperCase().equals("C"))// user wants to return to main menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(displayPartyList3);
        } while(!done);

        do{
            // continue will exit loop
            String displayPartyList4 = this.getPartyList4();
            if(displayPartyList4.toUpperCase().equals("C"))// user wants to return to main menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(displayPartyList4);
        } while(!done);        

        do{
            // continue will move to ChooseMonthView
            String displayPartyList5 = this.getPartyList5();
            if(displayPartyList5.toUpperCase().equals("C"))// user wants to return to main menu
                
            break; // move to ChooseMonthView
            //display choose month menu
            //ChooseMonthView chooseMonth = new ChooseMonthView();
            //chooseMonth.displayChooseMonth();                
                            
            // do the requested action and display the next view
            done = this.doAction(displayPartyList5);
        } while(!done);
        
            ChooseMonthView chooseMonth = new ChooseMonthView();
            chooseMonth.displayChooseMonth();        
    }

        
    
        private String getPartyList1() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.partyList1);
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
    
    private String getPartyList2() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.partyList2);
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
    
    private String getPartyList3() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.partyList3);
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
    
    private String getPartyList4() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.partyList4);
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
    
    private String getPartyList5() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.partyList5);
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
