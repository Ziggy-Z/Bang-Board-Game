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
       static UndeadorAliveDice temp = new UndeadorAliveDice();
       static Token tokens = new Token();
       static boolean win = false;
    public static void performDuel(Player p, ArrayList<Player> players){
        //prompt player to choose person
            //if user use UI 
            //if ai just select random that isnt p
        
        Player c = new Player("");
        String s = "Duel";
        
       
            while(s == "Duel")
            {
                win = !win;
                s = temp.rollDie();
                //show in the User Interface 
            }
           
            if(win)
            {
                //says you win in User Interface
                //add token to  
                c.addToken(tokens.drawToken());
            }
            else
            {
                //says you Lose in User Interface
                //Show what token they draw
                //add token to p
                String drawnToken = tokens.drawToken();
                p.addToken(drawnToken);
              
            }
   
        
    }
    }
