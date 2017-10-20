/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

/**
 *
 * @author Glen Sadler (Team Members Casper, Ignacio, Felix, and Glen
 */
public class FoodControl {
    public double calcRemainingFood(double noOfPeople, double noDaysTravelled, 
        
            double rationType, double initialFood){
        double remainingFood;
        if(noOfPeople < 1 || noDaysTravelled < 0  || initialFood < 0){ // test for invalid cases
            return -1;
        }
        if(initialFood == 0 || initialFood > 2000 ){ // test for boundary cases
            return -1;
        } else {
        }
        remainingFood = initialFood - (noOfPeople * noDaysTravelled * rationType);
        
        return remainingFood;
    }    
}
