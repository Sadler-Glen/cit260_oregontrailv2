
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrailv2;

import byui.cit260.oregonTrail.model.Actor;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.Hunt;
import byui.cit260.oregonTrail.model.Player;

import byui.cit260.oregonTrail.model.Inventory;
import byui.cit260.oregonTrail.model.LandMark;
import byui.cit260.oregonTrail.model.RandomEvent;
import byui.cit260.oregonTrail.model.Trade;
import byui.cit260.oregonTrail.view.StartProgramView;



/**
 *
 * @author sadss
 */
public class OregonTrailv2 {
    
    private static Game currentGame = null;
    private static Player player = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // create StartProgramViewOrig and display the start program
       StartProgramView startProgramView = new StartProgramView();
       startProgramView.displayStartProgramView();
    }

    public static Player getPlayer(){
        return player;
    }
    public static void setPlayer(Player player) {
        System.out.println("\n*** setPlayer() function called ***");
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        OregonTrailv2.currentGame = currentGame;
    }
    
    
    
}
