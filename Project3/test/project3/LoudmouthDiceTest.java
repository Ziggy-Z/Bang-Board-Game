// CS 2365 OOP Section 002 Spring 2020 
//Krystyna Urbanczyk

package project3;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests Loudmouth dice for Old Saloon Expansion
 * @author krystynaurbanczyk
 */
public class LoudmouthDiceTest {
    
    public LoudmouthDiceTest() {
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
     * Test of rollDie method, of class LoudmouthDice.
     */
    @Test
    public void testLoudmouthDiceCompatability() {
        //Arrange 
        ArrayList<Dice> D = new ArrayList<Dice>();
        Dice regular = new Dice();
        LoudmouthDice loud = new LoudmouthDice();
        
        D.add(loud);
        D.add(regular);
        
        //Act
        for(Dice d: D){
            d.rollDie();
            System.out.println(d.getResult());
        }
    }
    
}
