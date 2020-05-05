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
public class OldSaloonTest {
    
    /**
     *
     */
    public OldSaloonTest() {
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
     *
     */
    @Test
    public void performActions_DOCHOLLYDAY_no1or2shot() {
        OldSaloon instance = new OldSaloon(4);
        ArrayList<Dice> dice = new ArrayList<Dice>();
        ArrayList<Player> players = instance.getPlayers();
        players.get(0).setCharacterTraits(16);
        instance.setPlayers(players);
        for(int i = 0; i<5; i++ )
        {
            Dice d = new Dice();
            d.setDice("Arrow");
            dice.add(d);
            
        }
        instance.setDie(dice);
        
        int expectedHealth = 8;
       //act
       
       instance.performActions(players.get(0));
       players = instance.getPlayers();
       //assert
       assertEquals(expectedHealth,players.get(0).getHealth());
    }

    /**
     *
     */
    @Test
        public void performActions_DOCHOLLYDAY_31shot() {
        OldSaloon instance = new OldSaloon(4);
        ArrayList<Dice> dice = new ArrayList<Dice>();
        ArrayList<Player> players = instance.getPlayers();
        players.get(0).setCharacterTraits(16);
        players.get(0).setHealth(6);
        instance.setPlayers(players);
        for(int i = 0; i<5; i++ )
        {
            Dice d = new Dice();
            d.setDice("Arrow");
            if(i<3)
                d.setDice("One");
            dice.add(d);
            
        }
        instance.setDie(dice);
        
        int expectedHealth = 8;
       //act
       
       instance.performActions(players.get(0));
       players = instance.getPlayers();
       //assert
       assertEquals(expectedHealth,players.get(0).getHealth());
    }
     
    /**
     *
     */
    @Test
        public void CreateDice_User(){
           //arrange
            OldSaloon instance = new OldSaloon(4);
            
            Player p = new Player("p1");
            p.setUser();
            
           //act
           instance.createDie(p);
            
        }

    /**
     *
     */
    @Test
        public void CreateDice_UserJoseDelgado(){
           //arrange
            OldSaloon instance = new OldSaloon(4);
            
            Player p = new Player("p1");
            p.setCharacterTraits(17);
            p.setUser();
           
           //act
           instance.createDie(p);
           for(Dice d: instance.getDie()){
               System.out.println(d.rollDie());
           }
        }

    /**
     *
     */
    @Test
        public void CreateDice_AIJoseDelgado(){
           //arrange
            OldSaloon instance = new OldSaloon(4);
            
            Player p = new Player("p1");
            p.setCharacterTraits(17);
            p.setHealth(1);
           
           
           //act
           instance.createDie(p);
           for(Dice d: instance.getDie()){
               System.out.println(d.rollDie());
           }
        }
    
}
