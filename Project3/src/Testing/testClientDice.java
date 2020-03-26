// CS 2365 OOP Section 002 Spring 2020 
//Krystyna Urbanczyk


package Testing;

import project3.Dice;

/**
 * Creates 5 dice objects and rolls them each 3 times to make sure 
 * each re-roll actually gives a different random output.
 * @author krystynaurbanczyk
 */
public class testClientDice {
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
