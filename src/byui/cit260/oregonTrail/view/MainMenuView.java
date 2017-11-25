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
import byui.cit260.oregonTrail.model.Scene;
import oregontrailv2.OregonTrailv2;
import java.text.DecimalFormat;

/**
 *
 * @author sadss
 */
public class MainMenuView extends View {

    public MainMenuView() {

        super("\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n                   Main Menu                     "
                + "\n                                                 "
                + "\n  1 - Travel the trail                           "
                + "\n  2 - Get and save an existing Game              "
                + "\n  3 - Information about the trail                "
                + "\n  4 - View Map                                   "
                + "\n  5 - View inventory sorted by description       "
                + "\n  6 - View inventory sorted by quantity in stock "
                + "\n  7 - View inventory sorted by item cost         "
                + "\n  8 - Save Game                                  "
                + "\n  Q - Quit                                       "
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
            if (value.toUpperCase().equals("Q"))// user wants to quit
            {
                return; // exit game
            }
            done = this.doAction(value);

        } while (!done);
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); // convert choice to upper cas

        switch (choice) {
            case "1": //create and start a new game
                this.startNewGame();
                break;
            case "2": //get and start an existing game
                this.startExistingGame();
                break;
            case "3": //display information about the trail
                this.displayHelpInfo();
                break;
            case "4": //display the map
                this.viewMap();
                break;
            case "5": //display Inventory sorted by description
                this.viewInventoryDescription();
                break;
            case "6": //display Inventory sorted by quantity in stock
                this.viewInventoryInStock();
                break;
            case "7": //display Inventory sorted by item cost
                this.viewInventoryCost();
                break;
            case "8": //save the current game
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
        MapControl.createMap();
        MapControl.createLocations(5, 5);
        MapControl.createScenes();
//       MapControl.createQuestions();
//       MapControl.assignQuestionsToScenes(questions, scenes);
//       MapControl.assignQuestionsToScenes(questions, scenes);
//       MapControl.assignScenesToLocations(scenes, locations);

        //Create OccupationMenuView Object
        OccupationMenuView occupation = new OccupationMenuView();

        //Display the OccupationMenuView
        occupation.display();
    }

    private void startExistingGame() {
        System.out.println("\n*** startExistingGame function called ***");
    }

    private void displayHelpInfo() {
        // display the help menu
        //Create HelpInfoView
        HelpInfoView helpInfo = new HelpInfoView();

        //Display HelpInfoView
        helpInfo.display();
    }

    private void saveGame() {
        System.out.println("\n*** saveGame function called ***");
    }

    private void viewMap() {
        GameControl.createNewGame(OregonTrailv2.getPlayer());
        MapControl.createMap();
        MapControl.createLocations(5, 5);
        MapControl.createScenes();
//       MapControl.createQuestions();
        this.displayMap();
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
            System.out.println(); // move down one i
            if (i < 9) {
                System.out.print(" " + (i + 1));
            } else {
                System.out.print(i + 1);
            }

            // for every column in the row
            for (int column = 0; column < noColumns; column++) {
                System.out.print("|"); // print column divider
                Location location = rowLocations[column];
                if (location.isVisited() || location == null) { // if location is visited 
                    Scene scene = location.getScene();
                    System.out.print(scene.getMapSymbol());
                } else {
                    System.out.print(" ?? ");
                }

                Scene scene = location.getScene();
                System.out.print("");//(scene.getMapSymbol());

            }
            System.out.print("|"); // print column divider
        }

        this.printRowDivider(noColumns);
    }

    private void printColumnHeaders(int noOfColumns) {
        for (int i = 1; i < noOfColumns + 1; i++) {
            if (i < 10) {
                System.out.print("   " + i + " ");
            } else {
                System.out.print("  " + i + " ");
            }
        }
    }

    private void printRowDivider(int noColumns) {
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < noColumns; i++) { // print row divider
            System.out.print("-----");
        }
        System.out.print("-");
    }

    private void printTitle(int noOfColumns, String title) {

        int titleLength = title.length();
        int lineLength = noOfColumns * 5 + 3;
        int startPosition = (lineLength / 2) - (titleLength / 2);
        System.out.println("\n");
        for (int i = 0; i < startPosition; i++) {
            System.out.print(" ");
        }
        System.out.print(title);
        System.out.println("\n");

    }

//    private void viewLocation() {
//        ViewLocationView viewLocationView = new ViewLocationView();
//        viewLocationView.display();
//    }
    //L10 individual assignment - function calling bubble sort(Line 225) on 
    //inventory description and displaying to user. Also adds extCost to display
    //extCost is calculated using the getCost * getQuantityInStock getters (Line 246)
    //sum of extCost to variable sumExtCost and displayed to user as total cost of bill
    private void viewInventoryDescription() {
        GameControl.createNewGame(OregonTrailv2.getPlayer());
        MapControl.createMap();
        MapControl.createLocations(5, 5);
        MapControl.createScenes();
//        MapControl.createQuestions();
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListDescription();

        System.out.println("\n===============Oregon Trail Game================="
                + "\n\n   Sorted List of Inventory Items(Description)   "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        System.out.println(line.toString());
        System.out.println("=================================================");

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
            System.out.println(line.toString());
        }
        System.out.print("-------------------------------------------------");
        System.out.print("\nCost of Bill                          " + decForm.format(sumExCost));
        System.out.println("\n=================================================");
    }

    //function calling bubble sort on inventory cost and displaying to user
    // THIS FUNCTION CREATED BY IGNACIO
    private void viewInventoryCost() {
        GameControl.createNewGame(OregonTrailv2.getPlayer());
        MapControl.createMap();
        MapControl.createLocations(5, 5);
        MapControl.createScenes();
//        MapControl.createQuestions();
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListCost();

        System.out.println("\n===============Oregon Trail Game================="
                + "\n\n    Sorted List of Inventory Items(Item Cost)    "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        System.out.println(line.toString());
        System.out.println("=================================================");

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
            System.out.println(line.toString());
        }

        System.out.print("-------------------------------------------------");
        System.out.print("\nCost of Bill                          " + decForm.format(sumExCost));
        System.out.println("\n=================================================");
    }
    // L10 individual assignment - calls bubble sort in gamecontrol line 298
    // 

    private void viewInventoryInStock() {
        GameControl.createNewGame(OregonTrailv2.getPlayer());
        MapControl.createMap();
        MapControl.createLocations(5, 5);
        MapControl.createScenes();
//        MapControl.createQuestions();
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListInStock();

        System.out.println("\n===============Oregon Trail Game================="
                + "\n\n  Sorted List of Inventory Items (QTY in Stock)  "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        System.out.println(line.toString());
        System.out.println("=================================================");

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
            System.out.println(line.toString());
        }

        System.out.print("-------------------------------------------------");
        System.out.print("\nCost of Bill                          " + decForm.format(sumExCost));
        System.out.println("\n=================================================");
    }
}
