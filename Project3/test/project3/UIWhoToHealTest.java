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
public class UIWhoToHealTest {
    
    public UIWhoToHealTest() {
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
     * Test of main method, of class UIWhoToHeal.
     */
    @Test
    public void testUIWhoToHeal() {
        Game g = new Game(6); 
        UIWhoToHeal input = new UIWhoToHeal(g.getPlayers());
       int x = input.healPlayer();
       assertEquals(x,0);
    }
    
}
