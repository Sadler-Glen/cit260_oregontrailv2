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
 * @author Casper
 */
public class RiverCrossingTest {
    
    public RiverCrossingTest() {
    }

    /**
     * Test of riverCrossing method, of class RiverCrossing.
     */
    @Test
    public void testRiverCrossing() {
        System.out.println("Test #1 riverCrossing");
        int river = 1;
        int crossingType = 1;
        RiverCrossing instance = new RiverCrossing();
        int expResult = 1;
        int result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Test #2 riverCrossing");
        river = 1;
        crossingType = 2;
        expResult = 1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #3 riverCrossing");
        river = 1;
        crossingType = 3;
        expResult = 1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #4 riverCrossing");
        river = 1;
        crossingType = 4;
        expResult = 1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #5 riverCrossing");
        river = 2;
        crossingType = 2;
        expResult = 1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #6 riverCrossing");
        river = 2;
        crossingType = 3;
        expResult = 1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #7 riverCrossing");
        river = 2;
        crossingType = 4;
        expResult = 1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #8 riverCrossing");
        river = 3;
        crossingType = 3;
        expResult = 1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #9 riverCrossing");
        river = 3;
        crossingType = 4;
        expResult = 1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #10 riverCrossing");
        river = 2;
        crossingType = 1;
        expResult = -1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #11 riverCrossing");
        river = 3;
        crossingType = 1;
        expResult = -1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
        
        System.out.println("Test #12 riverCrossing");
        river = 3;
        crossingType = 2;
        expResult = -1;
        result = instance.riverCrossing(river, crossingType);
        assertEquals(expResult, result);
    }
    
}
