/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

package project3;

import java.util.ArrayList;
import java.util.Collections;

/**
 CS 2365 Section 02
 Nathan Clough
 */
public class OldSaloon extends Game{

    /**
     *
     */
    public OldSaloon(){
        super();
    }

    /**
     *
     * @param num
     */
    public OldSaloon(int num){
        super(num);
    }
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

    /**
     *
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
     *
     * @return
     */
    public ArrayList<Dice> getDie(){
        return die;
    }                  
}
