/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

package project3;

import java.util.ArrayList;

/**
 CS 2365 Section 02
 Nathan Clough
 */
public class UndeadAI {

    /**
     *
     * @param options
     * @param p
     * @return
     */
    public static int whoToShoot(ArrayList<Player> options, Player p){
    int shoot;
    boolean zombieStat [] = new boolean[2];
    boolean playerIsZombie = p.isZombie();
    
    for(Player temp: options)
    {
    zombieStat [0] = temp.isZombie();
    }
    int i = 0;
    for(boolean targetIsZombie: zombieStat){
        
        if(playerIsZombie && !targetIsZombie)
        {
            return i;
        }
        if(!playerIsZombie && targetIsZombie)
        {
            return i; 
        }
        i++;
    }
    return 0;
    
}
}
