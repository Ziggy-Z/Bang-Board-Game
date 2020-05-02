package project3;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

/**
 CS 2365 Section 02
 Nathan Clough
 */
/***
 * Game orchestrates the game and coordinates with AI to get decisions and board to display information
 * Contributors: Krystyna Urbanczyk
 * @author Nathan Clough
 * 
 */
public class Game {
    public ArrayList<Player> players = new ArrayList<Player>();
    public LinkedList<String> roles = new LinkedList<String>();
    public LinkedList<Integer> characters = new LinkedList<Integer>();
    public ArrayList<Dice> die = new ArrayList<Dice>();
    public boolean finished;
    public boolean three = false;
    public int totalArrows = 9;
    int start;
    private String winners;
    board B = new board();
    /***
     * Constructor for game object that takes in a number of players 
     * @author Nathan Clough
     * @param numPlayers 
     */
    public Game(){
        int numPlayers = 4;
        B.setVisible(true);
        B.pChoice(numPlayers-2);
        B.tArrow(9);
        
        
        for(int i =1; i <=numPlayers; i++)
        {
           if(numPlayers == 4){
                Player p = new Player("p"+((2*i)-1));
     
                players.add(p);
                
           }
           else if(numPlayers == 5){
                Player p = new Player("p"+((2*(i-1))));
                                if(i ==1 )
                p.setUser();
                players.add(p);

                
            }
           else if(numPlayers == 6){
                Player p = new Player("p"+((2*(i-1))));
      
                players.add(p);

           }
           else if(numPlayers == 7){
                Player p = new Player("p"+((i)));
                
           
                players.add(p);
           }
           else if(numPlayers == 8){
                Player p = new Player("p"+((i+1)));
                
                
           
                players.add(p);
           }
          
        }
        //creates the board gui with correct information
       
        setupRoles();
        assignCharacters();
        players.get(0).setUser();

 
    }
    /***
     * creates Game instance for testing purposes
     * @param numPlayers 
     */
    public Game(int numPlayers){                
        
        for(int i =1; i <=numPlayers; i++)
        {
           Player p = new Player("p"+i);
           players.add(p);
        }
        //creates the board gui with correct information
        
        setupRoles();
        assignCharacters();
        players.get(0).setUser();
        B.setVisible(true);
        B.pChoice(players);
        B.tArrow(9);
 
    }
    
    /***
     * Assigns each character a role 
     * @author Nathan Clough
     */
    public void assignCharacters(){
        characters.add(0);
        characters.add(5);
        characters.add(5);
        characters.add(7);
        characters.add(8);
        characters.add(7);
        characters.add(13);
        characters.add(14);
        Collections.shuffle(characters);
        for(Player t : players)
        {
            t.setCharacterTraits(characters.pop());
            B.setChar(t.getCharacter(),t.getNumber());
            B.update_Health(t.getHealth(), t.getNumber());
            
        }

    }
    /**
     * Based on the number of players this method will create a list of roles 
     * then shuffle them and assign to the players
     * @author Nathan Clough
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
        {

            t.setRole(roles.pop());
            if(t.getRole().equals("Sheriff"))
                     start = players.indexOf(t);
            B.setRole(t.getRole(),t.getNumber());
        }

    }
    /**
     * Function for looping through the players arrayList and having each player take turn in order
     * @author Nathan Clough
     */
    public void play() throws InterruptedException{
//loops through the list allowing to keep taking turns in the correct order
    int i = start;    
    do 
        {
            Thread.sleep(1200);
            if(i >= players.size() )
                i = 0;
            Player temp = players.get(i);
            takeTurn(temp);
            if(getWinner(players))
                finished = true;

            i++;
        }while(players.size() > 1 && finished != true);
     System.out.println(winners + " wins!!!!!!!");
    }
    /**
     * Takes in a Player object and then runs through the rolls and applies any actions
     * @param p a 
     * @author Nathan Clough
     */
    public void takeTurn(Player p){
        int totalDynamite=0;
        int turnNum =1;
        int maxRerolls = 3;
        if(p.getCharacter().equals("LUCKY DUKE"));
            maxRerolls =4;
        boolean rollAgain = true;
        die.clear();
        createDie();
        // start the turn dialog 
        System.out.println("\n=====New Turn ======\n" + p.getRole() + " " + p.getCharacter()+ ":");
        ArrayList<Dice> rollingDie = (ArrayList<Dice>)die.clone();
        die.clear();
        rollDie(rollingDie);
        do 
        {
            
           
            //arrayList to iterate through since cannot itterate and edit at same time 
            ArrayList<Dice> temp = (ArrayList<Dice>)rollingDie.clone();
            for(Dice d: temp)
            {
                if(d.getResult().equals("Arrow"))
                {
                    p.setArrows(p.getArrows()+1);
                    B.pArrow(p.getArrows(), p.getNumber());
                    totalArrows --;
                    B.tArrow(totalArrows);
                    if(totalArrows == 0)
                        IndianAttack();
                }
                else if(d.getResult().equals("Dynamite"))
                {
                    
                    rollingDie.remove(d);
                    die.add(d);
                    totalDynamite++;
                    if(totalDynamite >= 3)
                        break;
                }
                
                
            }
            temp.clear();
            //display the dice to the user
             Collections.sort(rollingDie);
            for(Dice d: die)
                System.out.print(d.getResult() + " ");
            System.out.println();
            for(Dice d: rollingDie)
                System.out.print(d.getResult() + " ");
            System.out.println();
            
            //System.out.println("  - Dynamite " + totalDynamite
            //resets the roling with the ones that 
            
            if(p.isAI())
            {
                AI ai = new AI();
                ArrayList<Integer> indecies = new ArrayList<Integer>();
                indecies = ai.rollagain(rollingDie, p.getRole() );
                
                 for(int i =0; i <rollingDie.size(); i++)
                {
                   if(!indecies.contains(i))
                   {
                       temp.add(rollingDie.get(i));
                   }
                   else 
                   {
                       Dice temporary = rollingDie.get(i);
                       temporary.rollDie();
                      temp.add(temporary);
                   }
                }
               rollingDie = (ArrayList<Dice>)temp.clone();;
            }
            else {
                UserOption instance = new UserOption(rollingDie,"dice");
                ArrayList<Integer> indecies = new ArrayList<Integer>();
                indecies = instance.getReroll();
                if(indecies.size() ==0)
                    rollAgain = false;
               for(int i =0; i <rollingDie.size(); i++)
                {
                   if(!indecies.contains(i))
                   {
                       temp.add(rollingDie.get(i));
                   }
                   else 
                   {
                       Dice temporary = rollingDie.get(i);
                       temporary.rollDie();
                      temp.add(temporary);
                   }
                }
               rollingDie = (ArrayList<Dice>)temp.clone();
            }
            turnNum++;
            if(rollingDie.size() == 0)
                rollAgain = false;
            // calls roll againn which returns an array list of dice to rolll again or null if  they want to not continue 
            
        }while(turnNum < maxRerolls && totalDynamite < 3 && rollAgain);
        if(totalDynamite>=3)
        {
            System.out.println("Explosion");
            p.setHealth(p.getHealth()-1);
            B.update_Health(p.getHealth(),p.getNumber());
           
        }
        //displays final value of die 
        System.out.print("Final Dice:");
        for(Dice d: rollingDie)
            die.add(d);
        for(Dice d: die)
            System.out.print(d.getResult() + " ");
        System.out.println();
        if(players.contains(p) && !getWinner(players))
            performActions(p);
    }
    /***
     * Given a  list of players it determines who the winner of the game is if conditions are met
     * @param Players
     * @return true if game is over false otherwise 
     */
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
        
        //if sheriff is in play count the  System.out.println(numRenegade);
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
    /***
     * Performs Actions of the dice by the given player 
     * @param p 
     * @author Nathan Clough
     */
    public void performActions(Player p){
        int totalGat=0;
        int totalTwoShot=0;
        int totalOneShot=0;
        int totalBeer=0;
        AI ai = new AI();
        for(Dice d :die)
            if(d.getResult().equals("One"))
                totalOneShot ++;
            else if(d.getResult().equals("Two"))
                totalTwoShot++;
            else if(d.getResult().equals("Beer"))
                totalBeer ++;
            else if(d.getResult().equals("Gatling"))
                totalGat++;
        if(p.getCharacter().equals("SUZY LAFAYETTE") && (totalOneShot == 0 && totalTwoShot == 0))
        {
            p.setHealth(p.getHealth()+2);
            B.update_Health(p.getHealth(), p.getNumber());
        }
        for(int i=0; i<totalOneShot;i++)
        {
            ArrayList<Player> options = getOneAway(p);
            if(p.isAI())
            {
                
                int x = ai.who_toshoot(options,p.getRole());
                oneShot(options.get(x));
                if(getWinner(players))
                    break;
            }
            else
            {   
                UserOption ChooseWho = new UserOption(options);
                int x = ChooseWho.shootWho();
                oneShot(options.get(x));
                if(getWinner(players))
                    break;
            }
        }
        if(!getWinner(players))
        {    if(p.isAI())
            {
                int x = ai.who_toheal(players,p);
                if(x == -2)
                {
                  //
                }
                else if(x == -1)
                      heal(p);
                else
                  heal(players.get(x));
            }
        else{
            UIWhoToHeal h = new UIWhoToHeal(players);
            int x = h.healPlayer();
            if(x == -1)
            {
                
            }
            else{
                heal(players.get(x));
            }
        }
        }
        if(!getWinner(players)){
        for(int i=0; i<totalTwoShot;i++)
        {
            ArrayList<Player> options = new ArrayList<Player>();
            if (players.size() <= 4)
                {
                    options = getOneAway(p);
                }
                else
                     options = getTwoAway(p);
            if(p.isAI())
            { 
                int x = ai.who_toshoot(options,p.getRole());
                twoShot(options.get(x));
                if(getWinner(players))
                    break;
            } 
            else
            {   
                UserOption ChooseWho = new UserOption(options);
                int x = ChooseWho.shootWho();
                twoShot(options.get(x));
                if(getWinner(players))
                    break;
            }
        }  
        }
        if(!getWinner(players))
        {
            if(totalGat >= 3)
                gatlingGun(p);
        }
    }
    
    
    /**
     * creates the list of dice objects to use when taking a turn
     * @author Nathan Clough
     */
    private void createDie(){
       for(int i =0; i<5;i++){
           Dice d = new Dice();
           die.add(d);
       }
    }

    /**
     * Takes an ArrayList of dice and rolls them all
     * @param rerolling
     * @return 
     * @author Nathan Clough
     */
    public ArrayList<Dice> rollDie(ArrayList<Dice> rerolling ){
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
        System.out.println("Indian Attack");
        totalArrows = 9;
        B.tArrow(totalArrows);
       
        for(int i = 0; i<players.size(); i++){
            Player t = players.get(i);
                if(t.getCharacter().equals("JOURDONNAIS"))
                {
                    int damage = t.getArrows();
                    if(damage > 1)
                        damage = 1;
                    t.setHealth(t.getHealth()-damage);
                    B.update_Health(t.getHealth(), t.getNumber());
                    t.setArrows(0);
                    B.pArrow(t.getArrows(), t.getNumber());
                }
                else
                {
                    
                    t.setHealth(t.getHealth()-t.getArrows());
                    B.update_Health(t.getHealth(), t.getNumber());
                    t.setArrows(0);
                    B.pArrow(t.getArrows(), t.getNumber());
                }
            if(t.getHealth() <= 0)
            {
                players.remove(t);
                if(getWinner(players))
                    break;
            }
        }
            
    }
    /**
     * Performs an gatling gun shoots every player but the given Player p
     * @param p 
     * @author Krystyna Urbanczyk
     */
    public void gatlingGun(Player p){
        //show gat gun
        System.out.println("Gattling Gun");
        totalArrows += p.getArrows();
        B.tArrow(totalArrows);
        p.setArrows(0);
        B.pArrow(p.getArrows(), p.getCharacter());
        
        for(Player t : players)
        {
            if(!t.getNumber().equals(p.getNumber() ))
            {
                if(!t.getCharacter().equals("PAUL REGRET" ) )
                {
                        oneShot(t);
                }
            }
        }
    }
    /** 
     * Shots given player who is one position away
     * @author Krystyna Urbanczyk
     */
    public void oneShot(Player p){
        if(p.getCharacter().equals("BART CASSIDY") && totalArrows != 1)
        {
                totalArrows--;
                p.setArrows(p.getArrows()+1);
                B.pArrow(p.getArrows(), p.getNumber());
        }
        else{
        p.setHealth(p.getHealth()-1);
        B.update_Health(p.getHealth(), p.getNumber());
        System.out.println("Player " + p.getNumber() + " was shot by 1shot");

        }
        if(p.getHealth() <= 0)
            players.remove(p);
    }
    /** 
     * Shots given player who is two positions away
     * @author Krystyna Urbanczyk
     */
    public void twoShot(Player p){
        if(p.getCharacter().equals("BART CASSIDY") && totalArrows != 1)
        {
                totalArrows--;
                p.setArrows(p.getArrows()+1);
                B.pArrow(p.getArrows(), p.getNumber());
        }
        else{
        p.setHealth(p.getHealth()-1);
        B.update_Health(p.getHealth(), p.getNumber());
        System.out.println("Player " + p.getNumber() + " was shot by 2shot");

        }
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
        B.update_Health(p.getHealth(), p.getNumber());
        System.out.println("Player " + p.getNumber() + " was healed");
    }
    /**
     * gets all players one distance away from the parameter Player p 
     * @param p
     * @return list of players one distance away
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
        {
            options.add(players.get(index-1));
        }
        return options;
    }
     /**
     * gets all players two distance away from the parameter Player p 
     * @param p
     * @return list of players two distance away 
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
    
    // Functions to aid with testing by allowing to set up specific situations 
    public String getWinners(){
        return winners;
    }
    public int getTotalArrows(){
        return totalArrows;
    }
    public void setTotalArrows(int ta){
        totalArrows = ta;
    }
    public int getNumPlayers(){
        return players.size();
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }
    public void display(){
        for(Player t: players)
        {
            System.out.println(t.getNumber());
        }
    }
    public void setPlayers( ArrayList<Player> newPlayers ){
        players = newPlayers;
    }
    public void setDie(ArrayList<Dice> dices){
        die = dices;
    }
    
}
