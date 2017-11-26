/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.model.Actor;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.ItemType;
import byui.cit260.oregonTrail.model.Location;
import byui.cit260.oregonTrail.model.Map;
import byui.cit260.oregonTrail.model.Occupation;
import byui.cit260.oregonTrail.model.OccupationType;
import byui.cit260.oregonTrail.model.Player;
import java.util.ArrayList;
import java.util.List;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author Glen Sadler
 */
public class GameControl {

    private static List<Actor> actors = new ArrayList<>();
    private static double fundAmount = 0;
    private static String startMonth = null;
    private static double initFunds = 0;
    private static double totalBill = 0;

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

    public static String getStartMonth() {
        return startMonth;
    }

    public static void setStartMonth(String startMonth) {
        GameControl.startMonth = startMonth;
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

    public static OccupationType[] createOccupation() {
        // create array list of OccupationType types
        OccupationType[] occupation = new OccupationType[3];

        OccupationType banker = new OccupationType();
        banker.setDescription("Banker");
        banker.setFundAmount(1600);
        occupation[Occupation.Banker.ordinal()] = banker;

        OccupationType carpenter = new OccupationType();
        carpenter.setDescription("Carpenter");
        carpenter.setFundAmount(800);
        occupation[Occupation.Carpenter.ordinal()] = carpenter;

        OccupationType farmer = new OccupationType();
        farmer.setDescription("Farmer");
        farmer.setFundAmount(400);
        occupation[Occupation.Farmer.ordinal()] = farmer;

        return occupation;
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
}
