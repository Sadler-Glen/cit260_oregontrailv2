/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.exceptions.InventoryControlException;
import byui.cit260.oregonTrail.model.ItemType;
import byui.cit260.oregonTrail.view.GeneralStoreView;


/**
 *
 * @author Ignacio
 */
public class InventoryControl {

    public void check(InventoryControl Oxenquantity){
        
    }    
    public int quantityPass;
    
        

    public static void checkInventoryLimits(/*int oxen, int food, int clothing, int ammo, int wheel, int axle, int tongue*/)
            throws InventoryControlException {

        if ( oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock()  > 8 
                || oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock() < 0) {
            throw new InventoryControlException("Oxen out of range: >0 and <= 8");
        }
        if (oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock() > 2000 
                || oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock() < 0) {
            throw new InventoryControlException("Food out of range: > 0lbs and <= 2000lbs");
        }

        if (oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock()  < 0) {
            throw new InventoryControlException("Clothiing out of range: >0 items");
        }
        if (oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock()  > 10 
                || oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock()  < 0) {
            throw new InventoryControlException("Ammunition out of range: > 0 boxes and <= 10 boxes");
        }
        if (oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock()  > 3 
                || oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock()  < 0) {
            throw new InventoryControlException("Wheels out of range: > 0 wheels and <= 3 wheels");
        }
        if (oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock()  > 3 
                || oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock()  < 0) {
            throw new InventoryControlException("Axles out of range: > 0 axles and <= 3 axles");
        }
        if (oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock()  > 3 
                || oregontrailv2.OregonTrailv2.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock()  < 0) {
            throw new InventoryControlException("Tongues out of range: > 0 tongues or <= 3 togues");
        }
    }
}
