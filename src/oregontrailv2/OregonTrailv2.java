/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrailv2;

//import byui.cit260.oregonTrail.model.Player;

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

    Inventory stock = new Inventory(); //Casper  
    
    stock.setStockType("honey");
    stock.setStockAmount(10);
    stock.setRequiredAmount(5);
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
