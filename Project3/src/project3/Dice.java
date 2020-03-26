// CS 2365 OOP Section 002 Spring 2020 
//Krystyna Urbanczyk

package project3;
import java.util.Random;

/**
 * Creates the dice to be used in the game.
 * @author krystynaurbanczyk
 */

public class Dice {
    
    /**
     * initializes dice value
     */
    private int dice;

    /**
     * stores the result of the dice roll
     */
    private String result;
    
    Random diceface = new Random();
    
    /**
     * default constructor, initializes dice to a random value
     */
    public Dice(){
        dice = diceface.nextInt((6 - 1) + 1) + 1;
        result = null;
    }
    
    /**
     * Generates random numbers that are assigned to the dice face which simulates rolling dice.
     * @return result of dice roll
     */
    public String rollDie(){
        
        int face = diceface.nextInt((6 - 1) + 1) + 1;
        
        switch (face) {
            case 1:
                result = "Arrow";
                break;
            case 2:
                result = "Dynamite";
                break;
            case 3:
                result = "One";
                break;
            case 4:
                result = "Two";
                break;
            case 5:
                result = "Gatling";
                break;
            case 6:
                result = "Beer";
                break;
            default:
                break;
        }
        
        return result;
    }
    
    /**
     * Used for other classes to get result.
     * @return result of dice roll
     */
    public String getResult(){
        return result;
    }
    
}
