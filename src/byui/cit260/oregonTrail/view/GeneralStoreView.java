/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.control.InventoryControl;
import byui.cit260.oregonTrail.exceptions.InventoryControlException;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.ItemType;
import byui.cit260.oregonTrail.model.OccupationType;
import java.text.DecimalFormat;

/**
 *
 * @author sadss
 */
public class GeneralStoreView extends View {

    private final String storePage1;
    private final String promptMessage;
    private final String promptMessage1;
    private final String promptMessage2;

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

        this.promptMessage = "\nPlease press 'C' to continue: ";

        this.promptMessage1 = "\nPlease choose an item to buy...";

        this.promptMessage2 = "OR - Press 'C' to leave the store: ";
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

        do {
            // continue will exit loop

            String displayStorePage2 = this.getStorePage2();
            if (displayStorePage2.toUpperCase().equals("C"))// user wants move to game menu
            {
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.display();
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
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }

        return false;

    }

    private String getStorePage1() {

//        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                this.console.println(this.storePage1);
                this.console.println(this.promptMessage);

                value = keyboard.readLine(); // get next line typed on keyboard

                value = value.trim().toUpperCase(); // trim off leading and trailing blanks

                if (value.length() < 1) { // value is blank
                    ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }
                break; // end the loop
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
        return value; // return the value entered      
    }

    private String getStorePage2() {

        //Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                this.store();
                this.console.println(this.promptMessage1);
                this.console.println(this.promptMessage2);

                value = keyboard.readLine(); // get next line typed on keyboard
                value = value.trim().toUpperCase(); // trim off leading and trailing blanks

                if (value.length() < 1) { // value is blank
                    ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }

                break; // end the loop

            }

        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());

        }
        return value; // return the value entered 
    }

    private void oxenChoice() {

        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int oxenQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
        boolean done = false;
        try {
            do {
                try {
                    InventoryControl.checkInventoryLimits();
                    this.console.println("\nPlease enter the Quantity: ");
                    String quantity = keyboard.readLine();

                    try {
                        // parse and convert number from text to an integer
                        oxenQuantity = Integer.parseInt(quantity);
                        quantity(oxenQuantity);
                        InventoryControl.checkInventoryLimits();
                    } catch (NumberFormatException nf) {
                        ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");
//                        sleep(2500);
                    }
                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());

                }
                done = true;
            } while (!done);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }
        // get the oxenAmount entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + oxenQuantity; // adds orginal to entered quantity

        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + newQuantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    private void clothChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int clothQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
        boolean done = true;
        try {
            do {
                try {
                    InventoryControl.checkInventoryLimits();
                    this.console.println("\nPlease enter the Quantity: ");
                    String quantity = keyboard.readLine();
                    try { // parse and convert number from text to an integer
                        clothQuantity = Integer.parseInt(quantity);
                    } catch (NumberFormatException nf) {
                        ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");//                        sleep(2500);
                    }
                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        // get the clothiing quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + clothQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + newQuantity + " sets of " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    private void ammoChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int ammoQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
        boolean done = true;
        try {
            do {
                try {
                    InventoryControl.checkInventoryLimits();
                    this.console.println("\nPlease enter the Quantity: ");
                    String quantity = keyboard.readLine();
                    try { // parse and convert number from text to an integer
                        ammoQuantity = Integer.parseInt(quantity);
                    } catch (NumberFormatException nf) {
                        ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");//                        sleep(2500);
                    }
                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        // get the ammo quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + ammoQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + newQuantity + " boxes of " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    private void foodChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int foodQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
        boolean done = false;
        try {
            do {
                try {
                    InventoryControl.checkInventoryLimits();
                    this.console.println("\nPlease enter the Quantity: ");
                    String quantity = keyboard.readLine();
                    try { // parse and convert number from text to an integer
                        foodQuantity = Integer.parseInt(quantity);
                    } catch (NumberFormatException nf) {
                        ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");//                        sleep(2500);
                    }
                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }
        // get the food quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + foodQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + newQuantity + "lbs of " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    private void wheelsChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int wheelQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
        boolean done = true;
        try {
            do {
                try {
                    InventoryControl.checkInventoryLimits();
                    this.console.println("\nPlease enter the Quantity: ");
                    String quantity = keyboard.readLine();
                    try { // parse and convert number from text to an integer
                        wheelQuantity = Integer.parseInt(quantity);
                    } catch (NumberFormatException nf) {
                        ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");//                        sleep(2500);
                    }
                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        // get the wheel quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + wheelQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + newQuantity + " " + item.getDescription() + "/s *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    private void axleChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int axleQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
        boolean done = true;
        try {
            do {
                try {
                    InventoryControl.checkInventoryLimits();
                    this.console.println("\nPlease enter the Quantity: ");
                    String quantity = keyboard.readLine();
                    try { // parse and convert number from text to an integer
                        axleQuantity = Integer.parseInt(quantity);
                    } catch (NumberFormatException nf) {
                        ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");//                        sleep(2500);
                    }
                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        // get the axle quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + axleQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + newQuantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    private void tongueChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int tongueQuantity = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        boolean done = true;
        try {
            do {
                try {
                    InventoryControl.checkInventoryLimits();
                    this.console.println("\nPlease enter the Quantity: ");
                    String quantity = keyboard.readLine();
                    try { // parse and convert number from text to an integer
                        tongueQuantity = Integer.parseInt(quantity);
                    } catch (NumberFormatException nf) {
                        ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");//                        sleep(2500);
                    }
                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }
        // get the tongue quantity entered from keyboard
        // trim off leading and trailing blanks
        InventoryItem item = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()]; // get item from array
        int newQuantity = item.getQuantityInStock() + tongueQuantity; // adds orginal to entered quantity
        item.setQuantityInStock(newQuantity); // sets new amount of inventory item
        oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + newQuantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    private void store() {
        InventoryItem[] inventory = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory();
        OccupationType[] occupation = oregontrailv2.OregonTrailv2.getCurrentGame().getOccupation();

        this.console.println("\n===============Oregon Trail Game================="
                + "\n\n                   Inventory                   "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "Quantity");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        this.console.println(line.toString());
        this.console.println("=================================================");

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
            this.console.println(line.toString());
        }
        double availableFunds = GameControl.getFundAmount(); // set this in the game so that it will be saved and recalled.
        double remainingFunds = availableFunds - sumExCost;
        this.console.println("-------------------------------------------------");
        this.console.println("Cost of Bill                          " + decForm.format(sumExCost));
        this.console.println("Funds in hand                         " + decForm.format(availableFunds));
        this.console.println("Funds remaining                       " + decForm.format(remainingFunds));
        this.console.println("=================================================");

    }

    private void stockInHand() {
        InventoryItem[] inventory = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory();
        OccupationType[] occupation = oregontrailv2.OregonTrailv2.getCurrentGame().getOccupation();

        this.console.println("\n===============Oregon Trail Game================="
                + "\n\n                   Inventory                   "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(38, "Quantity");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        int num = 0;

        for (InventoryItem inventoryItem : inventory) {
            num += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, num + " - " + inventoryItem.getDescription());
            line.insert(38, inventoryItem.getQuantityInStock());

            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
            this.console.println("=================================================");
        }
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public void quantity(int oxenQuantity) {
        InventoryControl checkIt = new InventoryControl();
        checkIt.check(checkIt);
    }
}
