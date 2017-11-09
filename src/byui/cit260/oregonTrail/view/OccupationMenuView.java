/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.model.Player;
import java.util.Scanner;

/**
 *
 * @author sadss
 */
public class OccupationMenuView extends View{

    public OccupationMenuView() {
        
            super( "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n  Many kinds of people made the trip to Oregon   "
            + "\n                                                 "
            + "\n  You may:                                       "
            + "\n                                                 "
            + "\n  1 - Be a Banker from Boston                    "
            + "\n  2 - Be a Carpenter from Ohio                   "
            + "\n  3 - Be a Farmer from Illinois                  "
            + "\n  4 - Find out the differences between these     "
            + "\n      choices                                    "
            + "\n  X - Exit                                       "
            + "\n                                                 "
            + "\n================================================="
            ,"\nPlease enter your choice: ");        
    }


    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper cas
        
        switch (choice) {
            case "1": //choose to be a banker
                this.banker();
                break;
            case "2": //choose to be a carpenter
                this.carpenter();
                break;
            case "3": //choose to be a farmer
                this.farmer();
                break;
            case "4": //display information abouteach occupation
                this.occupationHelpInfo();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }    

    private void banker() {
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void carpenter() {
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();       
    }

    private void farmer() {
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void occupationHelpInfo() {
        OccupationHelpInfoView helpInfo = new OccupationHelpInfoView();
        helpInfo.display();
    }    
}
