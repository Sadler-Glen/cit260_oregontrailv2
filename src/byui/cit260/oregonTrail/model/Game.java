/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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

    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public OccupationType[] getOccupation() {
        return occupation;
    }

//    public void setOccupation(OccupationType[] occupation) {
//        this.occupation = occupation;
//    }

    // relationship instance variables
    private Player player;
    private ArrayList<Actor> actors = new ArrayList<Actor>(); // 1..* relationship

    // constructor
    public Game() {
    }

    // getter and setter functions
    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.noPeople;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.climate);
        hash = 47 * hash + Arrays.deepHashCode(this.inventory);
        hash = 47 * hash + Objects.hashCode(this.map);
        hash = 47 * hash + Objects.hashCode(this.player);
        hash = 47 * hash + Objects.hashCode(this.actors);
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

    @Override
    public String toString() {
        return "Game{" + "noPeople=" + noPeople + ", totalTime=" + totalTime + ", climate=" + climate + ", inventory=" + inventory + ", map=" + map + ", player=" + player + ", actors=" + actors + '}';
    }

}
