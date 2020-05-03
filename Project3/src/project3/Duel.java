/*
 * CS 2365 OOP Spring 2020
 * Zegedam Zegeye
 */
package project3;

import java.util.ArrayList;

/**
 *
 * @author zeged
 */
public class Duel {
       UndeadorAliveDice temp = new UndeadorAliveDice();
    public Duel(){
        if(temp.rollDie().equals("Duel")){
            while(temp.getResult() == "Duel"){
                temp.rollDie();
        }
            
     }
    }
