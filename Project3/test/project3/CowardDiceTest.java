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
 * Tests Coward dice for Old Saloon Expansion
 * @author krystynaurbanczyk
 */
public class CowardDiceTest {
    
    /**
     *
     */
    public CowardDiceTest() {
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
     * Test of rollDie method, of class CowardDice.
     */
    @Test
    public void testCowardDiceCompatability() {
        //Arrange 
        ArrayList<Dice> D = new ArrayList<Dice>();
        Dice base = new Dice();
        CowardDice coward = new CowardDice();
        
        D.add(coward);
        D.add(base);
        
        //Act
        for(Dice d: D){
            d.rollDie();
            System.out.println(d.getResult());
        }
    }
}
