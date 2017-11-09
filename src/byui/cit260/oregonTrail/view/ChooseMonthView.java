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
public class ChooseMonthView extends View{


    public ChooseMonthView(){
        super("\n"
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
                + "\n================================================="
                ,"\nPlease enter your choice: ");
    }
    
    @Override
    public boolean doAction(String menu) {
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
        monthMarch.display();
    }

    private void monthApril() {
        MonthAprilView monthApril= new MonthAprilView();
        monthApril.display();
    }

    private void monthMay() {
       MonthMayView monthMay = new MonthMayView();
       monthMay.display();
    }

    private void monthJune() {
       MonthJuneView monthJune = new MonthJuneView();
       monthJune.display();
    }

    private void monthJuly() {
         MonthJulyView monthJuly = new MonthJulyView();
         monthJuly.display();
    }

    private void askAdvice() {
        AskForAdviceView askForAdvice = new AskForAdviceView();
        askForAdvice.display();
    }
}