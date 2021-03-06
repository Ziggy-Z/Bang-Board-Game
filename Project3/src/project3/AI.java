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
 * CS 2365 Section 02
 * Creates the AI to be used in the game for automated players.
 * @author Rohit Gurnani
 * Contributors - Nathan Clough : Added the functionality for the AI to select who to heal.
*/

    
          /**
            * returns array of integers of indexes of dice that needs to be re-rolled by the automated players.
            * @param  die
            * @param  role
            * @return roll_list

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
     * @return roll_list
     */
    public ArrayList<Integer> rollagain(ArrayList<Dice> die, String role){
                   int i;
                   ArrayList<Integer> roll_list = new ArrayList<Integer>();
                  
                  // Use if-else statement to check role of the AI and then uses a for loop to iterate through 
                  // Dice and stores the dice that needs to be re-rolled in a arraylist.
               
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
<<<<<<< HEAD
            * returns player object that should be shot by the automated player.
=======
            * Returns player object that should be shot by the automated player.
>>>>>>> Undead
            * 
            * @param options
            * @param role
            * @return i
            */
           
 
           public int who_toshoot(ArrayList<Player> options,String role){
              
               int i=0;
               int x=0;
               int y=0;
              // Uses if statement to check the role and then uses a for loop to iterate through the players.
              // Check the health of the players and return the player to be shot. 
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
<<<<<<< HEAD
            * returns  player object that should be healed by the automated player.
            * @param p
            * @param options
            * @return heal
            * @author Nathan Clough
=======
            * Returns player object that should be healed by the automated Player.
            * 
            * @param options
            * @param p
            * @return heal
>>>>>>> Undead
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
            * by the Automated Player.
            * 
            * returns 1 for coward and 2 for loudmouth and 3 for both the die
<<<<<<< HEAD
            * and 0 for none.
            * @param  p 
            * @return int
=======
            * and 0 for none
            *
            * @param p
            * @return int 
>>>>>>> Undead
            */ 
            public int selectDice(Player p){
              Random saloon = new Random(); 
              int saloon_die = saloon.nextInt((2 - 1) + 1) + 1;
                // Checks the health of the player using if statement 
                // and return the die decision accordingly
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
            
 
