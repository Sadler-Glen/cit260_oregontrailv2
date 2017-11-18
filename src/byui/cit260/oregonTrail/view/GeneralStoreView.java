/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.model.InventoryItem;
import java.util.Scanner;

/**
 *
 * @author sadss
 */
public class GeneralStoreView extends View  {
    
    private String storePage1;
    private String storePage2;
    private String promptMessage;
    private String promptMessage1;
    private String promptMessage2;
    
    public GeneralStoreView(){
        
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        this.storePage1 = "\n"
            + "\n=============Glen´s General Store================"
            + "\n                                                 "
            + "\n  Hello, I´m Glen. So you´re going to Oregon!    "
            + "\n  I can fix you up with whatever you need:       "
            + "\n                                                 "
            + "\n  - A team of oxen to pull your wagon            "
            + "\n                                                 "
            + "\n  - Clothing for both summer and winter          "
            + "\n                                                 "
            + "\n  - Plenty of food for your trip                 "
            + "\n                                                 "
            + "\n  - Ammunition for your rifles                   "
            + "\n                                                 "
            + "\n  - Spare parts for your wagon                   "
            + "\n=================================================";
               
        
        this.promptMessage = "\n Please press 'C' to continue: ";
        
        this.storePage2 = "\n"
            + "\n=============Glen´s General Store================"
            + "\n                                                 "
            + "\n            Independence, Missouri               "
            + "\n                                                 "
            + "\n      Item\t\tQuantity\tCost             "
            + "\n  1 - Oxen\t\t"+GameControl.getOxen()+"\t\t$"+GameControl.getOxenCost()
            + "\n                                                 "
            + "\n  2 - Food\t\t"+GameControl.getFood()+"\t\t$"+GameControl.getFoodCost()
            + "\n                                                 "
            + "\n  3 - Clothing\t\t"+GameControl.getClothing()+"\t\t$"+GameControl.getClothingCost()
            + "\n                                                 "
            + "\n  4 - Ammunition\t"+GameControl.getAmmo()+"\t\t$"+GameControl.getAmmoCost()
            + "\n                                                 "
            + "\n  5 - Wheels\t\t"+GameControl.getWheel()+"\t\t$"+GameControl.getWheelCost()
            + "\n                                                 "
            + "\n  6 - Axles\t\t"+GameControl.getAxle()+"\t\t$"+GameControl.getAxleCost()
            + "\n                                                 "
            + "\n  7 - Tongues\t\t"+GameControl.getTongue()+"\t\t$"+GameControl.getTongueCost()
            + "\n                                                 "
            + "\n  Total Bill:\t\t\t\t$"+GameControl.getTotalBill()
            + "\n                                                 "
            + "\n  Amount you have:\t\t\t$"+GameControl.getFundAmount()
            + "\n=================================================";
        
        this.promptMessage1 = "\n Which item would you like to buy?";
        
        this.promptMessage2 = "\n Press 'C' to leave the store: ";
    }
    
    
    void displayStorePage() {
        boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String displayStorePage1 = this.getStorePage1();
            if(displayStorePage1.toUpperCase().equals("C"))// user wants to return to main menu
                
                break; // exit loop
                            
            // do the requested action and display the next view
            done = this.doAction(displayStorePage1);
        } while(!done);
    
        //boolean done = false; // set flag to not done
        do{
            // continue will exit loop
            String displayStorePage2 = this.getStorePage2();
            if(displayStorePage2.toUpperCase().equals("C"))// user wants to return to main menu
                
                return; // Temp return to previous menu - Awaiting new code!!
                            
            // do the requested action and display the next view
            done = this.doAction(displayStorePage2);
        } while(!done);
    }
    
    
    @Override
    public boolean doAction(String text) {
        
        text = text.toUpperCase();
        
        switch (text){
            
            case "1": //Choose Oxen
                this.oxenChoice();
                break;
                
            case "2": //Choose Food
                this.foodChoice();
                break;
             
            case "3": //Choose Clothing
                this.clothChoice();
                break;
            
            case "4": //Choose Ammunition
                this.ammoChoice();
                break;
             
            case "5": //Choose Spare Parts
                this.wheelsChoice();
                break;
                
            case "6": //Choose Spare Parts
                this.axleChoice();
                break;
                
            case "7": //Choose Spare Parts
                this.tongueChoice();
                break;  
                
            default: //Get error message
                System.out.println("\n*** Invalid Selection. Try Again ***");
                break;
        }
         
    return false;
    
    }

    private String getStorePage1() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.storePage1);
            System.out.print(" " + this.promptMessage);
            
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if(value.length() < 1) { // value is blank
                System.out.println("\n Don´t forget you´ll need oxen to pull your wagon");
                continue;
            }
            break; // end the loop
        }
        
        return value; // return the value entered      
    }

    private String getStorePage2() {
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while(!valid) { // loop while an invalid value is entered
            System.out.println(this.storePage2);
            System.out.print(" " + this.promptMessage1);
            System.out.print(" " + this.promptMessage2);
            
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if(value.length() < 1) { // value is blank
                System.out.println("\n Don´t forget you´ll need oxen to pull your wagon");
                continue;
            }
            break; // end the loopx
            
        }
        
        return value; // return the value entered      
    }

    private void oxenChoice() {
        System.out.println("\n*** oxenChoice() function called ***");
    }

    private void clothChoice() {
         System.out.println("\n*** clothChoice() function called ***");
    }

    private void ammoChoice() {
         System.out.println("\n*** ammoChoice() function called ***");
    }
    
    private void foodChoice() {
         System.out.println("\n*** foodChoice() function called ***");
    }
    private void partsChoice() {
         System.out.println("\n*** partsChoice() function called ***");
    }

    private void wheelsChoice() {
        System.out.println("\n*** wheelsChoice() function called ***");
    }

    private void axleChoice() {
        System.out.println("\n*** axleChoice() function called ***");
    }
    

    private void tongueChoice() {
        System.out.println("\n*** tongueChoice() function called ***");
    }
}
