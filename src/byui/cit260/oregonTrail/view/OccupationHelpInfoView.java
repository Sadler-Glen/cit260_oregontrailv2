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
public class OccupationHelpInfoView extends View {
    
    public OccupationHelpInfoView() {
        super(  "\n===============Oregon Trail Game================="
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
            +"\n================================================="
            ,"\nPlease press 'C' to continue: ");       
    }
  
    @Override
    public boolean doAction(String choice) {        
        System.out.println("\n*** Invalid selection *** Try again");
        return false;
    }
}
