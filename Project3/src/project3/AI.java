/*
 * CS 2365 OOP Spring 2020 Section 2
 * Rohit Gurnani
 */
package project3;
import java.util.ArrayList;
import java.util.*;
import java.lang.Math;
import java.util.Random;

/**
 * Creates the AI to be used in the game for automated players.
 * @author Rohit Gurnani
 * Contributor: Nathan Clough : Added functionality for AI to choose who to heal.
 */
public class AI {
    
          /**
            * returns array of integers of indexes of dice that needs to be re-rolled by the automated players
            * 
            */
           public AI(){
    
            }
                 
    /**
     *
     * @param die
     * @param role
     * @return role_list
     * @return roll_list
    */
     
    public ArrayList<Integer> rollagain(ArrayList<Dice> die, String role){
                   int i;
                   ArrayList<Integer> roll_list = new ArrayList<Integer>();
                    if(role.equals("Sheriff")){
                       for(i=0;i<die.size();i++)
                       {
                            if(die.get(i).getResult().equals("Arrow"))
                                roll_list.add(i);
                            if(die.get(i).getResult().equals("Gatling"))
                                roll_list.add(i);
                       }
                    }else if(role.equals("Deputy")){
                        for(i=0;i<die.size();i++)
                        {
                          if(die.get(i).getResult().equals("Arrow"))
                             roll_list.add(i);
                          if(die.get(i).getResult().equals("Gatling"))
                             roll_list.add(i);
                        }
                    }else if(role.equals("Renegade")){
                        for(i=0;i<die.size();i++)
                        {
                          if(die.get(i).getResult().equals("Arrow"))
                             roll_list.add(i);
                          if(die.get(i).getResult().equals("Gatling"))
                             roll_list.add(i);
                        }
                    }else if(role.equals("Outlaw")){
                        for(i=0;i<die.size();i++)
                        {
                          if(die.get(i).getResult().equals("Arrow"))
                             roll_list.add(i);
                          if(die.get(i).getResult().equals("Gatling"))
                             roll_list.add(i);
                        }
                    }                       
                    return roll_list;       
                             
                    
               }
           
           /**
            * Returns player object that should be shot by the automated player.
            * 
            * @param options
            * @param role
            * @return i
            */
           
           public int who_toshoot(ArrayList<Player> options,String role){
              
               int i=0;
               int x=0;
               int y=0;
               if(role.equals("Deputy")){
                for(i=0;i<options.size();i++)
                    if(options.get(i).getRole().equals("Outlaw")){
                        x = options.get(i).getHealth();
                    }
                    else if(options.get(i).getRole().equals("Renegade")){
                        y = options.get(i).getHealth();
                    }
                if(x > y){
                    for(i=0;i<options.size();i++)
                        if(options.get(i).getRole().equals("Renegade"))
                            return i;
                       }
                else   {
                    for(i=0;i<options.size();i++)
                        if(options.get(i).getRole().equals("Outlaw"))
                           return i;
                    
                       }
              }
               
               else if(role.equals("Sherrif")) {
                for(i=0;i<options.size();i++)
                    if(options.get(i).getRole().equals("Outlaw")){
                        x = options.get(i).getHealth();
                    }
                    else if(options.get(i).getRole().equals("Renegade")){
                        y = options.get(i).getHealth();
                    }
                if(x > y){
                    for(i=0;i<options.size();i++)
                        if(options.get(i).getRole().equals("Renegade"))
                            return i;
                       }
                else   {
                    for(i=0;i<options.size();i++)
                        if(options.get(i).getRole().equals("Outlaw"))
                            return i;
                    
                       }
                }
               else if(role.equals("Outlaw")){
                for(i=0;i<options.size();i++)
                    if(options.get(i).getRole().equals("Sherrif")){
                        x = options.get(i).getHealth();
                    }
                    else if(options.get(i).getRole().equals("Deputy")){
                        y = options.get(i).getHealth();
                    }
                if(x > y){
                    for(i=0;i<options.size();i++)
                        if(options.get(i).getRole().equals("Deputy"))
                            return i;
                       }
                else   {
                    for(i=0;i<options.size();i++)
                        if(options.get(i).getRole().equals("Sherrif"))
                            return i;
                    
                       }
              }
               else if(role.equals("Renegade")){
                for(i=0;i<options.size();i++)
                    if(options.get(i).getRole().equals("Sherrif")){
                        x = options.get(i).getHealth();
                    }
                    else if(options.get(i).getRole().equals("Deputy")){
                        y = options.get(i).getHealth();
                    }
                if(x > y){
                    for(i=0;i<options.size();i++)
                        if(options.get(i).getRole().equals("Deputy"))
                            return i;
                       }
                else   {
                    for(i=0;i<options.size();i++)
                        if(options.get(i).getRole().equals("Sherrif"))
                            return i;
                    
                       }
              }

         

               
            return 0;   
               
           }
           
          /**
            * Returns player object that should be healed by the automated Player.
            * 
            * @param options
            * @param p
            * @return heal
            */
 
         
             
        public int who_toheal(ArrayList<Player> options, Player p){
             int heal = -2;
             if(p.isFullHealth() == false)
             {
                 heal = -1;
             }
             else{
                int indexLowestHealth = -2;
                int lowestHealth = 20;
                int HighestHealthNotMax =0;
                int indexHighestHealthNotMax = -2;
                int indexSheriff = -1;
                for(int i = 0; i < options.size(); i ++)
                        {
                            Player temp = options.get(i);
                            if(temp.getRole().equals("Sheriff"))
                            {
                                indexSheriff = i;
                            }
                            
                            if(temp.isFullHealth() == false && temp.getHealth() > HighestHealthNotMax)
                            {
                                indexHighestHealthNotMax = i;
                                HighestHealthNotMax = temp.getHealth();
                            }
                            if(temp.getHealth() < lowestHealth  && temp.isFullHealth() == false)
                            {
                                indexLowestHealth = i;
                                lowestHealth = temp.getHealth(); 
                            }
                        }
                String role = p.getRole();
                Boolean SheriffIsFullHealth = options.get(indexSheriff).isFullHealth();
               
                switch (role) {
                    case "Sheriff":
                        heal = indexHighestHealthNotMax;
                        break;
                    case "Deputy":
                        if(!SheriffIsFullHealth)
                        {
                            heal = indexSheriff;
                        }
                        else 
                            heal = indexHighestHealthNotMax;
                        break;
                    case "Outlaw":
                        if (indexLowestHealth != indexSheriff)
                        {
                            heal = indexLowestHealth;
                        }
                        else if(indexHighestHealthNotMax != indexSheriff){
                            heal = indexHighestHealthNotMax;
                        }
                        break;
                    case "Renegade": //heals sheriff if other players are still alive 
                        if((options.size() > 2) && (!SheriffIsFullHealth)) {
                        {
                            heal = indexSheriff;
                        }
                        }
                        else if(indexLowestHealth != -2)
                        {
                            heal = indexLowestHealth;
                        }
                        else if(indexHighestHealthNotMax != -2)
                        {
                            heal = indexHighestHealthNotMax;
                        }
                        break;
                    default:
                        break;
                }    
            }
            return heal;
        }

            
            /**
            * Returns the die loudmouth or coward that will be used 
            * by the Automated Player
            * 
            * returns 1 for coward and 2 for loudmouth and 3 for both the die
            * and 0 for none
            * @param p
            * @return 
            *
            * @param p
            * @return int 
            */ 
            public int selectDice(Player p){
              Random saloon = new Random(); 
              int saloon_die = saloon.nextInt((2 - 1) + 1) + 1;
                if (p.getHealth()<=3)
                    return 1;
                else if(p.getHealth()>7)
                    return 2;
                else if(p.getHealth()<=5&&p.getHealth()>=4)
                    return saloon_die;
                else if(p.getHealth()<=7&&p.getHealth()>=6)
                    return 3;
                else if(p.getHealth()==8)
                    return 0;
            return 0;
           }

}
            
 
