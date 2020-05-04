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
            DuelUI d = new DuelUI();
            d.setVisible(true);
            //if user use UI 
            //if ai just select random that isnt p
        Player c = new Player(d.Splayer);
        String s = "Duel";
        WinnerUI w = new WinnerUI();
            while(s == "Duel")
            {
                win = !win;
                s = temp.rollDie();
                d.setVisible(true);
            }
           
            if(win)
            {
                w.win();
                w.setVisible(true);
                c.addToken(tokens.drawToken());
            }
            else
            {
                w.lose();
                w.setVisible(true);
                String drawnToken = tokens.drawToken();
                p.addToken(drawnToken);
                if(w.ext1==true){
                    w.showToken(drawnToken);
                }
            }
   
        
    }
    }
