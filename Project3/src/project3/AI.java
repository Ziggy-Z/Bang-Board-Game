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
public class AI {
    
  ///  public ai(ArrayList<Player> players){
    //    for(int i=0; i<players.length; i++)
     //   {
      //      if(i.getRole()=="Sheriff")
       //         if(getResult()=="Arrow")
        //            i.setArrows(i.getArrows()+1); 
       //         if(getResult()=="Beer")
       //             if(i.isFullHealth()==true)
        //                i++.setHealth(1);
         //           else
          //              i.setHealth(1);
           //     if(getResult()=="One")
            //        i[1].setHealth(i[1].getHealth()-1);
             //   if(getResult()=="Two")
              //      i[2].setHealth(i[2].getHealth()-1);
            
         //   if(i.getRole()=="Deputy")
        //    if(i.getRole()=="Outlaw")
          //  if(i.getRole()=="Renegade")
                    
                    
          Dice dice = new Dice();
                    
           public ArrayList<Dice> rollagain(ArrayList<Dice> die){
               for(int i=0;i<die.size();i++)
                   if(dice.getResult().equals("Arrow"))
                       return die[i];
                  if(i.getResult().equals("One"))
                       return die[i];
                   if(i.getResult().equals("Two"))
                       return die[i];
                   if(i.getResult().equals("Gatling"))
                       return die[i];
                    
                
        }
                        
           public ArrayList<Player> who_toshoot(ArrayList<Players> p){
               
           }
}
 
