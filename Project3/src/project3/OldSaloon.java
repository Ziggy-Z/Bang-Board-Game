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

    public OldSaloon(){
        super();
    }
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
        if(p.getCharacter().equals("SUZY LAFAYETTE") && (totalOneShot == 0 && totalTwoShot == 0))
        {
            p.setHealth(p.getHealth()+2);
            B.update_Health(p.getHealth(), p.getNumber());
        }
        if(p.getCharacter().equals("DOC HOLYDAY") && (totalOneShot + totalTwoShot) >= 3){
            p.setHealth(p.getHealth()+2);
            B.update_Health(p.getHealth(),p.getNumber());
        }
        for(int i=0; i<totalOneShot;i++)
        {
            if(p.isAI())
            {
                ArrayList<Player> options = getOneAway(p);
                int x = ai.who_toshoot(options,p.getRole());
                oneShot(options.get(x));
                if(getWinner(players))
                    break;
            }     
        }
        if(!getWinner(players))
        {
            for(int i=0; i<totalBeer;i++)
            {
              int x = ai.who_toheal(players,p.getRole());
              if(x == -1)
                  heal(p);
              else
                  heal(players.get(x));
            }   
        }
        if(!getWinner(players)){
        for(int i=0; i<totalTwoShot;i++)
        {
            ArrayList<Player> options = new ArrayList<Player>();
            if(p.isAI())
            {
                if (players.size() <4)
                {
                    options = getOneAway(p);
                }
                else
                     options = getTwoAway(p);
                
                int x = ai.who_toshoot(options,p.getRole());
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
}
