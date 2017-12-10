/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.Occupation;
import byui.cit260.oregonTrail.model.Player;
import java.io.IOException;

/**
 *
 * @author sadss
 */
public class OccupationMenuView extends View { //

    public OccupationMenuView() {

        super("\n"
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
                + "\n=================================================",
                "\nPlease enter your choice: ");
    }

    @Override
    public void display() {

        boolean done = false; // set flag to not done
        do {
            // prompt for and get menu option
            String value = this.getInput();
//            if(value.toUpperCase().equals("Q"))// user wants to quit
//                return; // exit game
            if (value.toUpperCase().equals("X"))// user wants to exit view                
            // do the requested action and display the next view
            {
                return; // exit view
            }//            if(value.toUpperCase().equals("C"))// user wants to exit view                
//            // do the requested action and display the next view
//                return; // exit view
            done = this.doAction(value);

        } while (!done);
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); // convert choice to upper cas
        try {
            switch (choice) {
                case "1":
                    //choose to be a banker
                    this.banker();
                    break;
                case "2":
                    //choose to be a carpenter
                    this.carpenter();
                    break;
                case "3":
                    //choose to be a farmer
                    this.farmer();
                    break;
                case "4": //display information abouteach occupation
                    this.occupationHelpInfo();
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                    OccupationMenuView occupation = new OccupationMenuView();
                    occupation.display();
                    break;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");

        }
        return false;
    }

    private void banker() throws Exception {
        GameControl.setFundAmount(1600);
        GameControl.setOccupation("Banker");
        this.console.println();
        this.console.println("Funds: "+ GameControl.getFundAmount()+ " Occupation: " + GameControl.getOccupation());
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void carpenter() throws Exception {
        GameControl.setFundAmount(800);
        GameControl.setOccupation("Carpenter");
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void farmer() throws Exception {
        GameControl.setFundAmount(400);
        GameControl.setOccupation("Farmer");
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void occupationHelpInfo() {
        OccupationHelpInfoView helpInfo = new OccupationHelpInfoView();
        helpInfo.display();
    }
}
