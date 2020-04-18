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
     * test for adding in suzzy lafyate character ability 
     */
    @Test 
    public void performActions_SuzzyLafyatteNoShots_heathIncTwo(){
        //arrange
        
        Game instance = new Game(4);
        ArrayList<Dice> dice = new ArrayList<Dice>();
        ArrayList<Player> players = instance.getPlayers();
        players.get(0).setCharacterTraits(13);
        instance.setPlayers(players);
        for(int i = 0; i<5; i++ )
        {
            Dice d = new Dice();
            d.setDice("Arrow");
            dice.add(d);
            
        }
        instance.setDie(dice);
        
        int expectedHealth = 10;
       //act
       
       instance.performActions(players.get(0));
       players = instance.getPlayers();
       //assert
       assertEquals(expectedHealth,players.get(0).getHealth());
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
        @Test
    public void IndianAttack_Jourdonnais() {
    //arange 
    int expectedHealth = 6;
    Game instance = new Game(4);
    ArrayList<Player> players = instance.getPlayers();
    players.get(0).setCharacterTraits(5);
    players.get(0).setArrows(5);
    instance.setPlayers(players);
    // act
    instance.IndianAttack();
    players = instance.getPlayers();
    //assert
    assertEquals(expectedHealth,players.get(0).getHealth());
    }

    /**
     * Test of gatlingGun method, of class Game.
     */
    @Test
    public void testGatGun_p1_FourPlayerGame() {
        
        //arrange
        Game instance = new Game(4);
        ArrayList<Player> players = new ArrayList<Player>();
       
        
        for(int i = 0; i<4; i++)
        {
            Player p = new Player("p"+i);
            p.setHealth(2);
            players.add(p);
        }
        //act
        instance.setPlayers(players);
        instance.gatlingGun(players.get(0));
       
        
      
        //assert
        players = instance.getPlayers();
        int i= 0;
        for(Player p: players){
            if(i > 0)
                assertEquals(p.getHealth(),1);
            i++;
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }
    /**
     * 
     */
    @Test
    public void testGatGun_BartCassidy_FourPlayerGame() {
        //arrange
        Game instance = new Game(4);
        int expectedHealth = 8;
        int expectedPlayerArrows = 1;
        int expectedTotalGameArrows = instance.getTotalArrows()-1;

        ArrayList<Player> players = new ArrayList<Player>();
       
        
        for(int i = 0; i<4; i++)
        {
            Player p = new Player("p"+i);
            p.setHealth(2);
            if(i == 1)
                p.setCharacterTraits(0);
            players.add(p);
            
        }
        //act
        instance.setPlayers(players);
        instance.gatlingGun(players.get(0));
        players = instance.getPlayers();
       
        
      
        //assert
        assertEquals(expectedHealth,players.get(1).getHealth());
        assertEquals(expectedPlayerArrows,players.get(1).getArrows());
        assertEquals(expectedTotalGameArrows,instance.getTotalArrows());
    }
       @Test
    public void testGatGun_PaulRegret_FourPlayerGame() {
        //arrange
        Game instance = new Game(4);
        int expectedHealth = 9;
        ArrayList<Player> players = new ArrayList<Player>();
        
        for(int i = 0; i<4; i++)
        {
            Player p = new Player("p"+i);
            p.setHealth(2);
            if(i == 1)
            {
                p.setCharacterTraits(8);
                System.out.println(p.getCharacter()+" " +p.getHealth());
            }
            players.add(p);
            
        }
       
        //act
        instance.setPlayers(players);
        instance.gatlingGun(players.get(0));
        players = instance.getPlayers();
       
        
      
        //assert
        assertEquals(expectedHealth,players.get(1).getHealth());
 
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
     * Test of oneShotMethod with Bart Cassidy ability
     */
    @Test
    public void OneShot_BartCassidyTA9_SameHealthArrowPlus1(){
        //arrange
        Game instance = new Game(4);
        Player p = new Player("P1");
        p.setCharacterTraits(0); 
        System.out.println(p.getCharacter());
        int expectedHealth = p.getHealth();
        int expectedPlayerArrows = p.getArrows()+1;
        int expectedTotalGameArrows = instance.getTotalArrows()-1;
        //act
        instance.oneShot(p);
        //assert
        assertEquals(expectedHealth,p.getHealth());
        assertEquals(expectedPlayerArrows,p.getArrows());
        assertEquals(expectedTotalGameArrows,instance.getTotalArrows());
    }
     /**
     * Test of oneShotMethod with Bart Cassidy ability
     */
    @Test
    public void OneShot_BartCassidyTA1_SameHealthArrowPlus1(){
        //arrange
        Game instance = new Game(4);
        instance.setTotalArrows(1);
        Player p = new Player("P1");
        p.setCharacterTraits(0);
        int expectedHealth = p.getHealth() -1;
        int expectedArrows = p.getArrows();
        int expectedTotalGameArrows = instance.getTotalArrows();
        //act
        instance.oneShot(p);
        //assert
        assertEquals(expectedHealth,p.getHealth());
        assertEquals(expectedArrows,p.getArrows());
        assertEquals(expectedTotalGameArrows,instance.getTotalArrows());
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
     * Test of oneShotMethod with Bart Cassidy ability
     */
    @Test
    public void TwoShot_BartCassidyTA9_SameHealthArrowPlus1(){
        //arrange
        Game instance = new Game(4);
        Player p = new Player("P1");
        p.setCharacterTraits(0); 
        System.out.println(p.getCharacter());
        int expectedHealth = p.getHealth();
        int expectedPlayerArrows = p.getArrows()+1;
        int expectedTotalGameArrows = instance.getTotalArrows()-1;
        //act
        instance.twoShot(p);
        //assert
        assertEquals(expectedHealth,p.getHealth());
        assertEquals(expectedPlayerArrows,p.getArrows());
        assertEquals(expectedTotalGameArrows,instance.getTotalArrows());
    }
     /**
     * Test of oneShotMethod with Bart Cassidy ability
     */
    @Test
    public void TwoShot_BartCassidyTA1_SameHealthArrowPlus1(){
        //arrange
        Game instance = new Game(4);
        instance.setTotalArrows(1);
        Player p = new Player("P1");
        p.setCharacterTraits(0);
        int expectedHealth = p.getHealth() -1;
        int expectedArrows = p.getArrows();
        int expectedTotalGameArrows = instance.getTotalArrows();
        //act
        instance.twoShot(p);
        //assert
        assertEquals(expectedHealth,p.getHealth());
        assertEquals(expectedArrows,p.getArrows());
        assertEquals(expectedTotalGameArrows,instance.getTotalArrows());
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
