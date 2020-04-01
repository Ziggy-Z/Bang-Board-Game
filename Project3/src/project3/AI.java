/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;
import java.util.ArrayList;
import java.util.*;
import java.lang.Math;
import java.util.Random;
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
                   int i=0;
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
            */
           
 
           public int who_toshoot(ArrayList<Player> options,String role){
              
               int i=0;
               int x=0;
               int y=0;
               if(role.equals("Deputy")){
                for(i=0;i<options.size();i++)
                    if(options.get(i).equals("Outlaw")){
                        x = options.get(i).getHealth();
                    }
                    if(options.get(i).equals("Renegade")){
                        y = options.get(i).getHealth();
                    }
                if(x > y){
                    for(i=0;i<options.size();i++)
                        if(options.get(i).equals("Renegade"))
                            return i;
                       }
                else   {
                    for(i=0;i<options.size();i++)
                        if(options.get(i).equals("Outlaw"))
                           return i;
                    
                       }
              }
               
               else if(role.equals("Sherrif")) {
                for(i=0;i<options.size();i++)
                    if(options.get(i).equals("Outlaw")){
                        x = options.get(i).getHealth();
                    }
                    if(options.get(i).equals("Renegade")){
                        y = options.get(i).getHealth();
                    }
                if(x > y){
                    for(i=0;i<options.size();i++)
                        if(options.get(i).equals("Renegade"))
                            return i;
                       }
                else   {
                    for(i=0;i<options.size();i++)
                        if(options.get(i).equals("Outlaw"))
                            return i;
                    
                       }
                }
               else if(role.equals("Outlaw")){
                for(i=0;i<options.size();i++)
                    if(options.get(i).equals("Sherrif")){
                        x = options.get(i).getHealth();
                    }
                    if(options.get(i).equals("Deputy")){
                        y = options.get(i).getHealth();
                    }
                if(x > y){
                    for(i=0;i<options.size();i++)
                        if(options.get(i).equals("Deputy"))
                            return i;
                       }
                else   {
                    for(i=0;i<options.size();i++)
                        if(options.get(i).equals("Sherrif"))
                            return i;
                    
                       }
              }
               else if(role.equals("Renegade")){
                for(i=0;i<options.size();i++)
                    if(options.get(i).equals("Sherrif")){
                        x = options.get(i).getHealth();
                    }
                    if(options.get(i).equals("Deputy")){
                        y = options.get(i).getHealth();
                    }
                if(x > y){
                    for(i=0;i<options.size();i++)
                        if(options.get(i).equals("Deputy"))
                            return i;
                       }
                else   {
                    for(i=0;i<options.size();i++)
                        if(options.get(i).equals("Sherrif"))
                            return i;
                    
                       }
              }

         

               
               
               
           }
           
          /**
            * returns  player object that should be healed.
            * 
            */
 
           public int who_toheal(ArrayList<Player> options,String role){
             
             Random f=new Random();  
             if(role.equals("Deputy")){
                 for(int i=0;i<options.size();i++)
                     if(options.get(i).equals("Deputy")){
                         if(options.get(i).isFullHealth()==false)
                             return -1;
                         else if(1==1)
                             for(i=0;i<options.size();i++)
                                 if(options.get(i).equals("Sherrif"))
                                    if(options.get(i).isFullHealth()==false)
                                       return i;
                         else 
                             return f.nextInt(((options.size()-1)+1))+1;
                 
             }   
             else if(role.equals("Sherrif")){
                 for(i=0;i<options.size();i++)
                     if(options.get(i).equals("Sherrif")){
                         if(options.get(i).isFullHealth()==false)
                             return -1;
                         else 
                             return f.nextInt(((options.size()-1)+1))+1;
              }
                 
             }
             else if(role.equals("Renegade")){
                 for(i=0;i<options.size();i++)
                     if(options.get(i).equals("Renegade")){
                         if(options.get(i).isFullHealth()==false)
                             return -1;
                         else 
                             return f.nextInt(((options.size()-1)+1))+1;
             }
                 
                 
             }
             else if(role.equals("Outlaw")){
                 for(i=0;i<options.size();i++)
                     if(options.get(i).equals("Outlaw")){
                         if(options.get(i).isFullHealth()==false)
                             return -1;
                         else 
                             return f.nextInt(((options.size()-1)+1))+1;
             }
                 
             }
  

           
  }
           
}
           
 
