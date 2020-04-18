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
public class GameTest {
    
    public GameTest() {
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
     * Test of play method, of class Game.
     */
    @Test(timeout =100000)
    public void testPlay() throws Exception {

    }


    /**
     * Test of getWinners method, of class Game.
     */
    @Test
    public void testGetWinners() {
        Game g = new Game(4);
        ArrayList<Player> testing = new ArrayList<Player>();
        
        Player p = new Player("p"+1);
        Player p2 = new Player("p"+1);
        
        //game still has sheriff
        p.setRole("Sheriff");
        p2.setRole("Outlaw");
        testing.add(p);
        testing.add(p2);
        if(g.getWinner(testing))
            fail("Game shouldnt have ended");
        testing.clear();
        
        //all players dead
        if(g.getWinner(testing))
            assertEquals(g.getWinners(),"Outlaw");
        
        //single Outlaw left 
        p.setRole("Outlaw");
        testing.add(p);
        if(g.getWinner(testing))
            if(!"Outlaw".equals(g.getWinners()))
                fail("Outlaws should have won not" + g.getWinners());
        else 
            //fail("single Outlaw didnt end game");
        //two outlaws remain
        p.setRole("Outlaw");
        p2.setRole("Outlaw");
        testing.add(p);
        testing.add(p2);
        if(g.getWinner(testing))
        {
            if(!"Outlaw".equals(g.getWinners()))
                fail("Outlaws should have won not" + g.getWinners());
        }else 
            {
              
                fail("two outlaw didnt end game");
            }
        
    //single Renegade left 
        testing.clear();
        p.setRole("Renegade");
        testing.add(p);
        if(g.getWinner(testing))
        {
            if("Renegade".equals(g.getWinners()))
               System.out.println("");
            else 
               fail("Single Renegade Test Failed - result was " + g.getWinners());
        }
        else 
            fail("Single Renegade Test Didn't end game");
        //two renegades kill the sheriff
        
        p2.setRole("Renegade");
        testing.add(p2);
        if(g.getWinner(testing))
            if("Outlaw".equals(g.getWinners()))
                System.out.println("");
            else
                fail("Two renegade kill sheriff test failed");
        else
            fail("Two renegade test didnt end game");
        //Single sheriff remaining 
        testing.clear();
        p.setRole("Sheriff");
        testing.add(p);
        
        if(g.getWinner(testing))
            if("Sheriff".equals(g.getWinners()))
                System.out.println("");
            else fail("Single Sheriff Test Failed");
        else 
            fail("Single Sheriff Test Didn't end game");
         p2.setRole("Deputy");
         testing.add(p2);
         if(g.getWinner(testing))
            if("Sheriff".equals(g.getWinners()))
                System.out.println("");
            else fail("Sheriff and  Deputy Test failed");
         else   
             fail("Sheriff and  Deputy Test Didn't end game");
    }

    /**
     * Test of getNumPlayers method, of class Game.
     */
    @Test
    public void testGetNumPlayers() {
        System.out.println("getNumPlayers");
        Game instance = new Game(4);
        int expResult = 4;
        int result = instance.getNumPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    



    /**
     * Test of IndianAttack method, of class Game.
     */
    @Test
    public void testIndianAttack() {
        System.out.println("IndianAttack");
        Game instance = new Game(4);
        ArrayList<Player> players = instance.getPlayers();
       int [] Health = new int[4]; 
       int i = 0;
        for(Player p: players )
        {
         Health[i] = p.getHealth()-p.getArrows();
         i++;
        }
        //instance.IndianAttack();
        i =0;
        for(Player p: instance.getPlayers())
        {

            if(p.getHealth() != Health[i])
                fail("Health didnt decrease by correct amount");
            i++;
        }
    }

    /**
     * Test of gatlingGun method, of class Game.
     */
    @Test
    public void testGatGun_p1_FourPlayerGamme() {
        System.out.println("getOneAway");
        
        Game instance = new Game(4);
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i<4; i++)
        {
            Player p = new Player("p" + i);
            p.setRole("Outlaw");
            p.setHealth(0);
            players.add(p);
            
        }
        instance.setPlayers(players);
        instance.gatlingGun(players.get(0));
        players = instance.getPlayers();
        for (Player p: players)
        {
            if(p.getNumber() == "p1")
            {
                fail(p.getNumber() + " " + p.getHealth());
            }
         
                
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }
    

    /**
     * Test of oneShot method, of class Game.
     */
    @Test
    public void testOneShot() {
        System.out.println("oneShot Test");
        Player p = new Player("P1");
        p.setHealth(3);
        Game instance = new Game(4);
        instance.oneShot(p);
        if(p.getHealth() != 2)
            fail("Health didnt decriment");
        
    }

    /**
     * Test of twoShot method, of class Game.
     */
    @Test
    public void testTwoShot() {
        System.out.println("twoShot Test");
        Player p = new Player("P1");
        p.setHealth(3);
        Game instance = new Game(4);
        instance.twoShot(p);
        if(p.getHealth() != 2)
            fail("Health didnt decriment");
    }

    /**
     * Test of heal method, of class Game.
     */
    @Test
    public void Heal_anyHealth_previousHealthPlusOne() {
        System.out.println("heal");
        //Arrange
        Game instance = new Game(4);
        Player p = instance.getPlayers().get(0);
        int healthBefore = p.getHealth();
        int expectedResult = healthBefore +1;
        //act 
        instance.heal(p);
        // assert
        assertEquals(expectedResult,p.getHealth());
        
    }
    /**
     * Test of Heal when health is already full
     */

    /**
     * Test of getOneAway method, of class Game.
     */
    @Test
    public void testGetOneAway_firstPosition_FourPlayerGamme() {
        System.out.println("getOneAway");
        
        Game instance = new Game(4);
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i<4; i++)
        {
            Player p = new Player("p" + i);
            players.add(p);
            
        }
        instance.setPlayers(players);
        ArrayList<Player> Options = instance.getOneAway(players.get(0));
        assertEquals(Options.get(0).getNumber(),"p1");
        assertEquals(Options.get(1).getNumber(),"p3");
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void testGetOneAway_lastPosition_FourPlayerGamme() {
        System.out.println("getOneAway");
        
        Game instance = new Game(4);
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i<4; i++)
        {
            Player p = new Player("p" + i);
            players.add(p);
            
        }
        instance.setPlayers(players);
        ArrayList<Player> Options = instance.getOneAway(players.get(3));
        assertEquals(Options.get(0).getNumber(),"p0");
        assertEquals(Options.get(1).getNumber(),"p2");
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void testGetOneAway_middlePosition_FourPlayerGamme() {
        System.out.println("getOneAway");
        
        Game instance = new Game(4);
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i<4; i++)
        {
            Player p = new Player("p" + i);
            players.add(p);
            
        }
        instance.setPlayers(players);
        ArrayList<Player> Options = instance.getOneAway(players.get(2));
        assertEquals(Options.get(0).getNumber(),"p3");
        assertEquals(Options.get(1).getNumber(),"p1");
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTwoAway method, of class Game.
     */
    @Test
    public void testGetTwoAway_firstPosition_FivePlayerGamme() {
        System.out.println("getOneAway");
        
        Game instance = new Game(5);
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i<5; i++)
        {
            Player p = new Player("p" + i);
            players.add(p);
            
        }
        instance.setPlayers(players);
        ArrayList<Player> Options = instance.getTwoAway(players.get(0));
        
        assertEquals(Options.get(0).getNumber(),"p2");
        assertEquals(Options.get(1).getNumber(),"p3");
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void testGetTwoAway_MiddlePosition_FivePlayerGamme() {
        System.out.println("getOneAway");
        
        Game instance = new Game(5);
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i<5; i++)
        {
            Player p = new Player("p" + i);
            players.add(p);
            
        }
        instance.setPlayers(players);
        ArrayList<Player> Options = instance.getTwoAway(players.get(2));
        
        assertEquals(Options.get(0).getNumber(),"p4");
        assertEquals(Options.get(1).getNumber(),"p0");
        // TODO review the generated test code and remove the default call to fail.
        
    }
        @Test
        public void testGetTwoAway_LastPosition_FivePlayerGamme() {
        System.out.println("getOneAway");
        
        Game instance = new Game(5);
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i<5; i++)
        {
            Player p = new Player("p" + i);
            players.add(p);
            
        }
        instance.setPlayers(players);
        ArrayList<Player> Options = instance.getTwoAway(players.get(4));
        
        assertEquals(Options.get(0).getNumber(),"p1");
        assertEquals(Options.get(1).getNumber(),"p2");
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
