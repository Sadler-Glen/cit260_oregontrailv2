/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.exceptions.FoodControlException;
import byui.cit260.oregonTrail.exceptions.MapControlException;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.Location;
import byui.cit260.oregonTrail.model.Map;
import byui.cit260.oregonTrail.model.Question;
import byui.cit260.oregonTrail.model.QuestionType;
import byui.cit260.oregonTrail.model.Scene;
import byui.cit260.oregonTrail.model.SceneGroup;
import byui.cit260.oregonTrail.model.SceneType;
import static byui.cit260.oregonTrail.model.SceneType.start;
import java.awt.Point;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author Glen Sadler
 */
public class MapControl {

    public static Map createMap() {
        // create the map
        Map map = new Map(5, 5);
        return map;
    }

    public static Location[][] createLocations(int rows, int columns) {
//        IF rows < 1 OR columns < 1 THEN
//            RETURN null
//        ENDIF
//        locations = new two-dimensional Location array
//        FOR every row in the locations array
//            FOR every column in the locations array
//                location = create a new Location object
//                set the row, and column attributes in the location
//                set visited attribute to false
//                Assign location to the row, and column in array
//        ENDFOR
//        RETURN locations

        if (rows < 1 || columns < 1) {
        }
        int noOfRows = 5;
        int noOfColumns = 5;
        Location[][] locations = new Location[noOfRows][noOfColumns];

//        for(int i = 0; i < noOfRows.length; i++ ){
//            for(int j = 0; j < noOfColumns.length; j++ ){
//                Location[][] location = new Location[][];
//                
//            }
//        }
        return locations;
    }

    public static Scene[] createScenes() {
        // create scenes
        Game game = OregonTrailv2.getCurrentGame();
        Scene[] scenes = new Scene[SceneType.values().length];

        Scene start = new Scene();
        start.setSceneType(0);
        start.setDescription("Start");
        start.setBlocked(false);
        start.setMapSymbol("");
        start.setTravelTime(0);
        scenes[SceneType.start.ordinal()] = start;

        Scene store = new Scene();
        store.setSceneType(0);
        store.setDescription("Store");
        store.setBlocked(false);
        store.setMapSymbol("");
        store.setTravelTime(0);
        scenes[SceneType.store.ordinal()] = store;

        Scene mountain = new Scene();
        mountain.setSceneType(0);
        mountain.setDescription("Mountain");
        mountain.setBlocked(false);
        mountain.setMapSymbol("");
        mountain.setTravelTime(0);
        scenes[SceneType.mountain.ordinal()] = mountain;

        Scene river = new Scene();
        river.setSceneType(0);
        river.setDescription("River");
        river.setBlocked(false);
        river.setMapSymbol("");
        river.setTravelTime(0);
        scenes[SceneType.river.ordinal()] = river;

        Scene wilderness = new Scene();
        wilderness.setSceneType(0);
        wilderness.setDescription("Wilderness");
        wilderness.setBlocked(false);
        wilderness.setMapSymbol("");
        wilderness.setTravelTime(0);
        scenes[SceneType.wilderness.ordinal()] = wilderness;

        Scene hunt = new Scene();
        hunt.setSceneType(0);
        hunt.setDescription("Hunt");
        hunt.setBlocked(false);
        hunt.setMapSymbol("");
        hunt.setTravelTime(0);
        scenes[SceneType.hunt.ordinal()] = hunt;

        Scene fort = new Scene();
        fort.setSceneType(0);
        fort.setDescription("Fort");
        fort.setBlocked(false);
        fort.setMapSymbol("");
        fort.setTravelTime(0);
        scenes[SceneType.fort.ordinal()] = fort;

        Scene bridge = new Scene();
        bridge.setSceneType(0);
        bridge.setDescription("Bridge");
        bridge.setBlocked(false);
        bridge.setMapSymbol("");
        bridge.setTravelTime(0);
        scenes[SceneType.bridge.ordinal()] = bridge;

        Scene finish = new Scene();
        finish.setSceneType(0);
        finish.setDescription("finish");
        finish.setBlocked(false);
        finish.setMapSymbol("");
        finish.setTravelTime(0);
        scenes[SceneType.finish.ordinal()] = finish;

        return scenes;
    }

//    public static Question[] createQuestions(){
//        Question[] questions = new Question[QuestionType.values().length];
//        
//        Question start = new Question();
//        start.setQuestion("What month should I leave?");
//        start.setAnswer("Don't leave too late or too early?");
//        questions[QuestionType.start.ordinal()] = start;
//        
//        Question riverCross = new Question();
//        riverCross.setQuestion("How much is it to cross");
//        riverCross.setAnswer("It will cost $5.00");
//        questions[QuestionType.riverCross.ordinal()] = riverCross;
//        
//        Question trade = new Question();
//        trade.setQuestion("What can you give me");
//        trade.setAnswer("Whatever you want");
//        questions[QuestionType.trade.ordinal()] = trade;
//        
//        return questions;
//    }
//    
//    public static void assignQuestionsToScenes(Question[] questions, 
//                                                Scene[] scenes){
//        System.out.println("\n*** assignQuestionsToScenes called ***");
//    }
//    
//    public static void assignItemsToScenes(InventoryItem[] items,
//                                            Scene[] scenes){
//        System.out.println("\n*** assignItemsToScenes called ***");
//    }
//    
//    public static void assignScenesToLocations(Scene[] scenes, 
//                                                Location[][] locations){
//        System.out.println("\n*** assignScensToLocations called ***");
//    }

//    public static int moveActorsToStartingLocation(Map map) {
//        // for every actor
//        Actor[] actors = Actor.values();
//
//        for (Actor actor : actors) {
//            int returnValue = MapControl.moveActorToLocation(actor, actor.getCoordinates());
//            if (returnValue < 0) {
//                return returnValue;
//            }
//        }
//        return 0;
//        
//    }
//    
//    
//        
//    
//    public static void moveActorToLocation(OregonTrailv2 actor, Point coordinates)
//                            throws MapControlException{
//        
//        Map map = OregonTrailv2.getCurrentGame().getMap();
//        int newRow = coordinates.x-1;
//        int newColumn = coordinates.y-1;
//        
//        if (newRow < 0  || newRow >= map.getNoOfRows() ||
//            newColumn < 0  || newColumn >= map.getNoOfColumns()) {
//            throw new MapControlException("Cannot move actor to location"
//                    + coordinates.x + ", " + coordinates.y
//                    + " because the location is outside"
//                    + "the bounds of the map.");
//        }
//        
//        Location newLocation = map.getLocations()[newRow][newColumn];
//        Point actorCoordinates = actor.getCoordinates();
//        Location oldLocation = map.getLocations()[actorCoordinates.x][actorCoordinates.y];
//        
//        // check to see if the actor is in the current location
//        if (oldLocation != null) {
//            oldLocation.removeActor(actor); // remove actor from old location
//        }
//        
//        newLocation.addActor(actor); // add actor to new location
//        actorCoordinates.x = newRow;
//        actorCoordinates.y = newColumn; // set actor to new location
//        newLocation.setVisited(true); // mark as a visted locations
//        
//    }
//    
//    
//    
//    public static Location getLocation(Point coordinates) {
//        System.out.println("*** getLocation() called");
//        Location location = new Location();
//        location.setRow(coordinates.x);
//        location.setScene(new Scene(SceneGroup.regular, "You are in the ocean", "~~~", 0, true));
//        location.setColumn(coordinates.y);
//        return location;
//    }
    
}
