/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author adm-achina
 */
public class Location implements Serializable {

    // variables
    private String description;
    private int row;
    private int column;
    private boolean visited;
    private Scene sceneType;
    private int distanceTravelled;
    private ArrayList<Actor> actors;

    // default constructor function
    public Location() {
    }

    public Location(int row, int column) {
        this.actors = new ArrayList<Actor>();
    }
    
    public Location(String decription, int row, int column, boolean visited, Scene scene, int distanceTravelled, ArrayList<Actor> actors) {
        this.description = "";
        this.row = row;
        this.column = column;
        this.visited = false;
        this.sceneType = sceneType;
        this.distanceTravelled = 0;
        this.actors = actors;
    }

    public void Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // getters and setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
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

    public Scene getSceneType() {
        return sceneType;
    }

    public void setSceneType(Scene sceneType) {
        this.sceneType = sceneType;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }
    
    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
    
        public void removeActor(Actor actor) {
        if (actor == null) {
            return;
        }
        this.actors.remove(actor);
    }
    
        
    public void addActor(Actor actor) {
        if (actor == null || this.actors.contains(actor)) {
            return;
        }
            
        this.actors.add(actor);
    }

    @Override
    public String toString() {
        return "Location{" + "description=" + description + ", row=" + row + ", column=" + column + ", visited=" + visited + ", sceneType=" + sceneType + ", distanceTravelled=" + distanceTravelled + ", actors=" + actors + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + this.row;
        hash = 59 * hash + this.column;
        hash = 59 * hash + (this.visited ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.sceneType);
        hash = 59 * hash + this.distanceTravelled;
        hash = 59 * hash + Objects.hashCode(this.actors);
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
        if (this.distanceTravelled != other.distanceTravelled) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.sceneType, other.sceneType)) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        return true;
    }

    
    
    public void removeActor(OregonTrailv2 actor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
