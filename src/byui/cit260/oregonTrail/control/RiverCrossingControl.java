/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.exceptions.RiverCrossingControlException;
import java.io.Serializable;

/**
 *
 * @author Casper
 */
public class RiverCrossingControl  implements Serializable{

    public void riverCrossing(int river, int crossingType) throws RiverCrossingControlException{
        int success = 1;

        if (river == 2 && crossingType == 1) {
            throw new RiverCrossingControlException("Failed to cross"); 
        }

        if (river == 3 && crossingType == 1) {
            throw new RiverCrossingControlException("Failed to cross"); 
        }

        if (river == 3 && crossingType == 2) {
            throw new RiverCrossingControlException("Failed to cross"); 
        }

        if (river == 1 && crossingType == 1 - 4) {
            throw new RiverCrossingControlException("Failed to cross"); 
        }      
    }
}
