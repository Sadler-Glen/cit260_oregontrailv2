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
public class HealthLevelControl {
    public double calcRemainingFood (double noOfPeople, double noDaysTravelled, double rationType, double initialFood){
        double remainingFood;
        
        if (noOfPeople <1 || noDaysTravelled <0 ) {
            return -1;
        }
        
        if (initialFood > 2000 || initialFood < 1){
            return -1;
        }
        remainingFood = initialFood - (noOfPeople * noDaysTravelled * rationType);
                return remainingFood;
    }
    
}
