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
public class Duel {
       static UndeadorAliveDice temp = new UndeadorAliveDice();
       static Token tokens = new Token();
       static boolean win = false;
       
    public static void performDuel(Player p, ArrayList<Player> players){
            DuelUI d = null;
            String s = "Duel";
            Player c = null;
           if(!p.isAI()){
               d=new DuelUI();
               d.setVisible(true);
                for(Player temp: players){
                    if(d.Splayer.equals(temp.getNumber())){
                        c = temp;
                } 
           }
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
                WinnerUI w = new WinnerUI(win);
                c.addToken(tokens.drawToken());
            }
            else
            {
                WinnerUI w = new WinnerUI(win);
                String drawnToken = tokens.drawToken();
                p.addToken(drawnToken);
                    w.showToken(drawnToken);

            }
   
        
    }
    }
