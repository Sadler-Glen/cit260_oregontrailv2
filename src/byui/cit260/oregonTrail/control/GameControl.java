/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.model.Actor;
import byui.cit260.oregonTrail.model.Player;
import byui.cit260.oregonTrail.view.GameMenuView;
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
    private static double oxen = 0;
    private static double food = 0;
    private static double clothing = 0;
    private static double ammo = 0;
    private static double wheel = 0;
    private static double axle = 0;
    private static double tongue = 0;
    
    
    public static Player createPlayer(String name){

        if(name == null){
            return null;
        }
        Player player = new Player();
        player.setName(name);

        OregonTrailv2.setPlayer(player); // save the player

        return player;
    }

    /**
     * Add array for wagon party
     */
    public static int createActor(Actor actor){
        //Check if the actor is valid        
        if(isActorValid(actor)){
            //add actor to actors list
            actors.add(actor);
            return +1;
        }
        //if actor is not valid then display to user 
        //an invalid actor message and return to getPartyList()    
        System.out.println("\n*** Invalid actor "+ actor.toString()+"***");
        return -1;
    }

    public static List<Actor> getActors() {
        return actors;
    }
    
    private static boolean isActorValid(Actor actor){
        if(actor == null){
            return false;
        }
        if(actor.getName() == null){
            return false;
        }
        return true;
    }

    public static void createNewGame(Player player) {
        System.out.println("\n*** createNewGame stub function called ***");
    }

    public static double getFundAmount() {
        fundAmount = (fundAmount * 100)/100.0;
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

    public static double getOxen() {
        return oxen;
    }

    public static void setOxen(double oxen) {
        GameControl.oxen = oxen;
    }

    public static double getFood() {
        return food;
    }

    public static void setFood(double food) {
        GameControl.food = food;
    }

    public static double getClothing() {
        return clothing;
    }

    public static void setClothing(double clothing) {
        GameControl.clothing = clothing;
    }

    
    public static double getAmmo() {
        return ammo;
    }

    public static void setAmmo(double ammo) {
        GameControl.ammo = ammo;
    }

    public static double getWheel() {
        return wheel;
    }

    public static void setWheel(double wheel) {
        GameControl.wheel = wheel;
    }

    public static double getAxle() {
        return axle;
    }

    public static void setAxle(double axle) {
        GameControl.axle = axle;
    }

    public static double getTongue() {
        return tongue;
    }

    public static void setTongue(double tongue) {
        GameControl.tongue = tongue;
    }
    
}
