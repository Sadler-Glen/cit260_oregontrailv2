/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author sadss
 */
public class Game implements Serializable {

    // class instance variables
    private int noPeople;
    private double totalTime;
    private String climate;
    private InventoryItem[] inventory;
    private OccupationType[] occupation;
    private Map map; 
    private Player player;
    private List<Actor> actors = new ArrayList<Actor>(); // 1..* relationship
    private String startMonth;
    
    // constructor
    public Game() {
    }
    
    // getter and setter functions
    

    public int getNoPeople() {
        return noPeople;
    }

    public void setNoPeople(int noPeople) {
        this.noPeople = noPeople;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }
    
    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public OccupationType[] getOccupation() {
        return occupation;
    }

    public void setOccupation(OccupationType[] occupation) {
        this.occupation = occupation;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    




    @Override
    public String toString() {
        return "Game{" + "noPeople=" + noPeople + ", totalTime=" + totalTime + ", climate=" + climate + ", inventory=" + inventory + ", occupation=" + occupation + ", map=" + map + ", player=" + player + ", actors=" + actors + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.noPeople;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.climate);
        hash = 97 * hash + Arrays.deepHashCode(this.inventory);
        hash = 97 * hash + Arrays.deepHashCode(this.occupation);
        hash = 97 * hash + Objects.hashCode(this.map);
        hash = 97 * hash + Objects.hashCode(this.player);
        hash = 97 * hash + Objects.hashCode(this.actors);
        return hash;
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
        final Game other = (Game) obj;
        if (this.noPeople != other.noPeople) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (!Objects.equals(this.climate, other.climate)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventory, other.inventory)) {
            return false;
        }
        if (!Arrays.deepEquals(this.occupation, other.occupation)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        return true;
    }

}
