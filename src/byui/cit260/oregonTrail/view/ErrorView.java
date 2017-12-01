

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import java.io.PrintWriter;
import oregontrailv2.OregonTrailv2;

/**
 *
 * @author sadss
 */
public class ErrorView {

    private static final PrintWriter errorFile = OregonTrailv2.getOutFile();
    private static final PrintWriter logFile = OregonTrailv2.getLogFile();
    
    public static void display(String className, String errorMessage){
        
        errorFile.println(
                "-----------------------------------------------------"
              + "\n- Error - " + errorMessage
              + "\n----------------------------------------------------");
        
        // log error
        logFile.println(className + " - " + errorMessage);
    }
}
