/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrailv2;

import byui.cit260.oregonTrail.model.Actor;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.Player;


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
        */
        System.out.println(playerOne.toString());

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
        */        
        System.out.println(gameOne.toString());
        
        // 4.a create a new instance of the Actor class (Glen Sadler)         
        Actor actorOne = new Actor();        

        /* 4.b assign values to each of the Actor class instance variables
        using the "setter" method (Glen Sadler)
        */
        actorOne.setName("John");
        actorOne.setHealth(3);        

        /* 4.c call the tostring() function to display the contents of the Actor
        class instance variables assigned as above (Glen Sadler)
        */           
        System.out.println(actorOne.toString());  
    }
    
}
