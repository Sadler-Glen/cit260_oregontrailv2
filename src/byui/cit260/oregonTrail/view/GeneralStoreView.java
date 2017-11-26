/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.FoodControl;
import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.control.InventoryControl;
import byui.cit260.oregonTrail.exceptions.InventoryControlException;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.ItemType;
import byui.cit260.oregonTrail.model.OccupationType;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author sadss
 */
public class GeneralStoreView extends View {

    private String storePage1;
    private String storePage2;
    private String promptMessage;
    private String promptMessage1;
    private String promptMessage2;

    public GeneralStoreView() {

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

//        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        this.storePage2 = "\n"
//                + "\n=============Glen´s General Store================"
//                + "\n                                                 "
//                + "\n            Independence, Missouri               "
//                + "\n                                                 "
//                + "\n      Item\t\tQty\tCost\tExt-Cost                     "
//                + "\n  1 - " + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getDescription()
//                + "\t\t" + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock()
//                + "\t" + decForm.format(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getCost())
//                + "\t" + decForm.format((oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock())
//                *(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getCost()))
//                
//                + "\n  2 - " + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getDescription()
//                + "\t\t" + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock()
//                + "\t" + decForm.format(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getCost())
//                + "\t" + decForm.format((oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock())
//                *(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getCost()))
//                
//                
//                + "\n  3 - " + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getDescription()
//                + "\t\t" + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock()
//                + "\t" + decForm.format(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getCost())
//                + "\t" + decForm.format((oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock())
//                *(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getCost()))
//                
//                
//                + "\n  4 - " + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getDescription()
//                + "\t" + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock()
//                + "\t" + decForm.format(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getCost())
//                + "\t" + decForm.format((oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock())
//                *(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getCost()))
//                
//                
//                + "\n  5 - " + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getDescription()
//                + "\t\t" + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock()
//                + "\t" + decForm.format(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getCost())
//                + "\t" + decForm.format((oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock())
//                *(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getCost()))
//                
//                
//                + "\n  6 - " + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getDescription()
//                + "\t\t" + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock()
//                + "\t" + decForm.format(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getCost())
//                + "\t" + decForm.format((oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock())
//                *(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getCost()))
//                
//                
//                + "\n  7 - " + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getDescription()
//                + "\t\t" + oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock()
//                + "\t" + decForm.format(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getCost())
//                + "\t" + decForm.format((oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock())
//                *(oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getCost()))
//                
//                
//                + "\n  Total Bill:\t\t\t\t$" + (oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getCost()+ 
//                oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getCost()+
//                oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getCost()+
//                oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getCost()+
//                oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getCost()+
//                oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getCost()+
//                oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getCost())
//                + "\n  Amount you have:\t\t\t$" + GameControl.getFundAmount()
//                + "\n=================================================";
//
        this.promptMessage1 = "\n Which item would you like to buy?";

        this.promptMessage2 = "\n Press 'C' to leave the store: ";
    }

    void displayStorePage() {
        boolean done = false; // set flag to not done
        do {
            // continue will exit loop
            String displayStorePage1 = this.getStorePage1();
            if (displayStorePage1.toUpperCase().equals("C"))// user wants to return to main menu
            {
                break; // exit loop
            }
            // do the requested action and display the next view
            done = this.doAction(displayStorePage1);
        } while (!done);

//        this.storeTest();
        //boolean done = false; // set flag to not done
        do {
            // continue will exit loop

            String displayStorePage2 = this.getStorePage2();
            if (displayStorePage2.toUpperCase().equals("C"))// user wants to return to main menu
            {
                return; // Temp return to previous menu - Awaiting new code!!
            }
            // do the requested action and display the next view
            done = this.doAction(displayStorePage2);
        } while (!done);

    }

    @Override
    public boolean doAction(String text) {

        text = text.toUpperCase();

        switch (text) {

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

        while (!valid) { // loop while an invalid value is entered
            System.out.println(this.storePage1);
            System.out.print(" " + this.promptMessage);

            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim().toUpperCase(); // trim off leading and trailing blanks

            if (value.length() < 1) { // value is blank
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

        while (!valid) { // loop while an invalid value is entered
            this.store();
            System.out.print(" " + this.promptMessage1);
            System.out.print(" " + this.promptMessage2);

            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim().toUpperCase(); // trim off leading and trailing blanks

            if (value.length() < 1) { // value is blank
                System.out.println("\n Don´t forget you´ll need oxen to pull your wagon");
                continue;
            }

            break; // end the loop

        }

        return value; // return the value entered      
    }

    private void oxenChoice() {
        //this.storeTest();
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        Scanner keyboard = new Scanner(System.in);
        int oxenQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
        boolean done = false;
        do {
            try {
                System.out.print("\nPlease enter the Quantity: ");
                String quantity = keyboard.nextLine();
                oxenQuantity = Integer.parseInt(quantity);
                InventoryControl.checkInventoryLimits();
                done = true;
            } catch (InventoryControlException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number.");
                sleep(2500);
            }
        } while (!done);

        // get the oxenAmount entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + oxenQuantity; // adds orginal to entered quantity

        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        System.out.println("\n*** You have purchased " + newQuantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
        sleep(2500);
//        System.out.println(this.storePage2);
//        System.out.print(" " + this.promptMessage1);
//        System.out.print(" " + this.promptMessage2);
//        System.out.println("\n*** Quantity of " + item.getDescription() + " from current game: " + item.getQuantityInStock());
//        this.store();

    }

    private void clothChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        Scanner keyboard = new Scanner(System.in);
        int clothQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
        boolean done = true;
        do {
            try {
                System.out.print("\nPlease enter the Quantity: ");
                String quantity = keyboard.nextLine();
                clothQuantity = Integer.parseInt(quantity);
                InventoryControl.checkInventoryLimits();
                done = true;
            } catch (InventoryControlException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number.");
                sleep(2500);
            }
        } while (!done);
        // get the clothiing quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + clothQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        System.out.println("\n*** You have purchased " + newQuantity + " sets of " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
        sleep(2500);
//        System.out.println(this.storePage2);
//        System.out.print(" " + this.promptMessage1);
////        System.out.print(" " + this.promptMessage2);
//        System.out.println("\n*** Quantity of " + item.getDescription() + " from current game: " + item.getQuantityInStock());
//        this.store();
    }

    private void ammoChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        Scanner keyboard = new Scanner(System.in);
        int ammoQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
        boolean done = true;
        do {
            try {
                System.out.print("\nPlease enter the Quantity: ");
                String quantity = keyboard.nextLine();
                ammoQuantity = Integer.parseInt(quantity);
                InventoryControl.checkInventoryLimits();
                done = true;
            } catch (InventoryControlException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number.");
                sleep(2500);
            }
        } while (!done);
        // get the ammo quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + ammoQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        System.out.println("\n*** You have purchased " + newQuantity + " boxes of " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
        sleep(2500);
//        System.out.println(this.storePage2);
//        System.out.print(" " + this.promptMessage1);
//        System.out.print(" " + this.promptMessage2);
//        System.out.println("\n*** Quantity of " + item.getDescription() + " from current game: " + item.getQuantityInStock());
//        this.store();
    }

    private void foodChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        Scanner keyboard = new Scanner(System.in);
        int foodQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
        boolean done = false;
        do {
            try {
                System.out.print("\nPlease enter the Quantity: ");
                String quantity = keyboard.nextLine();
                foodQuantity = Integer.parseInt(quantity);
                InventoryControl.checkInventoryLimits();
                done = true;
            } catch (InventoryControlException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number.");
                sleep(2500);
            }
        } while (!done);
        // get the food quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + foodQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        System.out.println("\n*** You have purchased " + newQuantity + "lbs of " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
        sleep(2500);
//        System.out.println(this.storePage2);
//        System.out.print(" " + this.promptMessage1);
//        System.out.print(" " + this.promptMessage2);
//        System.out.println("\n*** Quantity of " + item.getDescription() + " from current game: " + item.getQuantityInStock());
//        this.store();
    }

    private void wheelsChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        Scanner keyboard = new Scanner(System.in);
        int wheelQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
        boolean done = true;
        do {
            try {
                System.out.print("\nPlease enter the Quantity: ");
                String quantity = keyboard.nextLine();
                wheelQuantity = Integer.parseInt(quantity);
                InventoryControl.checkInventoryLimits();
                done = true;
            } catch (InventoryControlException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number.");
                sleep(2500);
            }
        } while (!done);
        // get the wheel quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + wheelQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        System.out.println("\n*** You have purchased " + newQuantity + " " + item.getDescription() + "/s *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
        sleep(2500);
//        System.out.println("\n*** Quantity of " + item.getDescription() + " from current game: " + item.getQuantityInStock());
//        this.store();
    }

    private void axleChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        Scanner keyboard = new Scanner(System.in);
        int axleQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
        boolean done = true;
        do {
            try {
                System.out.print("\nPlease enter the Quantity: ");
                String quantity = keyboard.nextLine();
                axleQuantity = Integer.parseInt(quantity);
                InventoryControl.checkInventoryLimits();
                done = true;
            } catch (InventoryControlException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number.");
                sleep(2500);
            }
        } while (!done);
        // get the axle quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + axleQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        System.out.println("\n*** You have purchased " + newQuantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
        sleep(2500);
//        System.out.println(this.storePage2);
//        System.out.print(" " + this.promptMessage1);
//        System.out.print(" " + this.promptMessage2);
//        System.out.println("\n*** Quantity of " + item.getDescription() + " from current game: " + item.getQuantityInStock());
//        this.store();
    }

    private void tongueChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        Scanner keyboard = new Scanner(System.in);
        int tongueQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        boolean done = true;
        do {
            try {
                System.out.print("\nPlease enter the Quantity: ");
                String quantity = keyboard.nextLine();
                tongueQuantity = Integer.parseInt(quantity);
                InventoryControl.checkInventoryLimits();
                done = true;
            } catch (InventoryControlException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number.");
                sleep(2500);
            }
        } while (!done);
        // get the tongue quantity entered from keyboard
        // trim off leading and trailing blanks

        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + tongueQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        System.out.println("\n*** You have purchased " + newQuantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
        sleep(2500);
//        System.out.println(this.storePage2);
//        System.out.print(" " + this.promptMessage1);
//        System.out.print(" " + this.promptMessage2);
//        System.out.println("\n*** Quantity of " + item.getDescription() + " from current game: " + item.getQuantityInStock());
//        this.store();
    }

    private void store() {
        InventoryItem[] inventory = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory();
        OccupationType[] occupation = oregontrailv2.OregonTrailv2.getCurrentGame().getOccupation();

        System.out.println("\n===============Oregon Trail Game================="
                + "\n\n                   Inventory                   "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "Quantity");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        System.out.println(line.toString());
        System.out.println("=================================================");

        // for each inventory item
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        double sumExCost = 0;
        int num = 0;

        for (InventoryItem inventoryItem : inventory) {
            num += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, num + " - " + inventoryItem.getDescription());
            line.insert(15, inventoryItem.getQuantityInStock());
            line.insert(26, decForm.format(inventoryItem.getCost()));
            double extCost = (inventoryItem.getCost() * inventoryItem.getQuantityInStock());
            line.insert(38, decForm.format(extCost));
            sumExCost += extCost;
            // DISPLAY the description, the amount in stock, the cost and the extended cost
            System.out.println(line.toString() + "\n");
        }
        double availableFunds = GameControl.getFundAmount();
        double remainingFunds = availableFunds - sumExCost;
        System.out.print("-------------------------------------------------");
        System.out.print("\nCost of Bill                          " + decForm.format(sumExCost));
        System.out.print("\nFunds in hand                         " + decForm.format(availableFunds));
        System.out.print("\nFunds remaining                       " + decForm.format(remainingFunds));
        System.out.println("\n=================================================");

    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }
}
