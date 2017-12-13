/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.exceptions.MapControlException;
import byui.cit260.oregonTrail.model.Actor;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.Location;
import byui.cit260.oregonTrail.model.Map;
import byui.cit260.oregonTrail.model.Question;
import byui.cit260.oregonTrail.model.QuestionType;
import byui.cit260.oregonTrail.model.Scene;
import byui.cit260.oregonTrail.model.SceneGroup;
import byui.cit260.oregonTrail.model.SceneType;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author Glen Sadler
 */
public class MapControl implements Serializable{

    public static Map createMap() {
        // create the map
        Map map = new Map(20, 20);
        
        // create a list of different scenes in the game
        Scene[] scenes = createScenes();
        
//        assign different scenes to locations in the map
        assignScenesToLocations(map, scenes);
        return map;
    }

    public static Location[][] createLocations(int rows, int columns) throws Exception{
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
        
        Location[][] locations = new Location[rows][columns];
        
        
        for (int rowCount = 0; rowCount < rows; rowCount++) {
            for (int colCount = 0; colCount < columns; colCount++) {
               
                Location area = new Location();
                area.setVisited(false);
                
                locations[rowCount][colCount] = area;
            }
        }

//        for(int i = 0; i < rowCount.length; i++ ){
//            for(int j = 0; j < colCount.length; j++ ){
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

        Scene Start = new Scene();
        Start.setDescription("Start - Indepence");
        Start.setBlocked(false);
        Start.setMapSymbol("*ST*");
        Start.setTravelTime(0);
        Start.setLocation(new Point(18, 19));
        scenes[SceneType.Start.ordinal()] = Start;

        Scene KansasRiverCrossing = new Scene();
        KansasRiverCrossing.setDescription("Kansas River Crossing");
        KansasRiverCrossing.setBlocked(false);
        KansasRiverCrossing.setMapSymbol("}=={");
        KansasRiverCrossing.setTravelTime(0);
        KansasRiverCrossing.setLocation(new Point(15, 19));
        scenes[SceneType.KansasRiverCrossing.ordinal()] = KansasRiverCrossing;
        
        Scene BigBlueRiverCrossing = new Scene();
        BigBlueRiverCrossing.setDescription("Big Blue River Crossing");
        BigBlueRiverCrossing.setBlocked(false);
        BigBlueRiverCrossing.setMapSymbol("}=={");
        BigBlueRiverCrossing.setTravelTime(0);
        BigBlueRiverCrossing.setLocation(new Point(8, 19));
        scenes[SceneType.BigBlueRiverCrossing.ordinal()] = BigBlueRiverCrossing;

        Scene FortKearney = new Scene();
        FortKearney.setDescription("Fort Kearney");
        FortKearney.setBlocked(false);
        FortKearney.setMapSymbol("*FT*");
        FortKearney.setTravelTime(0);
        FortKearney.setLocation(new Point(10, 19));
        scenes[SceneType.FortKearney.ordinal()] = FortKearney;

        Scene ChimneyRock = new Scene();
        ChimneyRock.setDescription("ChimneyRock");
        ChimneyRock.setBlocked(false);
        ChimneyRock.setMapSymbol("*^^*");
        ChimneyRock.setTravelTime(0);
        ChimneyRock.setLocation(new Point(10, 17));
        scenes[SceneType.ChimneyRock.ordinal()] = ChimneyRock;

        Scene FortLaramie = new Scene();
        FortLaramie.setDescription("FortLaramie");
        FortLaramie.setBlocked(false);
        FortLaramie.setMapSymbol("||||");
        FortLaramie.setTravelTime(0);
        FortLaramie.setLocation(new Point(16, 13));  
        scenes[SceneType.FortLaramie.ordinal()] = FortLaramie;
        
        Scene IndependenceRock = new Scene();
        IndependenceRock.setDescription("IndependenceRock");
        IndependenceRock.setBlocked(false);
        IndependenceRock.setMapSymbol("*^^*");
        IndependenceRock.setTravelTime(0);
        IndependenceRock.setLocation(new Point(10, 17));
        scenes[SceneType.IndependenceRock.ordinal()] = IndependenceRock;
        
        Scene SouthPass = new Scene();
        SouthPass.setDescription("SouthPass");
        SouthPass.setBlocked(false);
        SouthPass.setMapSymbol("^--^");
        SouthPass.setTravelTime(0);
        SouthPass.setLocation(new Point(8, 11));
        scenes[SceneType.SouthPass.ordinal()] = SouthPass;
        
        Scene FortBridger = new Scene();
        FortBridger.setDescription("FortBridger");
        FortBridger.setBlocked(false);
        FortBridger.setMapSymbol("||||");
        FortLaramie.setTravelTime(0);
        FortLaramie.setLocation(new Point(5, 9));  
        scenes[SceneType.FortBridger.ordinal()] = FortBridger;
        
        Scene SodaSprings = new Scene();
        SodaSprings.setDescription("SodaSprings");
        SodaSprings.setBlocked(false);
        SodaSprings.setMapSymbol("*TN*");
        SodaSprings.setTravelTime(0);
        SodaSprings.setLocation(new Point(9, 8));  
        scenes[SceneType.SodaSprings.ordinal()] = SodaSprings;
        
        Scene FortHall = new Scene();
        FortHall.setDescription("FortHall");
        FortHall.setBlocked(false);
        FortHall.setMapSymbol("||||");
        FortHall.setTravelTime(0);
        FortHall.setLocation(new Point(15, 7));  
        scenes[SceneType.FortHall.ordinal()] = FortHall;
        
        Scene SnakeRiverCrossing = new Scene();
        SnakeRiverCrossing.setDescription("SnakeRiverCrossing");
        SnakeRiverCrossing.setBlocked(false);
        SnakeRiverCrossing.setMapSymbol("}=={");
        SnakeRiverCrossing.setTravelTime(0);
        SnakeRiverCrossing.setLocation(new Point(18, 4));
        scenes[SceneType.SnakeRiverCrossing.ordinal()] = SnakeRiverCrossing;
        
        Scene FortBoise = new Scene();
        FortBoise.setDescription("FortBoise");
        FortBoise.setBlocked(false);
        FortBoise.setMapSymbol("||||");
        FortBoise.setTravelTime(0);
        FortBoise.setLocation(new Point(16, 7));  
        scenes[SceneType.FortBoise.ordinal()] = FortBoise;
        
        Scene BlueMountains = new Scene();
        BlueMountains.setDescription("BlueMountains");
        BlueMountains.setBlocked(false);
        BlueMountains.setMapSymbol("||||");
        BlueMountains.setTravelTime(0);
        BlueMountains.setLocation(new Point(15, 0));  
        scenes[SceneType.BlueMountains.ordinal()] = BlueMountains;

        Scene FortWallaWalla = new Scene();
        FortWallaWalla.setDescription("FortBoise");
        FortWallaWalla.setBlocked(false);
        FortWallaWalla.setMapSymbol("||||");
        FortWallaWalla.setTravelTime(0);
        FortWallaWalla.setLocation(new Point(12, 3));  
        scenes[SceneType.FortWallaWalla.ordinal()] = FortWallaWalla;
        
        Scene TheDalles = new Scene();
        TheDalles.setDescription("TheDalles");
        TheDalles.setBlocked(false);
        TheDalles.setMapSymbol("*TN*");
        TheDalles.setTravelTime(0);
        TheDalles.setLocation(new Point(9, 4));  
        scenes[SceneType.TheDalles.ordinal()] = TheDalles;
        
        Scene BarlowTollRoad = new Scene();
        BarlowTollRoad.setDescription("BarlowTollRoad");
        BarlowTollRoad.setBlocked(false);
        BarlowTollRoad.setMapSymbol("^--^");
        BarlowTollRoad.setTravelTime(0);
        BarlowTollRoad.setLocation(new Point(12, 4));  
        scenes[SceneType.BarlowTollRoad.ordinal()] = BarlowTollRoad;
        
        Scene WillametteValley = new Scene();
        WillametteValley.setDescription("Finish - Willamete Valley");
        WillametteValley.setBlocked(false);
        WillametteValley.setMapSymbol("^--^");
        WillametteValley.setTravelTime(0);
        WillametteValley.setLocation(new Point(7, 4));  
        scenes[SceneType.WillametteValley.ordinal()] = WillametteValley;

        return scenes;

    }

    public static Question[] createQuestions(){
        Question[] questions = new Question[QuestionType.values().length];
        
        Question start = new Question();
        start.setQuestion("What month should I leave?");
        start.setAnswer("Don't leave too late or too early?");
        questions[QuestionType.start.ordinal()] = start;
        
        Question riverCross = new Question();
        riverCross.setQuestion("How much is it to cross");
        riverCross.setAnswer("It will cost $5.00");
        questions[QuestionType.riverCross.ordinal()] = riverCross;
        
        Question trade = new Question();
        trade.setQuestion("What can you give me");
        trade.setAnswer("Whatever you want");
        questions[QuestionType.trade.ordinal()] = trade;
        
        return questions;
    }
    
    public static void assignQuestionsToScenes(Question[] questions, 
                                                Scene[] scenes){
        System.out.println("\n*** assignQuestionsToScenes called ***");
    }
    
    public static void assignItemsToScenes(InventoryItem[] items,
                                            Scene[] scenes){
        System.out.println("\n*** assignItemsToScenes called ***");
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] location = map.getLocations();
    

//        Brother Westensee and I worked toether and found that there was an
//        issue with adding this for next loop - we removed a huge amount of code
//        and replaced it with this two liner. Hopefully we will get to check it
//        out next week.

        for(Scene scene: scenes){
            double x = scene.getLocation().getX();
            int y = scene.getLocation().y;
            Location sceneLocation = location[(int)x][y];
            sceneLocation.setSceneType(scene);
            location[(int)x][y] = sceneLocation;
      
        }
    }    
//    public static int moveActorsToStartingLocation(Map map) {
//        // for every actor
//        Actor[] actors = Actor.values();
//        List<Actor> actors = GameControl.getActors();
//        for (Actor actor : actors) {
//            int returnValue = MapControl.moveActorToLocation(actor, actor.getCoordinates());
//            if (returnValue < 0) {
//                return returnValue;
//            }
//        }
//        return 0;
//
//    }
   
    
        
    
    public static void moveActorToLocation(Point playerCoordinates)
                            throws MapControlException{
        
        Map map = OregonTrailv2.getCurrentGame().getMap();
        int newRow = playerCoordinates.x-1;
        int newColumn = playerCoordinates.y-1;
        
        if (newRow < 0  || newRow >= map.getNoOfRows() ||
            newColumn < 0  || newColumn >= map.getNoOfColumns()) {
            throw new MapControlException("Cannot move player to location"
                    + playerCoordinates.x + ", " + playerCoordinates.y
                    + " because the location is outside"
                    + "the bounds of the map.");
        }
        
        
        
        // We can now move player to new location
        Location newLocation = map.getLocations()[newRow][newColumn];
        Point oldLocation = map.getPlayerCordinates();
        // mark new locations as visited on arrival  
        
        // check to see if the actor is in the current location
//        if (oldLocation != null) {
//            oldLocation.removePlayer player; // remove actor from old location
//        }
        
//        newLocation.addActor(actor); // add actor to new location
        playerCoordinates.x = newRow;
        playerCoordinates.y = newColumn; // set actor to new location
        newLocation.setVisited(true); // mark as a visted location
        
    }
    
    
    
    public static Location getLocation(Point coordinates) {
        System.out.println("*** getLocation() called");
        Location location = new Location();
        location.setRow(coordinates.x);
        location.setSceneType(new Scene(SceneGroup.regular, "You are in the ocean", "~~~", 0, true));
        location.setColumn(coordinates.y);
        return location;
    }
    
}