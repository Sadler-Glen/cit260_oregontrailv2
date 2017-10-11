
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrailv2;

import byui.cit260.oregonTrail.model.Actor;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.Player;

import byui.cit260.oregonTrail.model.Inventory;
import byui.cit260.oregonTrail.model.LandMark;



/**
 *
 * @author sadss
 */
public class OregonTrailv2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // 4.a create a new instance of the Player class (Glen Sadler)
        Player playerOne = new Player();
        
        /* 4.b assign values to each of the Player class instance variables
        using the "setter" method (Glen Sadler)
        */
        playerOne.setName("John Lennon");
        playerOne.setOccupation("Banker");
        playerOne.setPlayerHealth(3);
        
        /* 4.c call the tostring() function to display the contents of the Player
        class instance variables assigned in 4.b (Glen Sadler)
        Note: either of the following lines will call the toString. The toString()
        is implicit and therefore can be omitted.
        */
        //System.out.println(playerOne.toString());
        System.out.println(playerOne);

        // 4.a create a new instance of the Game class (Glen Sadler)       
        Game gameOne = new Game();       

        /* 4.b assign values to each of the Game class instance variables
        using the "setter" method (Glen Sadler)
        */
        gameOne.setNoPeople(5);
        gameOne.setTotalTime(24);
        gameOne.setClimate("Warm");

        /* 4.c call the tostring() function to display the contents of the Game
        class instance variables assigned as above (Glen Sadler)
        Note: either of the following lines will call the toString. The toString()
        is implicit and therefore can be omitted.
        */        
        //System.out.println(gameOne.toString());
        System.out.println(gameOne);
        
        // 4.a create a new instance of the Actor class (Glen Sadler)         
        Actor actorOne = new Actor();        

        /* 4.b assign values to each of the Actor class instance variables
        using the "setter" method (Glen Sadler)
        */
        actorOne.setName("John");
        actorOne.setHealth(3);        

        /* 4.c call the tostring() function to display the contents of the Actor
        class instance variables assigned as above (Glen Sadler)
        Note: either of the following lines will call the toString. The toString()
        is implicit and therefore can be omitted.
        */           
        //System.out.println(actorOne.toString());
        System.out.println(actorOne);
        
    Inventory stock = new Inventory(); //Casper  
    
    stock.setStockType("honey");
    stock.setRequiredAmount(5);
    stock.setStockAmount(10);
    stock.setStockPoint("Missouri");
    
    System.out.println(stock);
    
    
    LandMark feature = new LandMark();  //Casper
    
    feature.setDescription("Settlement");
    feature.setTravelTime(7);
    feature.setBlockedLocation(false);
    feature.setDisplaySymbol("open");
    
    System.out.println(feature);
    }
    
}
