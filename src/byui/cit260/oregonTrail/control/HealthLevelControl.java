/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

/**
 *
 * @author Glen Sadler
 */
public class HealthLevelControl {

    public int evalHealthLevel(int days, int ration, int pace) {
        int health = 0;

        if (ration < 0 || ration > 3) { // ration range 1-3
            return -1;
        }

        if (pace < 0 || pace > 3) { // pace range 1-3
            return -1;
        }

        if (days < 0) {  // negative days
            return -1;
        }

        // Valid Cases
        if (days >= 1 && days <= 44 && ration >= 1 && ration <= 3 && pace >= 1 && pace <= 3) {
            return 3;
        }

        // days 45-89
        if (days >= 45 && days <= 89 && ration >= 1 && ration <= 3 && pace >= 1 && pace <= 3) {
            return 2;
        }

        //days 90 - 134
        if (days >= 90 && days <= 134 && ration >= 1 && ration <= 3 && pace >= 1 && pace <= 3) {
            return 1;
        }

        // days = 135
        if (days == 135 && ration >= 1 && ration <= 3 && pace >= 1 && pace <= 3) {
            return 0;
        }

        // Boundary Days
        if (days == 0 || days >= 136) {
            return -1;
        }
        return health;
    }
}
