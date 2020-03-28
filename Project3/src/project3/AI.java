/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;
import java.util.ArrayList;
import java.util.*;

/*
CS 2365 OOP Spring 2020 Section 2
Rohit Gurnani
 */
/**
 * Creates the AI to be used in the game for automated players.
 * @author rohitgurnani
 */
public class AI {
    
          /**
            * returns array of integers of indexes of dice that needs to be re-rolled.
            * 
            */
                 
           public ArrayList<Integer> rollagain(ArrayList<Dice> die, String role){
                   int i=0;
                   ArrayList<Integer> roll_list = new ArrayList<Integer>();
                    if(role.equals("Sherrif")){
                       for(i=0;i<die.size();i++)
                          if(die.get(i).getResult().equals("Arrow"))
                             roll_list.add(i);
                          if(die.get(i).getResult().equals("Gatling"))
                             roll_list.add(i);
                    }else if(role.equals("Deputy")){
                        for(i=0;i<die.size();i++)
                          if(die.get(i).getResult().equals("Arrow"))
                             roll_list.add(i);
                          if(die.get(i).getResult().equals("Gatling"))
                             roll_list.add(i);
                    }else if(role.equals("Renegade")){
                        for(i=0;i<die.size();i++)
                          if(die.get(i).getResult().equals("Arrow"))
                             roll_list.add(i);
                          if(die.get(i).getResult().equals("Gatling"))
                             roll_list.add(i);
                    }else if(role.equals("Outlaw")){
                        for(i=0;i<die.size();i++)
                          if(die.get(i).getResult().equals("Arrow"))
                             roll_list.add(i);
                          if(die.get(i).getResult().equals("Gatling"))
                             roll_list.add(i);
                    }                       
                    return roll_list;       
                             
                    
               }
           
           /**
            * returns  player object that should be shot.
            * 
            */
           
           public int who_toshoot(ArrayList<Players> options){
              return 2;
               
               
               
           }
           
          /**
            * returns  player object that should be healed.
            * 
            */
           public int who_toheal(ArrayList<Players> options){
              return 1;
           }
}
 
