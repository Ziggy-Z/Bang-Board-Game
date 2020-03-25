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
    private ArrayList<Player> players = new ArrayList<Player>();
    private LinkedList<String> roles = new LinkedList<String>();
    private LinkedList<Integer> characters = new LinkedList<Integer>();
    private ArrayList<Dice> die = new ArrayList<Dice>();
    private boolean finished;
    private int totalArrows;
    
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
    /**
     * assigns a character to each player in the game
     */
    private void assignCharacters(){
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
    private void setupRoles(){
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
    /**
     * Takes in a Player object and then runs through the rolls and applies any actions
     * @param p a 
     */
    private void takeTurn(Player p)
    {
        int totalDynamite=0;
        int totalGat=0;
        int totalTwoShot=0;
        int totalOneShot=0;
        int totalBeer=0;
        int turnNum =1;
        boolean rollAgain = false;
        die.clear();
        createDie();
        // start the turn dialog 
        System.out.println("\n=====New Turn ======\n" + p.getRole() +":");
        ArrayList<Dice> rollingDie = (ArrayList<Dice>)die.clone();
        do 
        {
            
            rollDie(rollingDie);
            ArrayList<Dice> temp = (ArrayList<Dice>)rollingDie.clone();
            for(Dice d: rollingDie)
            {
                if(d.getResult().equals("Arrow"))
                {
                    p.setTotalArrows(p.getTotalArrows()+1);
                    totalArrows --;
                    if(totalArrows == 0)
                        IndianAttack();
                }
                else if(d.getResult().equals("Dynamite"))
                {
                    totalDynamite++;
                }
                else if(d.getResult().equals("Gatling"))
                {
                    totalGat++;
                    if(totalGat >= 3 )
                        gatlingGun(p);
                }
                
            }
            //display the dice to the user
            Collections.sort(temp);
            for(Dice d: temp)
                System.out.print(d.getResult() + " ");
            //System.out.println("  - Dynamite " + totalDynamite);
            
            int [] input = p.rollAgain(temp);
            //resets the roling with the ones that 
            
            temp.clear();
            turnNum++;
            // calls roll againn which returns an array list of dice to rolll again or null if  they want to not continue 
            
        }while(turnNum <= 3 && totalDynamite < 3 && rollAgain);
        
    }
    private void performActions(Player p, ArrayList<Dice> die){
        
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
    /**
     * creates the list of dice objects to use when taking a turn
     */
    private void createDie(){
        for(int i =0; i<5; i++)
        {
            Dice d = new Dice();
           // d.rollDie();
            die.add(d);
        }

    }
    /**
     * Rolls all the die in the linked list
     */
    private void rollDie(){
        for(Dice d: die)
            d.rollDie();
    }
    /**
     * Takes an ArrayList of dice and rolls them all
     * @param rerolling
     * @return 
     */
    private ArrayList<Dice> rollDie(ArrayList<Dice> rerolling ){
        for(Dice d: rerolling )
            d.rollDie();
        return rerolling;
    }
    private void IndianAttack(){
        //show indian attack
    }
    private void gatlingGun(Player p){
        //show gat gun
    }
}
