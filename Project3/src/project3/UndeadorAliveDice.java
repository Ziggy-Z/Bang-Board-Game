// CS 2365 OOP Section 002 Spring 2020 
//Krystyna Urbanczyk

package project3;

/**
 * Creates the dice to be used in Undead or Alive Expansion
 * @author krystynaurbanczyk
 */
public class UndeadorAliveDice extends Dice{
    
    /**
     * Generates random numbers that are assigned to the dice face which simulates rolling dice.
     * @return result of dice roll
     */
    @Override
    public String rollDie(){
        
        int face = diceface.nextInt((6 - 1) + 1) + 1;
        this.dice = face;
        //int temp = 0;
        //Look me in the Eyes Dice have two duel faces on each die
        switch (face) {
            case 1:
                result = "Indian Arrow";
                break;
            case 2:
                result = "Dynamite";
                break;
            case 3:
                result = "Whiskey";
                break;
            case 4:
                result = "Gatling";
                break;
            case 5:
                result = "Duel";
                break;
            case 6:
                result = "Duel";
                break;
            default:
                break;
        }
        
        return result;
    }
}
