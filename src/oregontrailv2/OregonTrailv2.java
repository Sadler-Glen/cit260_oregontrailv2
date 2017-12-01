/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrailv2;

import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.Player;
import byui.cit260.oregonTrail.view.StartProgramView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Glen Sadler
 */
public class OregonTrailv2 {

    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;

    public static void main(String[] args) {

        
        try {
            
            //open character stream files for end user input and output
            OregonTrailv2.inFile =
                    new BufferedReader(new InputStreamReader(System.in));
            
            OregonTrailv2.outFile = new PrintWriter(System.out, true);
            
            // open log file
            String filePath = "log.txt";
            OregonTrailv2.logFile = new PrintWriter(filePath);
            
            // create StartProgramView and start program
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();

        
        } catch (FileNotFoundException te) {
            System.out.println("Exception: " + te.toString()+
                                "\nCause: " + te.getCause() +
                                "\nMessage: "+ te.getMessage());
            te.printStackTrace();;
        }
        
        finally {
            try {
                if (OregonTrailv2.inFile !=null) 
                    OregonTrailv2.inFile.close();
                
                if(OregonTrailv2.outFile !=null)
                   OregonTrailv2.outFile.close();
                
                if(OregonTrailv2.logFile !=null)
                   OregonTrailv2.logFile.close();
                
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
    }
    

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        OregonTrailv2.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        OregonTrailv2.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        OregonTrailv2.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        OregonTrailv2.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        OregonTrailv2.logFile = logFile;
    }

}
