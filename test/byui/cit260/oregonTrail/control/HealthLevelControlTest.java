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
        System.out.println("Test #1 - Valid Days 1-44 (Good Health) "); // negative days
        double days = 44.0;
        double ration = 3.0;
        double pace = 3.0;
        HealthLevelControl instance = new HealthLevelControl();
        double expResult = 3.0;
        double result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        System.out.println("Test #2 - Valid Days 45-89 (Fair Health)"); // negative ration
        days = 89.0;
        ration = 3.0;
        pace = 3.0;
        expResult = 2.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");

        System.out.println("Test #3 - Valid Days 90-134 (Poor Health)"); // negative pace
        days = 134.0;
        ration = 3.0;
        pace = 3.0;
        expResult = 1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");   
    
        System.out.println("Test #4 - Valid Days 135 (Death!!!)");
        days = 135.0;
        ration = 3.0;
        pace = 3.0;
        expResult = 0.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #5 - Invalid (Negative Days)");
        days = -1.0;
        ration = 3.0;
        pace = 3.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #6 - Invalid (Negative Rations)");
        days = 44.0;
        ration = -1.0;
        pace = 3.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #7 - Invalid (Negative Pace)");
        days = 44.0;
        ration = 3.0;
        pace = -1.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #8 - Boundary = 0 Days");
        days = 0.0;
        ration = 3.0;
        pace = 3.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #9 - Boundary > 135 Days");
        days = 136.0;
        ration = 3.0;
        pace = 3.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #10 - Boundary ration > 3");
        days = 44.0;
        ration = 4.0;
        pace = 3.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        System.out.println("Test #11 - Boundary pace > 3");
        days =44.0;
        ration = 3.0;
        pace = 4.0;
        expResult = -1.0;
        result = instance.evalHealthLevel(days, ration, pace);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype."); 
    }
    
}
