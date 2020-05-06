package project3;

import project3.AI;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/*
CS 2365 OOP Spring 2020 Section 2
Rohit Gurnani
 */


/**
 * Creates testing for the AI class
 * @author Rohit Gurnani
 */
public class AITest {
    
    public AITest() {
    }

     /**
     * Test of rollagain method, of class AI.
     * @author Rohit Gurnani
     */
    @Test
    public void testRollagain() {
      ArrayList<Dice> d= new ArrayList<>();
      ArrayList<Dice> p= new ArrayList<>();
      AI test_1 = new AI();
      AI test_2 = new AI();
      String str = "Deputy";
      String str2 = "Sheriff";
      ArrayList<Integer> roll = test_1.rollagain(d, str);
      ArrayList<Integer> roll_2 = test_2.rollagain(p, str2);
      System.out.println(roll);
      System.out.println(roll_2);
      
    }

    /**
     * Test of who_toshoot method, of class AI.
     * @author Rohit Gurnani
     */
    @Test
    public void testWho_toshoot() {
      ArrayList<Player> d= new ArrayList<>();
      ArrayList<Player> p= new ArrayList<>();
      AI test_1 = new AI();
      AI test_2 = new AI();
      String str = "Deputy";
      String str2 = "Sheriff";
      int shoot = test_1.who_toshoot(d,str);
      int shoot_2 = test_2.who_toshoot(p, str2);
      System.out.println(shoot);
      System.out.println(shoot_2);
    }

    /**
     * Test of who_toheal method, of class AI.
     */
    @Test
    public void testWho_toheal() {
        ArrayList<Player> p = new ArrayList<>();
        ArrayList<Player> d = new ArrayList<>();
        Player x = new Player("one");
        Player y = new Player("two");
        AI test_1= new AI();
        AI test_2= new AI();
        int one = test_1.who_toheal(p, x);
        int two = test_2.who_toheal(d, y);
        System.out.println(one);
        System.out.println(two);
         
     }

    /**
     * Test of selectDice method, of class AI.
     */
    @Test
    public void testSelectDice() {
      Player p = new Player("test");
      AI test = new AI();
      int d = test.selectDice(p);
      System.out.println(d);
      
    }
    
}
