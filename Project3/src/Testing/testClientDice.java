// CS 2365 OOP Section 002 Spring 2020 
//Krystyna Urbanczyk


package Testing;

import project3.Dice;

/**
 *
 * @author krystynaurbanczyk
 */
public class testClientDice {
    //create a function that makes 5 dice and roll them 3 times displaying output
    //call this function from Project3.java 
    public testClientDice(){
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        
        for(int i = 0; i < 3; i++){
            System.out.println(dice1.rollDie());
            System.out.println(dice2.rollDie());
            System.out.println(dice3.rollDie());
            System.out.println(dice4.rollDie());
            System.out.println(dice5.rollDie());
            System.out.println("---------------");
        }
    }
}
