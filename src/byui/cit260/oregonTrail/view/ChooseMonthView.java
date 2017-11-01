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
public class ChooseMonthView {
    private final String menu;
    private final String promptMessage;


public ChooseMonthView(){
    this.menu = "\n"
            + "\n===============Oregon Trail Game================="
            + "\n  It is 1848. Your jumping off                   "
            + "\n  place for Oregon it´s Independence, Missouri.  "
            + "\n  You must decide which month to leave           "
            + "\n  independence."
            + "\n                                                 "
            + "\n  Choose Your Month                              "
            + "\n                                                 "
            + "\n  1 - March                                      "
            + "\n  2 - April                                      "
            + "\n  3 - May                                        "
            + "\n  4 - June                                       "
            + "\n  5 - July                                       "
            + "\n  6 - Ask For Advice                             "
            + "\n  X - Exit                                       "
            + "\n=================================================";
    
    this.promptMessage = "\nPlease make a choice: ";
    
}



void displayChooseMonth(){
 boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String menu = this.menu();
            if(menu.toUpperCase().equals("X"))// user wants to return previous menu
                
                    break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(menu);
        } while(!done);

}

    private String menu() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.menu);
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

    private boolean doAction(String menu) {
        menu = menu.toUpperCase(); // convert choice to upper cas
        
        switch (menu) {
            case "1": //Select March
                this.monthMarch();
                break;
            case "2": //Select April
                this.monthApril();
                break;
            case "3": //Select Msy
                this.monthMay();
                break;
            case "4": //Select June
                this.monthJune();
                break;
            case "5": //Select July
                this.monthJuly();
                break;
            case "6": //Go to the advice information page
                this.askAdvice();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }
    
    
    
    private void monthMarch(){
        MonthMarchView monthMarch = new MonthMarchView();
        monthMarch.displaymonthMarch();
    }

    private void monthApril() {
        MonthAprilView monthApril= new MonthAprilView();
        monthApril.displaymonthApril();
    }

    private void monthMay() {
       MonthMayView monthMay = new MonthMayView();
       monthMay.displaymonthMay();
    }

    private void monthJune() {
       MonthJuneView monthJune = new MonthJuneView();
       monthJune.displaymonthJune();
    }

    private void monthJuly() {
         MonthJulyView monthJuly = new MonthJulyView();
         monthJuly.displaymonthJuly();
    }

    private void askAdvice() {
        AskForAdviceView askForAdvice = new AskForAdviceView();
        askForAdvice.displayAskForAdvice();
    }
}