/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.Location;
import byui.cit260.oregonTrail.model.OccupationType;
import byui.cit260.oregonTrail.model.Scene;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
                + "\n3 - View Trail Status                            "
                + "\n4 - Move actors menu                             "
                + "\n5 - River Crossing menu                          "
                + "\n6 - Hunt menu                                    "
                + "\n7 - Change pace menu                             "
                + "\n8 - Gather food menu                             "
                + "\n9 - Change food rations menu                     "
                + "\nT - Attempt to trade menu                        "
                + "\nP - Talk to people                               "
                + "\nI - Inventory report menu                        "
                + "\nH - Display help menu                            "
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
                this.displayGameMap();
                break;
            case '2': // View description of location
                this.viewLocation(); 
                break;
            case '3': // View Staus of company, weather, Health
                this.trailStatus();
                break;
            case '4': // Move actors on trail
                this.moveActors();
                break;
            case '5': // View list of inventory - sorted by description
                this.riverCrossing();
                break;
            case '6': // View list of inventory - sorted by item cost
                this.hunt();
                break;
            case '7': // change pace
                this.paceChange();
                break;                
            case '8': // gather food
                this.gatherFood();
                break;
            case '9': // change rations
                this.rationChange();
                break;                
            case 'T': // change rations
                this.tradeAttempt();
                break;
            case 'P': // talk to people
                this.talkToPeople();
                break;
            case 'I': // inventory report
                this.inventoryReport();
                break;
            case 'A': // display the help menu
                this.displayHelpMenu();
                break;
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
    
//    private void displayMap() {
//
//        // get the map for the game
//        Location[][] locations = GameControl.getMapLocations();
//        int noColumns = locations[0].length; // get number columns in row
//
//        this.printTitle(noColumns, "THE OREGON TRAIL");
//        this.printColumnHeaders(noColumns);
//
//        for (int i = 0; i < locations.length; i++) {
//            Location[] rowLocations = locations[i];
//            this.printRowDivider(noColumns);
//            this.console.println(); // move down one i
//            if (i < 9) {
//                this.console.print(" " + (i + 1));
//            } else {
//                this.console.print(i + 1);
//            }
//
//            // for every column in the row
//            for (int column = 0; column < noColumns; column++) {
//                this.console.print("|"); // print column divider
//                Location location = rowLocations[column];
//                if (location.isVisited() || location == null) { // if location is visited 
//                    Scene scene = location.getScene();
//                    this.console.print(scene.getMapSymbol());
//                } else {
//                    this.console.print(" ?? ");
//                }
//
//                Scene scene = location.getScene();
//                this.console.print("");//(scene.getMapSymbol());
//
//            }
//            this.console.print("|"); // print column divider
//        }
//
//        this.printRowDivider(noColumns);
//    }
//
//    private void printColumnHeaders(int noOfColumns) {
//        for (int i = 1; i < noOfColumns + 1; i++) {
//            if (i < 10) {
//                this.console.print("   " + i + " ");
//            } else {
//                this.console.print("  " + i + " ");
//            }
//        }
//    }    
//
//    private void printRowDivider(int noColumns) {
//        this.console.println();
//        this.console.print("  ");
//        for (int i = 0; i < noColumns; i++) { // print row divider
//            this.console.print("-----");
//        }
//        this.console.print("-");
//    }
//
//    private void printTitle(int noOfColumns, String title) {
//
//        int titleLength = title.length();
//        int lineLength = noOfColumns * 5 + 3;
//        int startPosition = (lineLength / 2) - (titleLength / 2);
//        this.console.println("\n");
//        for (int i = 0; i < startPosition; i++) {
//            this.console.print(" ");
//        }
//        this.console.print(title);
//        this.console.println("\n");
//    }
    
//    private void viewLocation() {
//        ViewLocationView viewLocationView = new ViewLocationView();
//        viewLocationView.display();
//    }
    private void displayHelpMenu() {
        HelpInfoView helpMenu = new HelpInfoView();
        helpMenu.display();
    }

    private void viewLocation() {
        this.console.println("\n*** viewLocation() function stub called ***");
    }

    private void moveActors() {
        this.console.println("\n*** moveActors() function stub called ***");    
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

    private void fileInventoryDescription() {
        PrintWriter bw = null;
        FileWriter fw = null;
        
        //prompt for and get the name of the file to save the reort in
        this.console.println("\n\nEnter the path to save report: ");
        File filePath = new File(this.getFileName());
        
        try {
            fw = new FileWriter(filePath);
            bw = new PrintWriter(fw);
            this.console.println("\nYour file has been saved in "+filePath);
       
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListDescription();
              
        bw.println("\n===============Oregon Trail Game=================");
        bw.println("\n\n   Sorted List of Inventory Items(Description)     ");
        bw.println("\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        bw.println(line.toString());
        bw.println("=================================================");

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
            bw.println(line.toString());
        }

        bw.println("-------------------------------------------------");
        bw.println("\nCost of Bill                          " + decForm.format(sumExCost));
        bw.println("\n=================================================");
        
        
        } catch(IOException e){
            ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
        } finally {
            
        try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
                ex.printStackTrace();

            }    
        } 
    }

    private void fileInventoryCost() {
        PrintWriter bw = null;
        FileWriter fw = null;

        //prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the path to save report: ");
        File filePath = new File(this.getFileName());
        
        try {
            fw = new FileWriter(filePath);
            bw = new PrintWriter(fw);
            this.console.println("\nYour file has been saved in "+filePath);
       
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListCost();
        bw.println("\n===============Oregon Trail Game=================");
        bw.println("\n\n     Sorted List of Inventory Items(Cost)    ");
        bw.println("\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        bw.println(line.toString());
        bw.println("=================================================");

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
            bw.println(line.toString());
        }

        bw.println("-------------------------------------------------");
        bw.println("\nCost of Bill                          " + decForm.format(sumExCost));
        bw.println("\n=================================================");
        
        } catch(IOException e){
            ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
        } finally {
            
        try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
                ex.printStackTrace();

            }    
        } 
    }    

    private void trailStatus() {
        this.console.println("\n*** trailStatus function stub called ***");
    }

    private void riverCrossing() {
        RiverCrossingMenuView river = new RiverCrossingMenuView();
        river.display();
    }

    private void hunt() {
        HuntMenuView hunt = new HuntMenuView();
        hunt.display();
    }

    private void pace() {
        PaceMenuView pace = new PaceMenuView();
        pace.display();
    }

    private void gatherFood() {
        GatherFoodMenuView gatherFood = new GatherFoodMenuView();
        gatherFood.display();
    }
    
    private void inventoryReport() {
        ReportMenuView report = new ReportMenuView();
        report.display();
    }

    private void rationChange() {
        RationMenuView ration = new RationMenuView();
        ration.display();
    }

    private void paceChange() {
        PaceMenuView pace = new PaceMenuView();
        pace.display();
    }

    private void tradeAttempt() {
        this.console.println("***tradeAttempt() function stub called***");
    }

    private void talkToPeople() {
        this.console.println("***talkToPeople() function stub called***");
    }

    private void displayGameMap() {
        DisplayMapView displayMap = new DisplayMapView();
        displayMap.displayMap();
    }
}
