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
                + "\n  2 - Get and start a saved game                 "
                + "\n  3 - Information about the trail                "
                + "\n  4 - Save Game                                  "
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
            try{
            String value = this.getInput();
            
            if (value.toUpperCase().equals("Q")){// user wants to quit
                System.exit(0); // exit game
            }
            done = this.doAction(value);
            }catch(NumberFormatException nfe){
                this.console.println("Invalid number");
            }

        } while (!done);
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); // convert choice to upper cas

        switch (choice) {
            case "1": //create and start a new game
                this.startNewGame();
                break;
            case "2": //get and start a saved game
                this.startSavedGame();
                this.gameMenu();
                break;
            case "3": //display information about the trail
                this.displayHelpInfo();
                break;
            case "4": //save the current game
                this.saveGame();
                break;             
            default:
                ErrorView.display(this.getClass().getName(), "***Invalid selection - Try again***");
                break;
        }
        return false;
    }

    private void startNewGame() {
        // create a new game
        GameControl.createNewGame(OregonTrailv2.getPlayer());
        GameControl.createOccupation();
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

    private void startSavedGame() {
        // prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path where the game"
                + " is saved");
        String filepath = this.getFileName();
        try {
            // start a saved game
            GameControl.getSavedGame(filepath);
        } catch (Exception e) {
            ErrorView.display("MainMenuView", e.getMessage());
        }

        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void displayHelpInfo() {
        // display the help menu
        //Create HelpInfoView
        HelpInfoView helpInfo = new HelpInfoView();

        //Display HelpInfoView
        helpInfo.display();
    }

    private void saveGame() {
        //prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path for where the game"
                + " is to be saved: ");
        String filePath = this.getFileName();
        
        try {
            // save the game to the specified file
            GameControl.saveGame(OregonTrailv2.getCurrentGame(), filePath);
            this.console.println("\nYour file has been saved in "+filePath);
        } catch (Exception e) {
            ErrorView.display("MainMenuView", e.getMessage());
        }    
    }

    public String getFileName() {

        //Scanner keyboard = new Scanner(System.in);
        boolean valid = false; // initialize to not valid
        String value = null;
        try {
            // while a valid name has not been retrieved
            while (!valid) {
                // get the value entered from keyboard
                value = keyboard.readLine();

                // trim off leading and trailing blanks
                value = value.trim();

                if (value.length() < 1) { // value is blank
                    ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }
                break; // end the loop
            }

        } catch (Exception e) {
            this.console.println("Error reading input: " + e.getMessage());
        }

        return value; // return the value entered
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
        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.println("\n=================================================");
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

        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.println("\n=================================================");
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

        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.println("\n=================================================");
    }

    private void gameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }   
}