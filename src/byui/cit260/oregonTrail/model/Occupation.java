/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

/**
 *
 * @author sadss
 */
public enum Occupation {
    Banker("Banker", 1600),
    Carpenter("Carpenter", 800),
    Farmer ("Farmer", 400);
    
    private final String desc;
    private final int funds;
    
    Occupation(String description, int fundAmount) {
        desc = description;
        funds = fundAmount;
    }

    public String getDesc() {
        return desc;
    }

    public int getFunds() {
        return funds;
    }
    
    
}
