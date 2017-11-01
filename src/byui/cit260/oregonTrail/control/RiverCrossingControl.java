/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

/**
 *
 * @author Casper
 */
public class RiverCrossingControl {
    public int riverCrossing (int river, int crossingType) {
        int success = 1;
        
        if (river == 2 && crossingType == 1) {
            return -1;
        }
        
        if (river == 3 && crossingType == 1){
            return -1;
        }
        
        if (river == 3 && crossingType == 2){
            return -1;
        }
        
        if (river == 1 && crossingType == 1 - 4){
            return 1;
        }
        
        return success;
    }    
}
