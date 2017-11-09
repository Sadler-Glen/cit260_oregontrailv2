/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import java.util.Scanner;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author Glen Sadler
 */
public class MainMenuView extends View{

    
    public MainMenuView(){

        super( "\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n                   Main Menu                     "
                + "\n                                                 "
                + "\n  1 - Travel the trail                           "
                + "\n  2 - Get and save an existing Game              "
                + "\n  3 - Information about the trail                "
                + "\n  4 - Save Game                                  "
                + "\n  Q - Quit                                       "
                + "\n                                                 "
                + "\n================================================="
        ,"\nPlease enter your choice: ");

    }
    
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert choice to upper cas
        
        switch (value) {
            case "1": //create and start a new game
                this.startNewGame();
                break;
            case "2": //get and start an existing game
                this.startExistingGame();
                break;
            case "3": //display information about the trail
                this.displayHelpInfo();
                break;
            case "4": //save the current game
                this.saveGame();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void startNewGame() {
        // create a new game
        GameControl.createNewGame(OregonTrailv2.getPlayer());
        
        // display the game menu
        //GameMenuView gameMenu = new GameMenuView();
        //gameMenu.displayMenu();
        
        //display choose month menu
        //ChooseMonthView chooseMonth = new ChooseMonthView();
        //chooseMonth.displayChooseMonth();
        
        OccupationMenuView occupation = new OccupationMenuView();
        occupation.display();
    }

    private void startExistingGame() {
        System.out.println("\n*** startExistingGame function called ***");
    }

    private void displayHelpInfo() {
        // display the help menu
        HelpInfoView helpInfo = new HelpInfoView();
        helpInfo.display();
    }

    private void saveGame() {
        System.out.println("\n*** saveGame function called ***");
    }
}
