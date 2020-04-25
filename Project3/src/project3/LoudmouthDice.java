// CS 2365 OOP Section 002 Spring 2020 
//Krystyna Urbanczyk

package project3;

/**
 * Creates the Loudmouth dice to be used in Old Saloon Expansion
 * @author krystynaurbanczyk
 */
public class LoudmouthDice extends Dice{
    
    /**
     * Generates random numbers that are assigned to the dice face which simulates rolling dice.
     * @return result of dice roll
     */
    @Override
    public String rollDie(){
        
        int face = diceface.nextInt((6 - 1) + 1) + 1;
        this.dice = face;
        //int temp = 0;
        //Loudmouth Die is Risky, more damage chances
        switch (face) {                         
            case 1:
                result = "Indian Arrow";
                break;
            case 2:
                result = "Bullet";
                break;
            case 3:
                result = "Dynamite";
                break;
            case 4:
                result = "Double One";
                break;
            case 5:
                result = "Double Two";
                break;
            case 6:
                result = "Double Gatling";
                break;
            default:
                break;
        }
        
        return result;
    }
    
}
