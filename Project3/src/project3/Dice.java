// CS 2365 OOP Section 002 Spring 2020 
//Krystyna Urbanczyk

package project3;
import java.util.Random;

/**
 *
 * @author krystynaurbanczyk
 */

public class Dice {
    
    public int dice;
    public String result;
    
    public Dice(){
        dice = 0;
        result = null;
    }
    
    public String rollDie(){
        
        Random diceface = new Random();
        int face = diceface.nextInt((6 - 1) + 1) + 1;
        
        //int temp = 0;
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
    
    public String getResult(){
        return result;
    }
    
}
