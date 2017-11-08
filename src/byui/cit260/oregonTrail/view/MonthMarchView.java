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
public class MonthMarchView extends View {

    public MonthMarchView(){
        super("\n"
        + "\n===============Oregon Trail Game================="
        + "\n                                                 "
        + "\n                  March                          "
        + "\n                                                 "
        + "\n    Before leaving your current location,        "
        + "\n    first you should step by Glen´s store        "
        + "\n    and buy supplies for your journey            "
        + "\n    right now you have a certain amount          "
        + "\n    of money.                                    "
        + "\n                      ***                        "
        + "\n                 Use it wisely.                  "
        + "\n                                                 "
        + "\n================================================="
        ,"Please press 'C' to continue:  ");     


    }
    
    @Override
    public boolean doAction(String text) {
        
         System.out.println("\n*** Invalid Selection. Try Again ***");
    return false;
    }
}