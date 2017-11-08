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
public class HelpInfoView extends View{
    
    public HelpInfoView() {
        super( "\n===============Oregon Trail Game================="
            +"\n                                                 "
            +"\n           Helpful Trail Information             "
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
            +"\n================================================="
            ,"\nPlease press 'C' to continue...");       
    }

    @Override
    public boolean doAction(String choice) {        
        System.out.println("\n*** Invalid selection *** Try again");
        return false;
    }    
}    
