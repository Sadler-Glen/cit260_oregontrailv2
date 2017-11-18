/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;

/**
 *
 * @author adm-achina
 */
public class Location implements Serializable{
    
    
    // variables
    private int row;
    private int column;
    private boolean visited;
    private Scene scene;
    private Actor actor; // only one actor per location
    
    // default constructor function
    public Location() {
    }   
    
    public Location(int row, int column, Scene scene, Actor[] actors) {
    this.row = row;
    this.column = column;
    this.visited = false;
    this.scene = scene;
    this.actor = actor;
    }

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }    
    // getters and setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public Scene getScene() {
        return scene;
    }
    
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    public Actor getActor() {
        return actor;
    }
    
    public void setActor(Actor actor) {
        this.actor = actor;
    }

    // hashcode function
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.row;
        hash = 97 * hash + this.column;
        hash = 97 * hash + (this.visited ? 1 : 0);
        return hash;
    }

    // equals function
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        return true;
    }
    
    // toString function
    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + '}';
    }
    
}

    

