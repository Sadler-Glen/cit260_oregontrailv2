/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Glen Sadler - Individual Assignment
 */
public class HealthLevelControlTest {
    
    public HealthLevelControlTest() {
    }

    /**
     * Test of evalHealthLevel method, of class HealthLevelControl.
     */
    @Test
    public void testEvalHealthLevel() {
        System.out.println("Test #1 - Invalid (Negative Days) "); // negative days
        double days = -1.0;
        double ration = 1.0;
        double pace = 1.0;
        HealthLevelControl instance = new HealthLevelControl();
        double expResult = -1.0;
        double result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, -1.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        System.out.println("Test #2 - Invalid (Negative Rations)"); // negative ration
        days = 14.0;
        ration = -1.0;
        pace = 1.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, -1.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");

        System.out.println("Test #3 - Invalid (Negative Pace)"); // negative pace
        days = 14.0;
        ration = 1.0;
        pace = -1.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");   
    
        System.out.println("Test #4 - Valid Days 1 to 44 (Good Health)");
        days = 44.0;
        ration = 1.0;
        pace = 1.0;
        expResult = 3.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #5 - Valid Days 45 to 89 (Fair Health)");
        days = 89.0;
        ration = 1.0;
        pace = 1.0;
        expResult = 2.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #6 - Valid Days 90 to 134 (Poor Health)");
        days = 134.0;
        ration = 1.0;
        pace = 1.0;
        expResult = 1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #7 - Valid Death!!!!");
        days = 135.0;
        ration = 1.0;
        pace = 1.0;
        expResult = 0.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #8 - Boundary = 0 Days");
        days = 0.0;
        ration = 1.0;
        pace = 1.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #9 - Boundary > 135 Days");
        days = 136.0;
        ration = 1.0;
        pace = 1.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #10 - Boundary ration > 3");
        days = 10.0;
        ration = 4.0;
        pace = 1.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        System.out.println("Test #11 - Boundary pace > 3");
        days = 1.0;
        ration = 3.0;
        pace = 4.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype."); 
    }
    
}
