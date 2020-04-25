/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */
package project3;

import java.util.ArrayList;
import javax.swing.JFrame;
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
public class UserOptionTest {
    
    public UserOptionTest() {
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
     public void newInit_withTwoOptions(){
        ArrayList<Player> options = new ArrayList<Player>();
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        options.add(p1);
        options.add(p2);
        UserOption instance = new UserOption(options);
        instance.setVisible(true);
        instance.setLocation(300, 25);
       // instance.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
