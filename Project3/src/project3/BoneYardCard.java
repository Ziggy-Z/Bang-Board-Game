/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

package project3;

import java.util.Collections;
import java.util.LinkedList;

/**
 CS 2365 Section 02
 Nathan Clough
 */


public class BoneYardCard {
    LinkedList<Integer> deck = new LinkedList<Integer>();
    int totalHandsOnBoard =0; 
    int hands;

    /**
     *
     */
    public BoneYardCard(){
        for(int i =0; i<6; i++)
            deck.add(1);
        for(int i =0; i<3; i++)
            deck.add(2);
        deck.add(0);
        deck.add(0);
        Collections.shuffle(deck);
            
    }

    /**
     *
     * @return
     */
    public int drawCard(){
        int temp = deck.pop();
        totalHandsOnBoard += temp;
        return temp;
        
    }

    /**
     *
     * @param x
     */
    public void returnToDeck(int x){
        deck.addLast(x);
    }

    /**
     *
     * @return
     */
    public int getTotalHands(){
        //return totalHandsOnBoard;
       return totalHandsOnBoard;
    }

}
