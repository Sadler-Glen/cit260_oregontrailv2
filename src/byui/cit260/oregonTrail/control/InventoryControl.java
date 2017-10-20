/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import java.util.ArrayList;
import java.util.Scanner;
 
 
/**
*
* @author Ignacio
*/
public class InventoryControl {
    public int calcRemainingFunds(int initFunds, int totalBill, int remainingFunds,
            int oxen, int food, int ammo, int wheel, int axle, int tongue ){
      
        if(initFunds < 0 || initFunds > 1600 ){
            return -1;
        }
        if(oxen > 8 || oxen < 0){
            return -1;
        }
        if(food > 2000 || food <0) {
            return -1;
        }
        if(ammo > 10 || ammo <0) {
               return -1;
        }
        if(wheel > 3 || wheel <0) {
            return -1;
        }
        if(axle > 3 || axle <0) {
            return -1;
        }
        if (tongue > 3 ||tongue <0) {
            return -1;
        }
        remainingFunds=initFunds-totalBill;
        return remainingFunds;
             
    }
}