/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

package project3;

import java.util.ArrayList;
import java.util.Collections;

/**
 CS 2365 Section 02
 @Author Nathan Clough
 * Contributors - Joseph Mclaine : added in cheifs arrow functionality
 *     this class is an extension of the original game and implements the old saloon expansion pack         
 */
public class OldSaloon extends Game{
ChiefArrow arrow = new ChiefArrow();
public int totalArrows = 10;
    public OldSaloon(){
        super();
    }
    public OldSaloon(int num){
        super(num);
    }
    /***
     * Override of the original game function to add the new players 
     */
    @Override
    public void assignCharacters(){
        characters.add(0);
        characters.add(5);
        characters.add(7);
        characters.add(8);
        characters.add(7);
        characters.add(13);
        characters.add(15);
        characters.add(16);
        Collections.shuffle(characters);
        for(Player t : players)
        {
            t.setCharacterTraits(characters.pop());
            B.setChar(t.getCharacter(),t.getNumber());
            B.update_Health(t.getHealth(), t.getNumber());
            
        }

    }
    /***
     * @author Nathan Clough 
     * takes in a player object and performs necessary actions based on the final dice 
     * @param p 
     */
    @Override
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
            else if(d.getResult().equals("Double One"))
                totalOneShot +=2;
            else if(d.getResult().equals("Double Two"))
                totalTwoShot+=2;
            else if(d.getResult().equals("Double Beer"))
                totalBeer +=2;
            else if(d.getResult().equals("Double Gatling"))
                totalGat+=2;
        if(p.getCharacter().equals("SUZY LAFAYETTE") && (totalOneShot == 0 && totalTwoShot == 0))
        {
            p.setHealth(p.getHealth()+2);
            B.update_Health(p.getHealth(), p.getNumber());
        }
        if(p.getCharacter().equals("DOC HOLYDAY") && (totalOneShot + totalTwoShot) >= 3 && !(p.isFullHealth()) ){
            p.setHealth(p.getHealth()+2);
            B.update_Health(p.getHealth(),p.getNumber());
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
        {
            for(int i=0; i<totalBeer;i++)
            {
              if(p.isAI())
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
                else
                {
                        UIWhoToHeal h = new UIWhoToHeal(players);
                        int x = h.healPlayer();
                        if(x == -1)
                        {
                
                        }
                        else
                        {
                            heal(players.get(x));
                        }
                }   
            }   
        }
        if(!getWinner(players)){
        for(int i=0; i<totalTwoShot;i++)
        {
            ArrayList<Player> options = new ArrayList<Player>();
             if (players.size() <=4)
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
    /***
     * @author Nathan Clough
     * takes in a player object and allows them to take their turn rerolling dice as neccessary 
     * @param p 
     */
    @Override
    public void takeTurn(Player p){
        int totalDynamite=0;
        int turnNum =1;
        int maxRerolls = 3;
        if(p.getCharacter().equals("LUCKY DUKE"));
            maxRerolls =4;
        boolean rollAgain = true;
        die.clear();
        createDie(p);
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
                    if (arrow.getArrow()==1)
                    {
                        p.setChief_Arrow(true);
                    }
                    p.setArrows(p.getArrows()+1);
                    B.pArrow(p.getArrows(), p.getNumber());
                    totalArrows --;
                    B.tArrow(totalArrows);
                    if(totalArrows == 0)
                        IndianAttack();
                }
                else if(d.getResult().equals("Broken Arrow"))
                {
                    int playerArrows = p.getArrows();
                    if(playerArrows>1)
                    {
                        p.setArrows(playerArrows -1);
                    }
                    B.pArrow(p.getArrows(), p.getNumber());
                }
                else if(d.getResult().equals("Bullet")){
                    p.setHealth(p.getHealth() -1);
                    B.update_Health(p.getHealth(), p.getNumber());
                    
                    if(p.getHealth() <= 0)
                    {
                        players.remove(p);
                        if(getWinner(players));
                            break;
                    }
                    
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
        System.out.println();
        for(Dice d: die)
            System.out.print(d.getResult() + " ");
        System.out.println();
        if(players.contains(p)&& !getWinner(players))
            performActions(p);
    }
    /***
     * takes a player object and allows them to select the dice they want to use for their turn 
     * @param p 
     */
    public void createDie(Player p){
        int totalDice = 5;
        
        if(p.isAI())
       {
           
           AI ai = new AI();
           int selection = ai.selectDice(p);
           LoudmouthDice L = new LoudmouthDice();
           CowardDice C = new CowardDice();
           int count =0;
           
           if (selection == 1)
           {
               die.add(C);
               count ++;
           }
           else if(selection == 2)
           {
                   if(!p.getCharacter().equals("JOSE DELGADO"))
                   {           
                        die.add(L);
                        count++;
                    }
                   else 
                   {
                   die.add(L);
                   
               }
           }
           else if(selection == 3)
           {
               if(!p.getCharacter().equals("JOSE DELGADO"))
                   {           
                        die.add(L);
                        count++;
                    }
                   else 
               {
                   die.add(L);
                   
               }
               die.add(C);
               count ++;
               
           }
           while(count <totalDice )
           {
               Dice d = new Dice();
               die.add(d);
               count ++;
           }
       }
       else
       {
           UserSelectDice u = new UserSelectDice();
           boolean  selected [] = u.getUserSelectedDice();
           int count = 0;
           if(selected[0] == true)
           {
               if(!p.getCharacter().equals("JOSE DELGADO"))
                {
                   count ++; 
                }
               LoudmouthDice d = new LoudmouthDice();
               die.add(d);
              
           }
           if(selected[1] == true)
           {
               CowardDice d = new CowardDice();
               die.add(d);
               count ++;
           }
           while(count <totalDice )
           {
               Dice d = new Dice();
               die.add(d);
               count ++;
           }
           
       }
    }
    /**
     * used for testing to manipulate the dice in the game 
     * @return 
     */
    public ArrayList<Dice> getDie(){
        return die;
    }
    /***
     * Indian attack function that accounts for cheifs arrow 
     * @author Joey mcclain
     */
    @Override
        public void IndianAttack(){
        //show indian attack
        System.out.println("Indian Attack");
        totalArrows = 10;
        B.tArrow(totalArrows);
       int Chief_Arrows=0;
       int flag=0;
        for (int i = 0; i<players.size(); i++)
        {
            Player t = players.get(i);
            if (t.isChief_Arrow()==true)
            {
                Chief_Arrows=t.getArrows();
            }
        }
        for (int i = 0; i<players.size(); i++)
        {
            Player t = players.get(i);
            if (t.getArrows() > Chief_Arrows)
            {
                flag=1;
            }
        }
        for (int i = 0; i<players.size(); i++)
        {
            Player t = players.get(i);
            if (t.isChief_Arrow()==true&& flag ==0)
            {
                t.setArrows(0);
                t.setChief_Arrow(false);
            }
            else
                if (t.isChief_Arrow()==true)
                {
                    t.setChief_Arrow(false);
                    t.setArrows(t.getArrows()+1);
                }
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
            arrow.Reset_Arrows();
            if(t.getHealth() <= 0)
            {
                players.remove(t);
                if(getWinner(players))
                    break;
            }
        }
    }
}
