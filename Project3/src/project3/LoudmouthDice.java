/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.Random;

/**
 *
 * @author krystynaurbanczyk
 */
public class LoudmouthDice extends Dice{
    
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
    public LoudmouthDice(){
        dice = diceface.nextInt((6 - 1) + 1) + 1;
        result = null;
    }
    
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
