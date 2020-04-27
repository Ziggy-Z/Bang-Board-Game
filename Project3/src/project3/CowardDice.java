// CS 2365 OOP Section 002 Spring 2020 
//Krystyna Urbanczyk

package project3;

/**
 * Creates the Coward dice to be used in Old Saloon Expansion
 * @author krystynaurbanczyk
 */
public class CowardDice extends Dice{
    
    /**
     * Generates random numbers that are assigned to the dice face which simulates rolling dice.
     * @return result of dice roll
     */
    @Override
    public String rollDie(){
        
        int face = diceface.nextInt((6 - 1) + 1) + 1;
        this.dice = face;
        //int temp = 0;
        //Coward Die is Safe, more health chances                       
        switch (face) {                         
            case 1:
                result = "Arrow";
                break;
            case 2:
                result = "Broken Arrow";
                break;
            case 3:
                result = "Dynamite";
                break;
            case 4:
                result = "One";
                break;
            case 5:
                result = "Beer";
                break;
            case 6:
                result = "Double Beer";
                break;
            default:
                break;
        }
        
        return result;
    }
    
}
