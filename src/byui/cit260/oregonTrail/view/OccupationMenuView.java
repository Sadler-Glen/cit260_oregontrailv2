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
            + "\n  B - Be a Banker from Boston                    "
            + "\n  C - Be a Carpenter from Ohio                   "
            + "\n  F - Be a Farmer from Illinois                  "
            + "\n  D - Find out the differences between these     "
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
            case "B": //choose to be a banker
                this.banker();
                break;
            case "C": //choose to be a carpenter
                this.carpenter();
                break;
            case "F": //choose to be a farmer
                this.farmer();
                break;
            case "D": //display information abouteach occupation
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
