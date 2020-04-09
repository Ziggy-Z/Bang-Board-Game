/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */
package project3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author X1Gen3
 */
public class DiceTest {
    
    public DiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of rollDie method, of class Dice.
     */
    @Test
    public void testRollDie() {
        System.out.println("rollDie");
        Dice instance = new Dice();
        String expResult ="DynamiteArrowOneTwoGatlingBeer";
        String result = instance.rollDie();
        if(!expResult.contains(result))
           fail("Output was incorrect:" + result);
    }

    /**
     * Test of getResult method, of class Dice.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Dice instance = new Dice();
        String expResult = instance.getResult();
        String result = instance.getResult();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of compareTo method, of class Dice.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Dice d = new Dice();
        Dice instance = new Dice();
        int expResult = 0;
        int result = instance.compareTo(d);
        if(result == 0)
            assertEquals(d.getResult(),instance.getResult());
        if(result == 1 && !(instance.getValue() > d.getValue()))
            fail("incorrect comparison");
        if(result == -1 && !(instance.getValue() < d.getValue()))
            fail("incorrect comparison");
           
    
        
    }
    
}
