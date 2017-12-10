/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.MapControl;
import byui.cit260.oregonTrail.exceptions.MapControlException;
import byui.cit260.oregonTrail.model.Actor;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sadss
 */
public class MoveActorView extends View{
    

/**
 *
 * @author sadss
 */


    public MoveActorView() {
        super("\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n                Move Actor Menu                    "
                + "\n                                                 "
                + "\n1 - "+ oregontrailv2.OregonTrailv2.getCurrentGame().getPlayer().getName()
                + "\n2 - "
                + "\n3 - "
                + "\n4 - "
                + "\n5 - "
                + "\nX - Exit                                         "
                + "\n"
                + "\n=================================================",
                "\nPlease enter your choice: ");

    }

    @Override
    public void display() {

        boolean done = false; // set flag to not done
        try {
            do {
                // prompt for and get menu option
                String value = this.getInput();
                if (value.toUpperCase().equals("X"))// user wants to exit view                
                // do the requested action and display the next view
                {
                    return; // exit view
                }
                done = this.doAction(value);
            } while (!done);
        } catch (NumberFormatException nfe) {
            ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }

//    
    public boolean doAction(String[] inputs) {
        String actor1 = oregontrailv2.OregonTrailv2.getCurrentGame().getActors().get(0).getName();
        String actor2 = oregontrailv2.OregonTrailv2.getCurrentGame().getActors().get(1).getName();
        String actor3 = oregontrailv2.OregonTrailv2.getCurrentGame().getActors().get(2).getName();
        String actor4 = oregontrailv2.OregonTrailv2.getCurrentGame().getActors().get(3).getName();
        String actor5 = oregontrailv2.OregonTrailv2.getCurrentGame().getActors().get(4).getName();
        String actor = " ";
        
        
        
        String choice = inputs[0].trim().toUpperCase(); // trim blanks and uppercase

        // check for valid actor
        switch (choice) {
            case "1":
                actor = actor1;
                break;
            case "2":
                actor = actor2;
                break;
            case "3":
                actor = actor3;
                break;
            case "4":
                actor = actor4;
                break;
            case "5":
                actor = actor5;
                break;
            case "Q":
                return true;
            default:
                System.out.println("Invalid selection");
                return false;
        }

        Point coordinates = this.getCoordinates(inputs[1]); // get the row and column
        if (coordinates == null) // entered "Q" to quit
        {
            System.out.println("\nERROR" + actor
                    + " could not be moved to location: "
                    + coordinates.x + ", " + coordinates.y);
            return false;
        }

        try {
            // move actor to specified location
            MapControl.moveActorToLocation(coordinates);
        } catch (MapControlException ex) {
            Logger.getLogger(MoveActorView.class.getName()).log(Level.SEVERE, ex.getMessage(),ex);
            return false;
        }

        System.out.println("\n" + actor
                + " was successfully moved to location: "
                + coordinates.x + ", " + coordinates.y);

        return true;
    }

    public Point getCoordinates(String value) {

        value = value.trim().toUpperCase();
        if (value.equals("Q")) {
            return null;
        }

        //tokenize values int string
        String[] values = value.split(" ");

        if (values.length < 2) {
            System.out.println("You must enter both a row and column number.");
            return null;
        }

        // parse out row and column numbers
        int row = Integer.parseInt(values[0]);
        int column = Integer.parseInt(values[1]);
        return new Point(row, column);

    }      

    private void actor1() {
        this.console.println("\n***actor1() function stub called***");
    }

    private void actor2() {
        this.console.println("\n***actor2() function stub called***");
    }

    private void actor3() {
        this.console.println("\n***actor3() function stub called***");
    }

    private void actor4() {
        this.console.println("\n***actor4() function stub called***");
    }

    private void acttor5() {
        this.console.println("\n***actor5() function stub called***");
    }

    @Override
    public boolean doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
