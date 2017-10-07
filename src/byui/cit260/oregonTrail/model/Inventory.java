/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Casper
 */
public class Inventory implements Serializable  {

    public Inventory() {
    }
    
// class instance variables
private String stockType;
private int requiredAmount;
private int stockAmount;
private String stockPoint;

    // relationship instance variables
    private Player player;
    private Game game;

    public Game getGame() {   //1..1 relationship
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    
    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getStockPoint() {
        return stockPoint;
    }

    public void setStockPoint(String stockPoint) {
        this.stockPoint = stockPoint;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.stockType);
        hash = 71 * hash + this.requiredAmount;
        hash = 71 * hash + this.stockAmount;
        hash = 71 * hash + Objects.hashCode(this.stockPoint);
        return hash;
    }

    @Override
    public String toString() {
        return "Inventory{" + "stockType=" + stockType + ", requiredAmount=" + requiredAmount + ", stockAmount=" + stockAmount + ", stockPoint=" + stockPoint + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inventory other = (Inventory) obj;
        if (this.requiredAmount != other.requiredAmount) {
            return false;
        }
        if (this.stockAmount != other.stockAmount) {
            return false;
        }
        if (!Objects.equals(this.stockType, other.stockType)) {
            return false;
        }
        if (!Objects.equals(this.stockPoint, other.stockPoint)) {
            return false;
        }
        return true;
    }
    

}
