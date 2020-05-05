/*
 * CS 2365 OOP Spring 2020
 * Zegedam Zegeye
 */
package project3;

import static java.lang.Integer.max;
import java.util.ArrayList;

/**
 *
 * @author zeged
 */
public class Duel{
       static UndeadorAliveDice temp = new UndeadorAliveDice();
       static Token tokens = new Token();
       
       
    public static Player performDuel(Player p, ArrayList<Player> players){
            boolean win = false;
           
            String s = "Duel";
            Player c = null;
           if(!p.isAI()){
               UIWhoToHeal d = new UIWhoToHeal(players,"Choose who to Duel");
                c = players.get(d.healPlayer());
                 
           }
           else{
               int max = players.size()-1;
               int min = 0;
               int random;
               do{
                   random =  (int) ((Math.random() * ((max - min) + 1)) + min);
            }while(!players.get(random).getNumber().equals(p.getNumber()));
               c=players.get(random);
           }
            
           while(s == "Duel")
            {
                win = !win;
                s = temp.rollDie();
                System.out.println(s);
            }
            
            if(win)
            {
                
                String t = tokens.drawToken();
                c.addToken(t);
                c.setHealth(c.getHealth()-1);
                WinnerUI w = new WinnerUI(win,p.getNumber(),t);
            }
            else
            {
                
                String drawnToken = tokens.drawToken();
                p.addToken(drawnToken);
                p.setHealth(p.getHealth()-1);
                WinnerUI w = new WinnerUI(win,c.getNumber(),drawnToken);

            }
            return c;
   
        
    }
    }
