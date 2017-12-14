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
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author sadss
 */
public class MoveActorView {
    protected final BufferedReader keyboard = OregonTrailv2.getInFile();
    protected final PrintWriter console = OregonTrailv2.getOutFile();

    /**
     *
     * @author sadss
     */
    public MoveActorView() {
//        super("\n"
//                + "\n===============Oregon Trail Game================="
//                + "\n                                                 "
//                + "\n                Move Actor Menu                    "
//                + "\n                                                 "
//                + "\n1 - "+ oregontrailv2.OregonTrailv2.getCurrentGame().getPlayer().getName()
//                + "\n2 - "
//                + "\n3 - "
//                + "\n4 - "
//                + "\n5 - "
//                + "\nX - Exit                                         "
//                + "\n"
//                + "\n=================================================",
//                "\nPlease enter your choice: ");


    
            this.console.println("\n"
                 + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n                Move Actor Menu                  "
                + "\n                                                 "
                + "\n  The map is a 20 x 20 matrix with x, and y      "
                + "\n  coordinates at the top left hand corner of     "
                + "\n  0,0 and at the bottom right hand corner of     "
                + "\n  19, 19. To navigate the map you must enter     "
                + "\n  coordinates in this range.                     "                   
                + "\n  Please enter the coordinates for where you     "
                + "\n  would like to move to. or press X to Exit      "
                + "\n"
                + "\n"
                + "\n  X - Exit                                         "
                + "\n"
                + "\n=================================================");
    }

    public String[] getInputs() {
        String[] inputs = new String[1];
        inputs[0] = this.getInput("\nEnter a menu item");
        
        return inputs;
    }
    public void display() {
        String[] inputs = null;
        boolean endOfView = false;

        do {
            inputs = this.getInputs(); // get the user's selection
            if (  inputs == null
               || inputs.length < 1
               || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            endOfView = this.doAction(inputs); // do action based on selection

        } while (!endOfView);

    }


    public String getInput(String promptMessage) {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selection = null;

        // while a valid name has not been retrieved
        while (!valid) {
            System.out.println(promptMessage);
            
            // get the value entered from the keyboard
            selection = keyboard.nextLine();
            selection = selection.trim();

            if (selection.length() < 1) { // blank value entered
                System.out.println("\n*** You must enter a non-blank value");
                continue;
            }

            break;
        }

        return selection; // return the name        
    }

    public void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }

    }
    
        public boolean doAction(String[] inputs) {

        Actor actor;

        String choice = inputs[0].trim().toUpperCase(); // trim blanks and uppercase

        // check for valid actor
        switch (choice) {
            case "1":
                this.getCoordinates("  ");
                return true;
            case "X":
                return true;
            default:
                System.out.println("Invalid selection");
                return false;
        }


//        Point coordinates = this.getCoordinates(inputs[1]); // get the row and column
//        if (coordinates == null) // entered "Q" to quit
//        {
//            System.out.println("\nERROR" + actor
//                    + " could not be moved to location: "
//                    + coordinates.x + ", " + coordinates.y);
//            return false;
//        }
//
//        // move actor to specified location
//        int returnValue = MapControl.moveActorToLocation(actor, coordinates);
//        if (returnValue < 0) {
//            System.out.println("\nERROR" + actor
//                    + " could not be moved to location: "
//                    + coordinates.x + ", " + coordinates.y);
//            return false;

//        this.console.println("\n" + actor
//                + " was successfully moved to location: "
//                + coordinates.x + ", " + coordinates.y);
//
//        return true;
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

}

