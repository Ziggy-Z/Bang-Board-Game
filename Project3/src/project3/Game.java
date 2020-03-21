package project3;
import java.util.ArrayList;
import java.util.ListIterator;
/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

/**
 CS 2365 Section 02
 Nathan Clough
 */
public class Game {
    ArrayList<Player> players = new ArrayList<Player>();
    boolean finished;
    
    public Game(int numPlayers)
    {  
        for(int i =1; i <=numPlayers; i++)
        {
            Player p = new Player(i); 
            players.add(p); 
            
               
        }
    }
    public void play(){
//loops through the list allowing to keep taking turns in the correct order
    int i = 0;    
    while(players.size() > 1 && finished != true)
        {
            if(i == players.size() )
                i = 0;
            
            Player temp = players.get(i);
            
            takeTurn(temp);
            
            i++;
        }
    }
    private void takeTurn(Player p)
    {
        
        if(p.getValue() == 3)
        {
            players.remove(players.indexOf(p) +2);
            finished = true;
        }
        
    }
    public void display()
    {
        for(Player t: players)
        {
            System.out.println(t.getValue());
        }
    }

}
