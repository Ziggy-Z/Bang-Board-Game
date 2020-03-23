package project3;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
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
    LinkedList<String> roles = new LinkedList<String>();
    LinkedList<Integer> characters = new LinkedList<Integer>();
    boolean finished;
    
    public Game(int numPlayers)
    {  
        
        for(int i =1; i <=numPlayers; i++)
        {
            Player p = new Player(i); 
            players.add(p); 
        }
        setupRoles();
        assignCharacters();
        
    }
    public void assignCharacters(){
        for (int i =1; i<=16; i++ )
           characters.add(i);
        Collections.shuffle(characters);
        for(Player t : players)
            t.setCharacter(characters.pop());
        
    }
    /**
     * Based on the number of players this method will create a list of roles 
     * then shuffle them and assign to the players
     */
    public void setupRoles(){
        //special rules for 3 people
        if(players.size() == 3)
        {
            roles.add("Deputy");
            roles.add("Renegade");
            roles.add("Outlaw");
        }
        else{
        //always have one sheriff
        roles.add("Sheriff");
        
        //one renegade unless there are 8 players
        roles.add("Renegade");
        if(players.size() > 7)
            roles.add("Renegade");
        
        //2 outlaws unless there is more than 5 players
        int numOutlaws = 2;
        if (players.size() > 5)
            numOutlaws ++;
        for (int i = 0; i< numOutlaws; i++)
            roles.add("Outlaw");
        
        //one deputy unles there are 7 or 8 players
        if(players.size() > 4)
            roles.add("Deputy");
        if(players.size() > 6)
            roles.add("Deputy");
                }
        //shuffles the list of roles 
        Collections.shuffle(roles);
                
        //takes a role and assigns it to each player
        for(Player t: players )
            t.setRole(roles.pop());

    }
    /**
     * Function for looping through the players arrayList and having each player take turn in order
     */
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
    public int getNumPlayers()
    {
        return players.size() + 1;
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }
    public void display()
    {
        for(Player t: players)
        {
            System.out.println(t.getValue());
        }
    }

}
