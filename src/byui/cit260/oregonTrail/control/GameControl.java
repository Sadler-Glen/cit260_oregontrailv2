/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.exceptions.GameControlException;
import byui.cit260.oregonTrail.model.Actor;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.ItemType;
import byui.cit260.oregonTrail.model.Location;
import byui.cit260.oregonTrail.model.LocationType;
import byui.cit260.oregonTrail.model.Map;
import byui.cit260.oregonTrail.model.OccupationType;
import byui.cit260.oregonTrail.model.Occupation;
import byui.cit260.oregonTrail.model.Pace;
import byui.cit260.oregonTrail.model.PaceType;
import byui.cit260.oregonTrail.model.Player;
import byui.cit260.oregonTrail.model.Ration;
import byui.cit260.oregonTrail.model.RationType;
import byui.cit260.oregonTrail.model.Weather;
import byui.cit260.oregonTrail.model.WeatherType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author Glen Sadler
 */
public class GameControl implements Serializable{

    private static List<Actor> actors = new ArrayList<>();
    private static double fundAmount = 0;
    private static Date startDate;
    private static double initFunds = 0;
    private static double totalBill = 0;
    private static String occupation = null;
    private static String weather = null;
    private static String pace = null;
    private static String ration = null;
    private static String health = null;

    public static Player createPlayer(String name) {

        if (name == null) {
            return null;
        }
        Player player = new Player();
        player.setName(name);

        OregonTrailv2.setPlayer(player); // save the player

        return player;
    }
    
    public static double getInitFunds() {
        return initFunds;
    }

    public static void setInitFunds(double initFunds) {
        GameControl.initFunds = initFunds;
    }

    public static double getTotalBill() {
        return totalBill;
    }

    public static void setTotalBill(double totalBill) {
        GameControl.totalBill = totalBill;
    }

    public static String getOccupation() {
        return occupation;
    }

    public static void setOccupation(String occupation) {
        GameControl.occupation = occupation;
    }

    public static String getWeather() {
        return weather;
    }

    public static void setWeather(String weather) {
        GameControl.weather = weather;
    }

    public static String getPace() {
        return pace;
    }

    public static void setPace(String pace) {
        GameControl.pace = pace;
    }

    public static String getRation() {
        return ration;
    }

    public static void setRation(String ration) {
        GameControl.ration = ration;
    }

    public static String getHealth() {
        return health;
    }

    public static void setHealth(String health) {
        GameControl.health = health;
    }

    
    
    
    /**
     * Add array for wagon party
     */
    public static int createActor(Actor actor) {
        //Check if the actor is valid        
        if (isActorValid(actor)) {
            //add actor to actors list
            actors.add(actor);
            return +1;
        }
        //if actor is not valid then display to user 
        //an invalid actor message and return to getPartyList()    
        System.out.println("\n*** Invalid actor " + actor.toString() + "***");
        return -1;
    }
    
    public static List<Actor> getActors() {
        return actors;
    }

    public static void setActors(List<Actor> actors) {
        GameControl.actors = actors;
    }

    private static boolean isActorValid(Actor actor) {
        if (actor == null) {
            return false;
        }
        if (actor.getName() == null) {
            return false;
        }
        return true;
    }

    public static double getFundAmount() {
        return fundAmount;
    }

    public static void setFundAmount(double fundAmount) {
        GameControl.fundAmount = fundAmount;
    }

    public static Date getStartDate() {
        return startDate;
    }

    public static void setStartDate(Date startDate) {
        GameControl.startDate = startDate;
    }






    public static void createNewGame(Player player) {
        Game game = new Game(); // create new game
        OregonTrailv2.setCurrentGame(game); // save in OregonTrailv2

        game.setPlayer(player); // save player in game

        //System.out.println("\n*** new game started ***");
        // create the inventory list and save in the game
        InventoryItem[] inventoryList = GameControl.createItems();
        game.setInventory(inventoryList);

        //System.out.println("\n*** inventory list created ***");
        Map map = MapControl.createMap(); // create and initialize new map
        game.setMap(map); // save map in game
        
        List<Actor> actor = GameControl.getActors();
        game.setActors(actors);
        
        game.setStartDate(null);
        
        

        //System.out.println("\n*** map created ***");
    }

    public static InventoryItem[] createItems() {
        // create array(list) of InventoryItem items

        InventoryItem[] inventory = new InventoryItem[7];

        InventoryItem oxen = new InventoryItem();
        oxen.setDescription(ItemType.Oxen.name());
        oxen.setQuantityInStock(0);
        oxen.setRequiredAmount(0);
        oxen.setCost(40.00);
        inventory[ItemType.Oxen.ordinal()] = oxen;

        InventoryItem food = new InventoryItem();
        food.setDescription(ItemType.Food.name());
        food.setQuantityInStock(0);
        food.setRequiredAmount(0);
        food.setCost(00.20);
        inventory[ItemType.Food.ordinal()] = food;

        InventoryItem clothing = new InventoryItem();
        clothing.setDescription(ItemType.Clothing.name());
        clothing.setQuantityInStock(0);
        clothing.setRequiredAmount(0);
        clothing.setCost(10.00);
        inventory[ItemType.Clothing.ordinal()] = clothing;

        InventoryItem ammunition = new InventoryItem();
        ammunition.setDescription(ItemType.Ammunition.name());
        ammunition.setQuantityInStock(0);
        ammunition.setRequiredAmount(0);
        ammunition.setCost(2.00);
        inventory[ItemType.Ammunition.ordinal()] = ammunition;

        InventoryItem wheel = new InventoryItem();
        wheel.setDescription(ItemType.Wheel.name());
        wheel.setQuantityInStock(0);
        wheel.setRequiredAmount(0);
        wheel.setCost(10.00);
        inventory[ItemType.Wheel.ordinal()] = wheel;

        InventoryItem axle = new InventoryItem();
        axle.setDescription(ItemType.Axle.name());
        axle.setQuantityInStock(0);
        axle.setRequiredAmount(0);
        axle.setCost(10.00);
        inventory[ItemType.Axle.ordinal()] = axle;

        InventoryItem tongue = new InventoryItem();
        tongue.setDescription(ItemType.Tongue.name());
        tongue.setQuantityInStock(0);
        tongue.setRequiredAmount(0);
        tongue.setCost(10.00);
        inventory[ItemType.Tongue.ordinal()] = tongue;

        return inventory;
    }

    public static Occupation[] createOccupation() {
        // create array list of OccupationType types
        Occupation[] occupation = new Occupation[3];

        Occupation banker = new Occupation();
        banker.setDescription("Banker");
        banker.setFundAmount(1600);
        occupation[OccupationType.Banker.ordinal()] = banker;

        Occupation carpenter = new Occupation();
        carpenter.setDescription("Carpenter");
        carpenter.setFundAmount(800);
        occupation[OccupationType.Carpenter.ordinal()] = carpenter;

        Occupation farmer = new Occupation();
        farmer.setDescription("Farmer");
        farmer.setFundAmount(400);
        occupation[OccupationType.Farmer.ordinal()] = farmer;

        return occupation;
    }
    
    public static Ration[] createRation(){
        // create array list of Ration types
        Ration[] rationSize = new Ration[3];
        
        Ration Filling = new Ration();
        Filling.setDescription("Filling");
        Filling.setSize(3);
        rationSize[RationType.Filling.ordinal()] = Filling;
        
        
        Ration Meagre = new Ration();
        Meagre.setDescription("Meagre");
        Meagre.setSize(2);
        rationSize[RationType.Meagre.ordinal()] = Meagre;
        
        Ration BareBones = new Ration();
        BareBones.setDescription("Meagre");
        BareBones.setSize(2);
        rationSize[RationType.BareBones.ordinal()] = BareBones;
        
        return rationSize;
        
    }
    
//        public static Location[] createLocation(){
//        // create array list of Ration types
//        Location[] location = new Location[18];
//        
//        Location Independence = new Location();
//        Independence.setDescription("Independence");
//        Independence.setRow(18);
//        Independence.setColumn(20);
//        Independence.setVisited(false);
//        Independence.setDistanceTravelled(0);
//        location[LocationType.Independence.ordinal()] = Independence;
//        
//        Location KansasRiverCrossing = new Location();
//        KansasRiverCrossing.setDescription("Kansas River Crossing");
//        KansasRiverCrossing.setRow(15);
//        KansasRiverCrossing.setColumn(20);
//        KansasRiverCrossing.setVisited(false);
//        KansasRiverCrossing.setDistanceTravelled(102);
//        location[LocationType.KansasRiverCrossing.ordinal()] = KansasRiverCrossing;
//        
//        Location BigBlueRiverCrossing = new Location();
//        BigBlueRiverCrossing.setDescription("Big Blue River Crossing");
//        BigBlueRiverCrossing.setRow(8);
//        BigBlueRiverCrossing.setColumn(19);
//        BigBlueRiverCrossing.setVisited(false);
//        BigBlueRiverCrossing.setDistanceTravelled(185);
//        location[LocationType.BigBlueRiverCrossing.ordinal()] = BigBlueRiverCrossing;
//        
//        Location FortKearney = new Location();
//        FortKearney.setDescription("Fort Kearney");
//        FortKearney.setRow(10);
//        FortKearney.setColumn(17);
//        FortKearney.setVisited(false);
//        FortKearney.setDistanceTravelled(304);
//        location[LocationType.FortKearney.ordinal()] = FortKearney;
//        
//        Location ChimneyRock = new Location();
//        ChimneyRock.setDescription("Chimney Rock");
//        ChimneyRock.setRow(15);
//        ChimneyRock.setColumn(16);
//        ChimneyRock.setVisited(false);
//        ChimneyRock.setDistanceTravelled(554);
//        location[LocationType.ChimneyRock.ordinal()] = ChimneyRock;
//        
//        Location FortLaramie = new Location();
//        FortLaramie.setDescription("Fort Laramie");
//        FortLaramie.setRow(16);
//        FortLaramie.setColumn(13);
//        FortLaramie.setVisited(false);
//        FortLaramie.setDistanceTravelled(640);
//        location[LocationType.FortLaramie.ordinal()] = FortLaramie;
//        
//        Location IndependenceRock = new Location();
//        IndependenceRock.setDescription("Independence Rock");
//        IndependenceRock.setRow(11);
//        IndependenceRock.setColumn(13);
//        IndependenceRock.setVisited(false);
//        IndependenceRock.setDistanceTravelled(830);
//        location[LocationType.IndependenceRock.ordinal()] = IndependenceRock;
//        
//        Location SouthPass = new Location();
//        SouthPass.setDescription("South Pass");
//        SouthPass.setRow(8);
//        SouthPass.setColumn(11);
//        SouthPass.setVisited(false);
//        SouthPass.setDistanceTravelled(932);
//        location[LocationType.SouthPass.ordinal()] = SouthPass;
//        
//        Location FortBridger = new Location();
//        FortBridger.setDescription("Fort Bridger");
//        FortBridger.setRow(5);
//        FortBridger.setColumn(9);
//        FortBridger.setVisited(false);
//        FortBridger.setDistanceTravelled(1057);
//        location[LocationType.FortBridger.ordinal()] = FortBridger;
//        
//        Location SodaSprings = new Location();
//        SodaSprings.setDescription("Soda Springs");
//        SodaSprings.setRow(9);
//        SodaSprings.setColumn(8);
//        SodaSprings.setVisited(false);
//        SodaSprings.setDistanceTravelled(1219);
//        location[LocationType.SodaSprings.ordinal()] = SodaSprings;
//        
//        Location FortHall = new Location();
//        FortHall.setDescription("Fort Hall");
//        FortHall.setRow(15);
//        FortHall.setColumn(7);
//        FortHall.setVisited(false);
//        FortHall.setDistanceTravelled(1277);
//        location[LocationType.FortHall.ordinal()] = FortHall;
//        
//        Location SnakeRiverCrossing = new Location();
//        SnakeRiverCrossing.setDescription("Snake River Crossing");
//        SnakeRiverCrossing.setRow(18);
//        SnakeRiverCrossing.setColumn(4);
//        SnakeRiverCrossing.setVisited(false);
//        SnakeRiverCrossing.setDistanceTravelled(1458);
//        location[LocationType.SnakeRiverCrossing.ordinal()] = SnakeRiverCrossing;
//        
//        Location FortBoise = new Location();
//        FortBoise.setDescription("FortB oise");
//        FortBoise.setRow(19);
//        FortBoise.setColumn(1);
//        FortBoise.setVisited(false);
//        FortBoise.setDistanceTravelled(1572);
//        location[LocationType.FortBoise.ordinal()] = FortBoise;
//        
//        Location BlueMountains = new Location();
//        BlueMountains.setDescription("Blue Mountains");
//        BlueMountains.setRow(15);
//        BlueMountains.setColumn(0);
//        BlueMountains.setVisited(false);
//        BlueMountains.setDistanceTravelled(1732);
//        location[LocationType.BlueMountains.ordinal()] = BlueMountains;
//        
//        Location FortWallaWalla = new Location();
//        FortWallaWalla.setDescription("Fort Walla Walla");
//        FortWallaWalla.setRow(12);
//        FortWallaWalla.setColumn(3);
//        FortWallaWalla.setVisited(false);
//        FortWallaWalla.setDistanceTravelled(1787);
//        location[LocationType.FortWallaWalla.ordinal()] = FortWallaWalla;
//        
//        Location TheDalles = new Location();
//        TheDalles.setDescription("The Dalles");
//        TheDalles.setRow(9);
//        TheDalles.setColumn(4);
//        TheDalles.setVisited(false);
//        TheDalles.setDistanceTravelled(1907);
//        location[LocationType.TheDalles.ordinal()] = TheDalles;
//        
//        Location BarlowTollRoad = new Location();
//        BarlowTollRoad.setDescription("BarlowTollRoad");
//        BarlowTollRoad.setRow(4);
//        BarlowTollRoad.setColumn(6);
//        BarlowTollRoad.setVisited(false);
//        BarlowTollRoad.setDistanceTravelled(2007);
//        location[LocationType.BarlowTollRoad.ordinal()] = BarlowTollRoad;
//        
//        Location WillametteValley = new Location();
//        WillametteValley.setDescription("WillametteValley");
//        WillametteValley.setRow(1);
//        WillametteValley.setColumn(0);
//        WillametteValley.setVisited(false);
//        WillametteValley.setDistanceTravelled(2107);
//        location[LocationType.WillametteValley.ordinal()] = WillametteValley;
//
//        return location;
//            
//        }
        
        public static Pace[] createPace(){
        // create array list of Ration types
        Pace[] pace = new Pace[3];
        
        Pace Steady = new Pace();
        Steady.setDescription("Steady");
        Steady.setHoursTravelPerDay(8);
        pace[PaceType.Steady.ordinal()] = Steady;
        
        Pace Strenuous = new Pace();
        Strenuous.setDescription("Strenuous");
        Strenuous.setHoursTravelPerDay(12);
        pace[PaceType.Strenuous.ordinal()] = Strenuous;
        
        Pace Gruelling = new Pace();
        Gruelling.setDescription("Gruelling");
        Gruelling.setHoursTravelPerDay(16);
        pace[PaceType.Gruelling.ordinal()] = Gruelling;
        
        return pace;
        
        }
        
        
        public static Weather[] createWeather(){
        // create array list of Ration types
        Weather[] weather = new Weather[6];
        
        Weather Hot = new Weather();
        Hot.setDescription("Hot");
        weather[WeatherType.Hot.ordinal()] = Hot;
        
        Weather Warm = new Weather();
        Warm.setDescription("Warm");
        weather[WeatherType.Warm.ordinal()] = Warm;
        
        Weather Fair = new Weather();
        Fair.setDescription("Fair");
        weather[WeatherType.Fair.ordinal()] = Fair;
        
        Weather Cool = new Weather();
        Cool.setDescription("Cool");
        weather[WeatherType.Cool.ordinal()] = Cool;
        
        Weather Cold = new Weather();
        Cold.setDescription("Cold");
        weather[WeatherType.Cold.ordinal()] = Cold;
        
        Weather Freezing = new Weather();
        Freezing.setDescription("Freezing");
        weather[WeatherType.Freezing.ordinal()] = Freezing;
        
        return weather;
        }
        
    public static Location[][] getMapLocations() {
        return OregonTrailv2.getCurrentGame().getMap().getLocations();
    }
    //function to sort Inventory by description - Glen Sadler 

    public static InventoryItem[] getSortedInventoryListDescription() {

        // get inventory list for the current game
        InventoryItem[] originalInventoryList
                = OregonTrailv2.getCurrentGame().getInventory();

        // make a copy of orignalList
        InventoryItem[] inventoryList = originalInventoryList.clone();

        // using a BubbleSort to sort the list of inventoryList by description
        InventoryItem tempInventoryItem;
        for (int i = 0; i < inventoryList.length - 1; i++) {
            for (int j = 0; j < inventoryList.length - 1 - i; j++) {
                if (inventoryList[j].getDescription().
                        compareToIgnoreCase(inventoryList[j + 1].getDescription()) > 0) {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j + 1];
                    inventoryList[j + 1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }   // function to sort by Inventory item cost
    //THIS FUNCTION CREATED BY IGNACIO

    public static InventoryItem[] getSortedInventoryListCost() {

        // get inventory list for the current game
        InventoryItem[] originalInventoryList
                = OregonTrailv2.getCurrentGame().getInventory();

        // make a copy of orignalList
        InventoryItem[] inventoryList = originalInventoryList.clone();

        // using a BubbleSort to sort the list of inventoryList by cost
        InventoryItem tempInventoryItem;
        for (int i = 0; i < inventoryList.length - 1; i++) {
            for (int j = 0; j < inventoryList.length - 1 - i; j++) {
                if (inventoryList[j + 1].getCost() < inventoryList[j].getCost()) {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j + 1];
                    inventoryList[j + 1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }
    //function to sort inventory by quantity in stock - Glen Sadler 

    public static InventoryItem[] getSortedInventoryListInStock() {

        // get inventory list for the current game
        InventoryItem[] originalInventoryList
                = OregonTrailv2.getCurrentGame().getInventory();

        // make a copy of orignalList
        InventoryItem[] inventoryList = originalInventoryList.clone();

        // using a BubbleSort to sort the list of inventoryList by cost
        InventoryItem tempInventoryItem;
        for (int i = 0; i < inventoryList.length - 1; i++) {
            for (int j = 0; j < inventoryList.length - 1 - i; j++) {
                if (inventoryList[j + 1].getQuantityInStock() < inventoryList[j].getQuantityInStock()) {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j + 1];
                    inventoryList[j + 1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }
    
    public static void saveGame(Game game, String filePath)
            throws GameControlException {
        try( FileOutputStream fops = new FileOutputStream(filePath)){
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game);// write the game object out to file
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }
    
    public static void getSavedGame(String filePath)
            throws GameControlException {
        Game game = null;
        
    try (FileInputStream fips = new FileInputStream(filePath)) {
        ObjectInputStream input = new ObjectInputStream(fips);
        
        game = (Game) input.readObject(); // read the game object from file
    }
    catch(Exception e) {
            throw new GameControlException(e.getMessage());
    }
    
    // close the output file
    OregonTrailv2.setCurrentGame(game);
    }
}
