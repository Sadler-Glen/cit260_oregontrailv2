/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.model.LandMark;
import byui.cit260.oregonTrail.model.Actor;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.Location;
import byui.cit260.oregonTrail.model.Map;
//import byui.cit260.oregonTrail.view.
import java.io.PrintWriter;





/**
 *
 * @author adm-achina
 */
public class MapControl {
    
    
    public static Map createMap() {
        // create the map
        Map map = new Map(5, 5);

        // create the scenes for the game
        Scene[] scenes = createScenes();

        // assign scenes to locations
        assignScenesToLocations(map, scenes);

        return map;
    }

    public static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];
    

        // insert scene code  here//
        
        
        
        // assigns the scene to a location
        

    public static void movePlayerToStartingLocation(Map map) {
        // If starting location is not supposed to be 0,0 then use the correct values here.
        movePlayer(map, 0, 0);
    }
    
    public static void movePlayerToLocation(int row, int column) throws MapControlException {
        Map map = LostTeam.getCurrentGame().getMap();
        
        if (row < 0 || row >= map.getRowCount() ||
            column < 0 || column >= map.getColumnCount()) {
            throw new MapControlException("Can not move player to location "
                                        + row + ", " + column
                                        + " because that location is outside"
                                        + " the bounds of the map.");
        }
        
        movePlayer(map, row, column);
    }
    
    private static void movePlayer(Map map, int row, int column) {
        map.setCurrentLocation(map.getLocations()[row][column]);
        map.getCurrentLocation().setVisited(true);
        map.setCurrentRow(row);
        map.setCurrentColumn(column);
    }
    
    public static void displayMap(Map map, PrintWriter writer) {
        String leftIndicator;
        String rightIndicator;
        
        Location[][] locations = map.getLocations(); // retreive the locations from map
        // Build the heading of the map
        writer.print("  |");
        for (int column = 0; column < locations[0].length; column++) {
            // print col numbers to side of map
            writer.print("  " + column + " |");
        }
        // Now build the map.  For each row, show the column information
        writer.println();
        for (int row = 0; row < locations.length; row++) {
            writer.print(row + " "); // print row numbers to side of map
            for (int column = 0; column < locations[row].length; column++) {
                // set default indicators as blanks
                leftIndicator = " ";
                rightIndicator = " ";
                if (locations[row][column] == map.getCurrentLocation()) {
                    // Set star indicators to show this is the current location.
                    leftIndicator = "*"; 
                    rightIndicator = "*"; 
                } else if (locations[row][column].isVisited()) {
                    // Set < > indicators to show this location has been visited.
                    leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                    rightIndicator = "<"; // same as above
                }
                writer.print("|"); // start map with a |
                if (locations[row][column].getScene() == null) {
                    // No scene assigned here so use ?? for the symbol
                    writer.print(leftIndicator + "??" + rightIndicator);
                } else {
                    writer.print(leftIndicator
                               + locations[row][column].getScene().getSignSymbol()
                               + rightIndicator);
                }
            }
            writer.println("|");
        }
    }
    
    public static void displayMapKey(Map map, PrintWriter writer) {
        Location[][] locations = map.getLocations();
        writer.println(
                "\n****************************************************************"
              + "\n*                           Map Key                            *");
        for (Location[] location1 : locations) {
            for (Location location : location1) {
                writer.println(String.format("%1$-63s", "* " + location.getScene().getSignSymbol() + ": " + location.getScene().getDescription()) + "*");
            }
        }
        writer.println("****************************************************************");
    }
}
