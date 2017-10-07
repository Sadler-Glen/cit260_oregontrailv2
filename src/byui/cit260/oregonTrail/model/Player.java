/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author sadss
 */
public class Player implements Serializable {
    
    // class instance variables
    private String name;
    private String occupation;
    private int playerHealth;
    
    // relationship instances
    private ArrayList<Game> games = new ArrayList<Game>();
    private ArrayList<Hunt> hunts = new ArrayList<Hunt>();
    private ArrayList<RandomEvent> events = new ArrayList<RandomEvent>();
    private ArrayList<Trade> trades = new ArrayList<Trade>();
    
    public Player() {
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<Hunt> getHunts() {
        return hunts;
    }

    public void setHunts(ArrayList<Hunt> hunts) {
        this.hunts = hunts;
    }

    public ArrayList<RandomEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<RandomEvent> events) {
        this.events = events;
    }

    public ArrayList<Trade> getTrades() {
        return trades;
    }

    public void setTrades(ArrayList<Trade> trades) {
        this.trades = trades;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.occupation);
        hash = 67 * hash + this.playerHealth;
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", occupation=" + occupation + ", playerHealth=" + playerHealth + '}';
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
        final Player other = (Player) obj;
        if (this.playerHealth != other.playerHealth) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.occupation, other.occupation)) {
            return false;
        }
        return true;
    }
    
    
}
