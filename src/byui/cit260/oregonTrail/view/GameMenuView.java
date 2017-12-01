/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.control.MapControl;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.Location;
import byui.cit260.oregonTrail.model.OccupationType;
import byui.cit260.oregonTrail.model.Scene;
import java.text.DecimalFormat;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author Glen Sadler
 */
public class GameMenuView extends View {

    public GameMenuView() {
        super("\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n                   Game Menu                     "
                + "\n                                                 "
                + "\n1 - View map                                     "
                + "\n2 - View location                                "
                + "\n3 - View inventory - Stock in hand report        "
                + "\n4 - View inventory - Sorted by description       "
                + "\n5 - View inventory - sorted by quantity in stock "
                + "\n6 - View inventory - sorted by item cost           "
                + "\n7 - Move actors                                  "
                + "\n8 - Display help menu                            "
                + "\nQ - Return to store                              "
                + "\nM - Return to main menu                          "
                + "\n                                                 "
                + "\n=================================================",
                "\nPlease enter your choice: ");
    }

    @Override
    public boolean doAction(String value) {

        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered

        switch (choice) {
            case '1': // Travel to new location
                this.displayMap();
                break;
            case '2': // View description of location
                this.viewLocation(); 
                break;
            case '3': // View list of items in inventory
                this.stockInHand();
                break;
            case '4': // View list of inventory - sorted by description
                this.viewInventoryDescription();
                break;    
            case '5': // View list of inventory
                this.viewInventoryCost();
                break;
            case '6': // View list of items in inventory
                this.viewInventoryInStock();
                break;
            case '7': // Move actors
                this.console.println("\n*** Awaiting code ***");
                break;
            case '8': // display the help menu
                this.displayHelpMenu();
                break;
            case '9':
                return true;
            case 'Q':
                return true;
            case 'M':
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
            default:
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
        return false;
    }
    
    private void displayMap() {
        int lineLength = 0;

        // get the map for the game
        Location[][] locations = GameControl.getMapLocations();
        int noColumns = locations[0].length; // get number columns in row

        this.printTitle(noColumns, "THE OREGON TRAIL");
        this.printColumnHeaders(noColumns);

        for (int i = 0; i < locations.length; i++) {
            Location[] rowLocations = locations[i];
            this.printRowDivider(noColumns);
            this.console.println(); // move down one i
            if (i < 9) {
                this.console.print(" " + (i + 1));
            } else {
                this.console.print(i + 1);
            }

            // for every column in the row
            for (int column = 0; column < noColumns; column++) {
                this.console.print("|"); // print column divider
                Location location = rowLocations[column];
                if (location.isVisited() || location == null) { // if location is visited 
                    Scene scene = location.getScene();
                    this.console.print(scene.getMapSymbol());
                } else {
                    this.console.print(" ?? ");
                }

                Scene scene = location.getScene();
                this.console.print("");//(scene.getMapSymbol());

            }
            this.console.print("|"); // print column divider
        }

        this.printRowDivider(noColumns);
    }

    private void printColumnHeaders(int noOfColumns) {
        for (int i = 1; i < noOfColumns + 1; i++) {
            if (i < 10) {
                this.console.print("   " + i + " ");
            } else {
                this.console.print("  " + i + " ");
            }
        }
    }    

    private void printRowDivider(int noColumns) {
        this.console.println();
        this.console.print("  ");
        for (int i = 0; i < noColumns; i++) { // print row divider
            this.console.print("-----");
        }
        this.console.print("-");
    }

    private void printTitle(int noOfColumns, String title) {

        int titleLength = title.length();
        int lineLength = noOfColumns * 5 + 3;
        int startPosition = (lineLength / 2) - (titleLength / 2);
        this.console.println("\n");
        for (int i = 0; i < startPosition; i++) {
            this.console.print(" ");
        }
        this.console.print(title);
        this.console.println("\n");
    }
    
//    private void viewLocation() {
//        ViewLocationView viewLocationView = new ViewLocationView();
//        viewLocationView.display();
//    }
    private void displayHelpMenu() {
        HelpInfoView helpMenu = new HelpInfoView();
        helpMenu.display();
    }

    private void viewInventory() {
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListDescription();

        this.console.println("\nList of Inventory Items");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(20, "Required");
        line.insert(30, "In Stock");
        this.console.println(line.toString());

        // for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            line = new StringBuilder("                                                          ");
            line.insert(0, inventoryItem.getDescription());
            line.insert(23, inventoryItem.getRequiredAmount());
            line.insert(33, inventoryItem.getQuantityInStock());

            // DISPLAY the description, the required amount and amount in stock
            this.console.println(line.toString());
        }
    }
    private void viewInventoryDescription() {
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListDescription();

        this.console.println("\n===============Oregon Trail Game================="
                + "\n\n   Sorted List of Inventory Items(Description)   "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        double sumExCost = 0;
        for (InventoryItem inventoryItem : inventory) {
            line = new StringBuilder("                                                          ");
            line.insert(0, inventoryItem.getDescription());
            line.insert(15, inventoryItem.getQuantityInStock());
            line.insert(26, decForm.format(inventoryItem.getCost()));
            double extCost = (inventoryItem.getCost() * inventoryItem.getQuantityInStock());
            line.insert(38, decForm.format(extCost));
            sumExCost += extCost;
            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
        }
        double availableFunds = GameControl.getFundAmount();
        double remainingFunds = availableFunds - sumExCost;
        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.print("\nFunds in hand                         " + decForm.format (availableFunds));
        this.console.print("\nFunds remaining                       " + decForm.format(remainingFunds));
        this.console.println("\n=================================================");
    }

    //function calling bubble sort on inventory cost and displaying to user
    // THIS FUNCTION CREATED BY IGNACIO
    private void viewInventoryCost() {
//        GameControl.createNewGame(OregonTrailv2.getPlayer());
//        MapControl.createMap();
//        MapControl.createLocations(5, 5);
//        MapControl.createScenes();
//        MapControl.createQuestions();
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListCost();

        this.console.println("\n===============Oregon Trail Game================="
                + "\n\n    Sorted List of Inventory Items(Item Cost)    "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        double sumExCost = 0;
        for (InventoryItem inventoryItem : inventory) {
            line = new StringBuilder("                                                          ");
            line.insert(0, inventoryItem.getDescription());
            line.insert(15, inventoryItem.getQuantityInStock());
            line.insert(26, decForm.format(inventoryItem.getCost()));
            double extCost = (inventoryItem.getCost() * inventoryItem.getQuantityInStock());
            line.insert(38, decForm.format(extCost));
            sumExCost += extCost;

            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
        }

        double availableFunds = GameControl.getFundAmount();
        double remainingFunds = availableFunds - sumExCost;
        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.print("\nFunds in hand                         " + decForm.format(availableFunds));
        this.console.print("\nFunds remaining                       " + decForm.format(remainingFunds));
        this.console.println("\n=================================================");
    }
    // L10 individual assignment - calls bubble sort in gamecontrol line 298
    // 

    private void viewInventoryInStock() {
//        GameControl.createNewGame(OregonTrailv2.getPlayer());
//        MapControl.createMap();
//        MapControl.createLocations(5, 5);
//        MapControl.createScenes();
//        MapControl.createQuestions();
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListInStock();

        this.console.println("\n===============Oregon Trail Game================="
                + "\n\n  Sorted List of Inventory Items (QTY in Stock)  "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        double sumExCost = 0;
        int itemNo = 0;
        for (InventoryItem inventoryItem : inventory) {
            itemNo += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, inventoryItem.getDescription());
            line.insert(15, inventoryItem.getQuantityInStock());
            line.insert(26, decForm.format(inventoryItem.getCost()));
            double extCost = (inventoryItem.getCost() * inventoryItem.getQuantityInStock());
            line.insert(38, decForm.format(extCost));
            sumExCost += extCost;

            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
        }
        double availableFunds = GameControl.getFundAmount();
        double remainingFunds = availableFunds - sumExCost;
        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.print("\nFunds in hand                         " + decForm.format(availableFunds));
        this.console.print("\nFunds remaining                       " + decForm.format(remainingFunds));
        this.console.println("\n=================================================");

    }
    private void Inventory() {
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
        double availableFunds = GameControl.getFundAmount();
        double remainingFunds = availableFunds - sumExCost;
        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.print("\nFunds in hand                         " + decForm.format(availableFunds));
        this.console.print("\nFunds remaining                       " + decForm.format(remainingFunds));
        this.console.println("\n=================================================");

    }
    
        private void stockInHand() {
        InventoryItem[] inventory = oregontrailv2.OregonTrailv2.getCurrentGame().getInventory();
        OccupationType[] occupation = oregontrailv2.OregonTrailv2.getCurrentGame().getOccupation();

        this.console.println("\n===============Oregon Trail Game================="
                + "\n\n          Inventory - Stock in Hand            "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(37, "Quantity");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        int num = 0;

        for (InventoryItem inventoryItem : inventory) {
            num += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, num + " - " + inventoryItem.getDescription());
            line.insert(37, inventoryItem.getQuantityInStock());

            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
        }
        this.console.println("=================================================");
        
    }
        
            private void occupation() {
        OccupationType[] occupation = oregontrailv2.OregonTrailv2.getCurrentGame().getOccupation();

        this.console.println("\n===============Oregon Trail Game================="
                + "\n\n       Occupation types & Initial Funds        "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(37, "Initial Fund");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        int num = 0;

        for (OccupationType job : occupation) {
            num += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, num + " - " + job.getDescription());
            line.insert(38, job.getFundAmount());

            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
        }
        this.console.println("=================================================");
        
    }

    private void viewLocation() {
        this.console.println("\n*** viewLocation() function called ***");
    }

}
