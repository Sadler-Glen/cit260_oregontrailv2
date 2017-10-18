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
public class HealthLevelControlTest {
    
    public HealthLevelControlTest() {
    }

    /**
     * Test of calcRemainingFood method, of class HealthLevelControl.
     */
    @Test
    public void testCalcRemainingFood() {
        System.out.println("test 1 calcRemainingFood");
        double noOfPeople = 2.0;
        double noDaysTravelled = 2.0;
        double rationType = 5.0;
        double initialFood = 1000.0;
        HealthLevelControl instance = new HealthLevelControl();
        double expResult = 980.0;
        double result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("test 2 calcRemainingFood");
        noOfPeople = 2.0;
        noDaysTravelled = 2.0;
        rationType = 2.0;
        initialFood = 1000.0;
        //HealthLevelControl instance = new HealthLevelControl();
        expResult = 992.0;
        result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("test 3 calcRemainingFood");
        noOfPeople = 2.0;
        noDaysTravelled = 2.0;
        rationType = 1.0;
        initialFood = 1000.0;
        //HealthLevelControl instance = new HealthLevelControl();
        expResult = 996.0;
        result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("test 4 calcRemainingFood");
        noOfPeople = 0.0;
        noDaysTravelled = 2.0;
        rationType = 1.0;
        initialFood = 1000.0;
        //HealthLevelControl instance = new HealthLevelControl();
        expResult = -1;
        result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("test 5 calcRemainingFood");
        noOfPeople = 2.0;
        noDaysTravelled = -1.0;
        rationType = 2.0;
        initialFood = 1000.0;
        //HealthLevelControl instance = new HealthLevelControl();
        expResult = -1;
        result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("test 6 calcRemainingFood");
        noOfPeople = 1.0;
        noDaysTravelled = 1.0;
        rationType = 5.0;
        initialFood = 0.0;
        //HealthLevelControl instance = new HealthLevelControl();
        expResult = -1;
        result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("test 7 calcRemainingFood");
        noOfPeople = 1.0;
        noDaysTravelled = 1.0;
        rationType = 5.0;
        initialFood = 2001.0;
        //HealthLevelControl instance = new HealthLevelControl();
        expResult = -1;
        result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
        assertEquals(expResult, result, 0.0001);
    }
    
}
