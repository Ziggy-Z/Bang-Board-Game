/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */
package project3;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UserSelectDiceTest {
    
    public UserSelectDiceTest() {
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
     * Test of main method, of class UserSelectDice.
     */
    @Test
    public void getUserSelectedDice_noneselected() {
        //arrange
        UserSelectDice us = new UserSelectDice();
        boolean [] selections;
        //act 
        selections = us.getUserSelectedDice();
        //assert
        
        assertEquals(false,selections[0]);
        assertEquals(false,selections[1]);
    }
    /**
     * Test of main method, of class UserSelectDice.
     */
    @Test
    public void getUserSelectedDice_LoudSelected() {
        //arrange
        UserSelectDice us = new UserSelectDice();
        boolean [] selections;
        //act 
        selections = us.getUserSelectedDice();
        //assert
        
        assertEquals(true,selections[0]);
        assertEquals(false,selections[1]);
        
        
    }
    @Test
    public void getUserSelectedDice_CowardSelected() {
        //arrange
        UserSelectDice us = new UserSelectDice();
        boolean [] selections;
        //act 
        selections = us.getUserSelectedDice();
        //assert
        
        assertEquals(false,selections[0]);
        assertEquals(true,selections[1]);
        
        
    }
    
    @Test
    public void getUserSelectedDice_BothSelected() {
        //arrange
        UserSelectDice us = new UserSelectDice();
        boolean [] selections;
        //act 
        selections = us.getUserSelectedDice();
        //assert
        
        assertEquals(true,selections[0]);
        assertEquals(true,selections[1]);
        
        
    }

    
}
