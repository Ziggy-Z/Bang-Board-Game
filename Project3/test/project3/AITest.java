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
    
    public AITest() {
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
     * Test of who_toheal method, of class AI.
     */
    @Test
    public void WhoToHeal_SheriffNotFullHealth() {
        //arrange 
        ArrayList<Player> Options = new ArrayList<Player>();
        
        Player p1 = new Player("p1");
        p1.setRole("Sheriff");
        p1.setCharacterTraits(0);
        p1.setHealth(7);
        
        Player p2 = new Player("p2");
        p2.setRole("Deputy");
        p2.setCharacterTraits(0);
        
        Player p3 = new Player("p3");
        p3.setRole("Renegade");
        p3.setCharacterTraits(0);
        
        Player p4 = new Player("p4");
        p4.setRole("Outlaw");
        p4.setCharacterTraits(0);
        
        Options.add(p1);
        Options.add(p2);
        Options.add(p3);
        Options.add(p4);
        
        AI ai = new AI();
        int expectedIndex = -1;
        //act 
        int result = ai.who_toheal(Options, p1);
        
        //assert
        assertEquals(expectedIndex,result);
        
        
        
    }
    @Test
    public void WhoToHeal_SheriffFullHealth() {
        //arrange 
        ArrayList<Player> Options = new ArrayList<Player>();
        
        Player p1 = new Player("p1");
        p1.setRole("Sheriff");
        p1.setCharacterTraits(0);
        p1.setHealth(7);
        
        Player p2 = new Player("p2");
        p2.setRole("Deputy");
        p2.setCharacterTraits(0);
        
        Player p3 = new Player("p3");
        p3.setRole("Renegade");
        p3.setCharacterTraits(0);
        
        Player p4 = new Player("p4");
        p4.setRole("Outlaw");
        p4.setCharacterTraits(0);
        
        Options.add(p1);
        Options.add(p2);
        Options.add(p3);
        Options.add(p4);
        
        AI ai = new AI();
        int expectedIndex = -1;
        //act 
        int result = ai.who_toheal(Options, p1);
        
        //assert
        assertEquals(expectedIndex,result); 
        
    }
        @Test
        public void WhoToHeal_DeputyFullHealth() {
        //arrange 
        ArrayList<Player> Options = new ArrayList<Player>();
        
        Player p1 = new Player("p1");
        p1.setRole("Sheriff");
        p1.setCharacterTraits(0);
        p1.setHealth(7);
        
        Player p2 = new Player("p2");
        p2.setRole("Deputy");
        p2.setCharacterTraits(0);
        
        Player p3 = new Player("p3");
        p3.setRole("Renegade");
        p3.setCharacterTraits(0);
        
        Player p4 = new Player("p4");
        p4.setRole("Outlaw");
        p4.setCharacterTraits(0);
        
        Options.add(p1);
        Options.add(p2);
        Options.add(p3);
        Options.add(p4);
        
        AI ai = new AI();
        
        int expectedIndex = 0; //indx of sheriff
        //act 
        int result = ai.who_toheal(Options, p2);
        
        //assert
        assertEquals(expectedIndex,result); 
        
    }
        public void WhoToHeal_RenegadeFullHealth() {
        //arrange 
        ArrayList<Player> Options = new ArrayList<Player>();
        
        Player p1 = new Player("p1");
        p1.setRole("Sheriff");
        p1.setCharacterTraits(0);
        p1.setHealth(7);
        
        Player p2 = new Player("p2");
        p2.setRole("Deputy");
        p2.setCharacterTraits(0);
        
        Player p3 = new Player("p3");
        p3.setRole("Renegade");
        p3.setCharacterTraits(0);
        
        Player p4 = new Player("p4");
        p4.setRole("Outlaw");
        p4.setCharacterTraits(0);
        
        Options.add(p1);
        Options.add(p2);
        Options.add(p3);
        Options.add(p4);
        
        AI ai = new AI();
        int expectedIndex = -1;
        //act 
        int result = ai.who_toheal(Options, p1);
        
        //assert
        assertEquals(expectedIndex,result); 
        
    }

}
