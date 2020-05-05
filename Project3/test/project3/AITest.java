/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */
package project3;

import java.util.ArrayList;
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
public class AITest {
    
    /**
     *
     */
    public AITest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of rollagain method, of class AI.
     */
    @Test
    public void testRollagain() {
        System.out.println("rollagain");
        ArrayList<Dice> die = null;
        String role = "";
        AI instance = new AI();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.rollagain(die, role);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of who_toshoot method, of class AI.
     */
    @Test
    public void testWho_toshoot() {
        System.out.println("who_toshoot");
        ArrayList<Player> options = null;
        String role = "";
        AI instance = new AI();
        int expResult = 0;
        int result = instance.who_toshoot(options, role);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of who_toheal method, of class AI.
     */
    @Test
    public void testWho_toheal() {
        //arrange - setting up all the variables to fit situation 
        ArrayList<Player> options = new ArrayList<Player>();
        Player p = new Player("p1");
        options.add(p);
        options.add(p);
        AI instance = new AI();
        p.setCharacterTraits(0);
        int expectedhealth = 8;
        //act
        
        int who = instance.who_toheal(options,"Outlaw");
        
        //assert
        assertNotEquals(-1,who);
        System.out.println(who);

    }
    
}
