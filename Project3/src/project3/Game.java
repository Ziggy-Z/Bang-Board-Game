package project3;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */
/*
* Notes for krystyna 
So your functions are at the bottomm of the class and all hava a comment with your name
The class as a whole cant run because it gets errors since it isnt linked with the other ones so to do your testing use 
test client game file and call them individually
I also added a player class so you can look at the values and check them in the test client 
line 140 is an example of how to change the values in player should be editing the arrows 


all of these functions should be relatively simple you will have to iterate through array list players for gattling and indian attack
use a for each loop to do that line 55 is an example 
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
    private boolean three = false;
    private int totalArrows = 9;
    private String winners;
    
    public Game(int numPlayers){  
        if(numPlayers == 3)
            three = true;
        for(int i =1; i <=numPlayers; i++)
        {
            Player p = new Player(i); 
            if(i == 1)
                p.setType("User");
            else
                p.setType("AI");
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
            if(getWinner(players))
                finished = true;
                
            i++;
        }
    }
    /**
     * Takes in a Player object and then runs through the rolls and applies any actions
     * @param p a 
     */
    private void takeTurn(Player p){
        int totalDynamite=0;
        int totalGat=0;
        int totalTwoShot=0;
        int totalOneShot=0;
        int totalBeer=0;
        int turnNum =1;
        boolean rollAgain = true;
        die.clear();
        createDie();
        // start the turn dialog 
        System.out.println("\n=====New Turn ======\n" + p.getRole() +":");
        ArrayList<Dice> rollingDie = (ArrayList<Dice>)die.clone();
        die.clear();
        do 
        {
            
            rollDie(rollingDie);
            //arrayList to iterate through since cannot itterate and edit at same time 
            ArrayList<Dice> temp = (ArrayList<Dice>)rollingDie.clone();
            for(Dice d: temp)
            {
                if(d.getResult().equals("Arrow"))
                {
                    p.setArrows(p.getArrows()+1);
                    totalArrows --;
                    if(totalArrows == 0)
                        IndianAttack();
                }
                else if(d.getResult().equals("Dynamite"))
                {
                    rollingDie.remove(d);
                    die.add(d);
                    totalDynamite++;
                }
                
                
            }
            temp.clear();
            //display the dice to the user
            Collections.sort(rollingDie);
            for(Dice d: die)
                System.out.print(d.getResult() + " ");
            System.out.print('-');
            for(Dice d: rollingDie)
                System.out.print(d.getResult() + " ");
            System.out.println();
            
            //System.out.println("  - Dynamite " + totalDynamite
            //resets the roling with the ones that 
            
            
            turnNum++;
            // calls roll againn which returns an array list of dice to rolll again or null if  they want to not continue 
            
        }while(turnNum <= 3 && totalDynamite < 3 && rollAgain);
        //displays final value of die 
        System.out.print("Final Dice:");
        for(Dice d: rollingDie)
            die.add(d);
        for(Dice d: die)
            System.out.print(d.getResult() + " ");
        performActions(p);
    }
    public boolean getWinner(ArrayList<Player> Players){
        //counts number of each player remaining 
        boolean sheriff = false;
        int numRenegade =0;
        int numOutlaw=0;
        int numDeputy=0;
        if(Players.size()==0)
        {
            winners="Outlaw";
            return true;
            
        }
        for(Player p: Players )
        {
            if(p.getRole().equals("Sheriff"))
                sheriff = true;
            else if(p.getRole().equals("Renegade"))
                numRenegade ++;
            else if(p.getRole().equals("Deputy"))
                numDeputy ++;
            else if(p.getRole().equals("Outlaw"))
                numOutlaw ++;
        }
        
        //if sheriff is in play count the number of outlaws and renegades to see if he wins 
        System.out.println(numRenegade);
        if(sheriff)
        {
            if(numOutlaw ==0 & numRenegade == 0)
            {
                winners = "Sheriff";
                return true;
            }
            else 
                return false;
        }
        else 
        {
            if(numRenegade == 1 && numOutlaw == 0 && numDeputy == 0)
            {
                winners = "Renegade";
                return true;
            }
            else 
               winners = "Outlaw";
               return true; 
        }       
    }
    private void performActions(Player p){
        int totalGat=0;
        int totalTwoShot=0;
        int totalOneShot=0;
        int totalBeer=0;
        for(Dice d :die)
            if(d.getResult().equals("One"))
                totalOneShot ++;
            else if(d.getResult().equals("Two"))
                totalTwoShot++;
            else if(d.getResult().equals("Beer"))
                totalBeer ++;
            else if(d.getResult().equals("Gatling"))
                totalGat++;
        
        for(int i=0; i<totalOneShot;i++)
        {
            oneShot(p.getType().shootWho(getOneAway(p)));     
        }
        for(int i=0; i<totalBeer;i++)
        {
            heal(p.getType().healWho(players));     
        }   
        for(int i=0; i<totalTwoShot;i++)
        {
            twoShot(p.getType().shootTwo(players));     
        }  
        if(totalGat >= 3)
            gatlingGun(p);
    }
    public String getWinners(){
        return winners;
    }
    public int getNumPlayers(){
        return players.size() + 1;
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }
    public void display(){
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
    
    /**
     * Performs Indian Attack
     * @author Krystyna Urbanczyk
     */
    public void IndianAttack(){
        //show indian attack
        for(Player t : players){
            t.setHealth(t.getHealth()-t.getArrows());
            t.setArrows(0);
            if(t.getHealth() <= 0)
                players.remove(t);
        }
            
    }
    /**
     * Performs an gatling gun shoots every player but the given Player p
     * @param p 
     * @author Krystyna Urbanczyk
     */
    public void gatlingGun(Player p){
        //show gat gun
        p.setArrows(0);
        for(Player t : players)
        {
            t.setHealth(t.getHealth()-1);
            if(p.getHealth() <= 0)
                players.remove(p);
        }
    }
    /** 
     * Shots given player who is one position away
     * @author Krystyna Urbanczyk
     */
    public void oneShot(Player p){
        p.setHealth(p.getHealth()-1);
        if(p.getHealth() <= 0)
            players.remove(p);
    }
    /** 
     * Shots given player who is two positions away
     * @author Krystyna Urbanczyk
     */
    public void twoShot(Player p){
        p.setHealth(p.getHealth()-1);
        if(p.getHealth() <= 0)
            players.remove(p);
        
    }
    /**
     * heals the given player 
     * @param p 
     * @author Krystyna Urbanczyk
     */
    public void heal(Player p){
        p.setHealth(p.getHealth()+1);
    }
    
    /**
     * gets all players one distance away from the parameter Player p 
     * @param p
     * @return 
     */
    public ArrayList<Player> getOneAway(Player p){
        ArrayList<Player> options = new ArrayList<Player>();
        int index = players.indexOf(p);
        if(index +1 == players.size())
            options.add(players.get(0));
        else
            options.add(players.get(index+1));
        if(index - 1 == -1)
            options.add(players.get(players.size()-1));
        else
            options.add(players.get(index-1));
        return options;
    }
     /**
     * gets all players two distance away from the parameter Player p 
     * @param p
     * @return 
     */
    public ArrayList<Player> getTwoAway(Player p){
        ArrayList<Player> options = new ArrayList<Player>();
        //gets player 2 ahead
        int index = players.indexOf(p);
        if(index + 2 == players.size())
            options.add(players.get(0));
        else if(index + 2 == players.size()+1)
            options.add(players.get(1));
        else 
            options.add(players.get(index+2));
        //gets player 2 behind 
        if(index - 2 == -1)
            options.add(players.get(players.size()-1));
        else if(index - 2 == -2 )
            options.add(players.get(players.size() - 2));
        else 
            options.add(players.get(index-2));
        return(options);
    }
}
