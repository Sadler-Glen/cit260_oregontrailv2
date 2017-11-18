/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.Location;
import byui.cit260.oregonTrail.model.Scene;

/**
 * 
 * @author Glen Sadler
 */

public class GameMenuView extends View {

    public GameMenuView() {
        super( "\n"
            + "\n===============Oregon Trail Game================="
            + "\n                                                 "
            + "\n                   Game Menu                     "
            + "\n                                                 "
            + "\n1 - View map                                     "
            + "\n2 - View sorted List of items in inventory       "
//            + "\n3 - View location                                "
            + "\n3 - Display help menu                            "
            + "\nQ - Quit                                         "
            + "\n                                                 "
            + "\n================================================="
                ,"\nPlease enter your choice: " );
                
    }
  
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
     
        switch (choice) {
            case '1': // Travel to new location
                this.displayMap(); 
                break;
            case '2': // View list of items in inventory
                this.viewInventory(); 
                break;
//            case '3': // View description of location
//                this.viewLocation(); 
//                break;    
            case '3': // display the help menu
                this.displayHelpMenu();
                break;
            case 'Q':
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        return false;
    }
    

    public void displayMap() {
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
            if (i < 9)
                System.out.print(" " + (i+1));
            else 
                System.out.print(i+1);
            
            // for every column in the row
            for (int column = 0; column < noColumns; column++) {
                System.out.print("|"); // print column divider
                Location location = rowLocations[column];
                if (location.isVisited() || location == null) { // if location is visited 
                    Scene scene = location.getScene();
                    System.out.print(scene.getMapSymbol());
                }
                else {
                    System.out.print(" ?? ");
                }  
                
                Scene scene = location.getScene();
                System.out.print(scene.getMapSymbol());
                
            }
            System.out.print("|"); // print column divider
        }
        
        this.printRowDivider(noColumns);
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
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\nList of Inventory Items");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description"); 
        line.insert(20, "Required");
        line.insert(30, "In Stock");
        System.out.println(line.toString());
        
        // for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            line = new StringBuilder("                                                          ");
            line.insert(0, inventoryItem.getDescription());
            line.insert(23, inventoryItem.getRequiredAmount());
            line.insert(33, inventoryItem.getQuantityInStock());
            
            // DISPLAY the description, the required amount and amount in stock
            System.out.println(line.toString());
        }   
    }


    private void printColumnHeaders(int noOfColumns) {
        for (int i = 1; i < noOfColumns+1; i++) {
            if (i < 10) {
                System.out.print("   " + i + " ");
            }
            else {
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
    
}
