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
public class Undead extends Game{

    /**
     *
     */
    public ArrayList<Player> totalPlayers;

    /**
     *
     */
    public boolean outbreak;

    /**
     *
     */
    public BoneYardCard deck = new BoneYardCard();

    /**
     *
     */
    public Undead(){
        super();
    }

    /**
     *
     * @param num
     */
    public Undead(int num){
        super(num);
    }
    @Override
    public void assignCharacters(){
        
        characters.add(0);
        characters.add(5);
        characters.add(5);
        characters.add(7);
        characters.add(8);
        characters.add(7);
        characters.add(13);
        characters.add(14);
        characters.add(18);
        characters.add(19); 
        
       
        Collections.shuffle(characters);
        for(Player t : players)
        {
            t.setCharacterTraits(characters.pop());
            B.setChar(t.getCharacter(),t.getNumber());
            B.update_Health(t.getHealth(), t.getNumber());
            
        }
        
    }
    @Override
    public void play() throws InterruptedException{
//loops through the list allowing to keep taking turns in the correct order
    totalPlayers = (ArrayList<Player>)players.clone();
    int i = start;    
    do 
        {
            Thread.sleep(1200);
            if(i >= totalPlayers.size() )
                i = 0;
            Player temp = totalPlayers.get(i);
            if(!temp.isZombie())
            {
                takeTurn(temp);
                if(getWinner(players))
                    finished = true;
            }
            else
            {
                
                deck.drawCard();
                System.out.println("ZOMBIE HANDS" + deck.getTotalHands() + '\n' + "Players remaining" + players.size());
                if(deck.getTotalHands() >= players.size())
                {
                    outbreak = true;
                    System.out.println("outbreak");
                    finished = true;
                }
            }
            


            i++;
        }while(totalPlayers.size() > 1 && finished != true);
    if(outbreak)
    {
        playOutbreak(i);
    }
    else{
        System.out.println(winners + " wins!!!!!!!");
    }
    }

    /**
     *
     * @param i
     * @throws InterruptedException
     */
    public void playOutbreak(int i ) throws InterruptedException{
        
       setupOutbreak();
        do 
        {
            Thread.sleep(1200);
            if(i >= players.size() )
                i = 0;
            Player temp = players.get(i);
            takeOutbreakTurn(temp);
            if(getWinner(players))
                finished = true;

            i++;
        }while(players.size() > 1 && finished != true);
        
        System.out.println(winners + " win!!!");
    }

    /**
     *
     */
    public void setupOutbreak(){
       finished = false;
       for(Player p: totalPlayers)
       {
           if(p.getRole().equals("Renegade") && !p.isZombie())
                   p.setRole("Zombie Master");
           if(p.isZombie())
           {
               
               p.setHealth(players.size());
               
           }
           
       }
       players = (ArrayList<Player>)totalPlayers.clone();
       B.pChoice(players);
       OutBreakNotification on = new OutBreakNotification();
       
       
           
    }

    /**
     *
     * @param p
     */
    public void takeOutbreakTurn(Player p){
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
            
            //display the dice to the user
            Collections.sort(rollingDie);
            System.out.println("Roll: " + turnNum );
             for(Dice d: die)
                System.out.print(d.getResult() + " ");
            for(Dice d: rollingDie)
                System.out.print(d.getResult() + " ");
            System.out.println();
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
    @Override
    public void createDie(){
       for(int i =0; i<5;i++){
           if(i<2){
              UndeadorAliveDice d = new UndeadorAliveDice();
              die.add(d);
           }
           else{
               Dice d = new Dice();
               die.add(d);
           }
           
       }
    }

    /**
     *
     * @param p
     */
    public void createDie(Player p){
        int totalDice=5;
        if(p.isZombie())
            totalDice = 3;
        for(int i =0; i<totalDice; i ++){
            if(i<3)
            {
                Dice d = new Dice();
                die.add(d);
            }
            else
            {
                UndeadorAliveDice d = new UndeadorAliveDice();
                die.add(d);
            }
        }
    }
    @Override
    public boolean getWinner(ArrayList<Player> Players){
        //counts number of each player remaining 
        if(outbreak)
        {
            int numZombies=0;
            int numAlive =0;
            for(Player p: Players)
            {
                if(p.isZombie())
                    numZombies ++;
                else
                    numAlive ++;
            }
            if(numAlive <= 0)
            {
                winners = "Zombies";
                return true;
            }
            if(numZombies <= 0)
            {
                winners = "Survivors";
                return true;
            }
            return false;
        }
        else{
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
    }
    @Override
    public void takeTurn(Player p){
        int totalDynamite=0;
        int turnNum =1;
        int maxRerolls = 3;
        if(p.hasToken("Dynamite")){
            totalDynamite ++;
        }
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
                    {
                        IndianAttack();
                        if(finished == true || p.getHealth() <= 0)
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
                else if(d.getResult().equals("Whiskey")){
                    int totalMultiplier = 1;
                    if(p.getCharacter().equals("GREG DIGGER")){
                            totalMultiplier = totalMultiplier *2;
                     }
                    for(int i = 0; i < totalMultiplier; i++){
                       if(p.hasToken()){
                           p.removeToken();
                           
                       }
                       
                    }
                    
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
    @Override
    public void performActions(Player p){
        int totalGat=0;
        int totalTwoShot=0;
        int totalOneShot=0;
        int totalBeer=0;
        int totalDuel=0;
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
            else if(d.getResult().equals("Duel"))
                totalDuel ++;

        if(p.hasToken("One")){
            totalOneShot --;
        }
        if(p.hasToken("Two")){
            totalTwoShot --;
        }
        if(p.hasToken("Beer")){
            totalBeer --;
        }
   
        

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
                if(outbreak)
                    x = UndeadAI.whoToShoot(options, p);
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
        {   for(int i =0; i<totalBeer; i++){
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
                if(outbreak)
                    x = UndeadAI.whoToShoot(options, p);
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
        if(!getWinner(players)){
            for(int i =0; i<totalDuel; i++)
            {
                if(p.getCharacter().equals("SAM THE HEALER") && p.getHealth() >=1){
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
               Player c = Duel.performDuel(p, players);
               B.update_Health(p.getHealth(),p.getNumber());
               B.update_Health(p.getHealth(), p.getNumber());
               if(getWinner(players))
               {
                   break;
               }
            }
        }
    }
     
}
