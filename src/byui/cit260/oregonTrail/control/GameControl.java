/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.model.Player;
import byui.cit260.oregonTrail.view.GameMenuView;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author EQUIPO
 */
public class GameControl {



public static Player createPlayer(String name){

    if(name == null){
        return null;
    }
    Player player = new Player();
    player.setName(name);
    
    OregonTrailv2.setPlayer(player); // save the player
  
    return player;
}    

    public static void createNewGame(Player player) {
        System.out.println("\n*** createNewGame stub function called ***");
    }
}
