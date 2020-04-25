/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;
import java.util.ArrayList;
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
           public AI(){
    
                }
                 
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
            * returns  player object that should be shot.
            * 
     * @param options
     * @param role
     * @return 
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
            * returns  player object that should be healed.
            * 
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
}
           
 
