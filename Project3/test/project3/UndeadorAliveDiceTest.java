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
 * Tests dice for Undead or Alive Expansion
 * @author krystynaurbanczyk
 */
public class UndeadorAliveDiceTest {
    
    public UndeadorAliveDiceTest() {
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

    @Test
    public void testUndeadorAliveDiceCompatability() {
        //Arrange 
        ArrayList<Dice> D = new ArrayList<Dice>();
        Dice original = new Dice();
        UndeadorAliveDice prac = new UndeadorAliveDice();
        
        D.add(prac);
        D.add(original);
        
        //Act
        for(Dice d: D){
            d.rollDie();
            System.out.println(d.getResult());
        }
    }
    
}
