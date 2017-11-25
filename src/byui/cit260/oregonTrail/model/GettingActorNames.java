/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

import byui.cit260.oregonTrail.control.GameControl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sadss
 */
public class GettingActorNames {

    //private static List<Actor> actors = new ArrayList<>();
    public static void main(String[] args) {
        getActorNamesFromUser();
        printActors();
    }

    private static void getActorNamesFromUser() {
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Please enter actor " + (i + 1) + ": ");
            String actorName = keyboard.nextLine();
            Actor actorOne = new Actor();
            actorOne.setName(actorName);
//           GameControl.actors.add(actorOne);              
        }
    }

    private static void printActors() {
        //for(Actor actor: GameControl.actors){

//        System.out.println("\n1 - " + GameControl.actors.get(0));
//        System.out.println("2 - " + GameControl.actors.get(1));
//        System.out.println("3 - " + GameControl.actors.get(2));
//        System.out.println("4 - " + GameControl.actors.get(3));
//        System.out.println("5 - " + GameControl.actors.get(4));
    }
}
