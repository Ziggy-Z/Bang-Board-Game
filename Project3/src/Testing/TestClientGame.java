package Testing;


import java.util.ArrayList;
import project3.Game;
import project3.Player;

/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

/**
 CS 2365 Section 02
 Nathan Clough
 */
public class TestClientGame {
    /**
    * This is a testing client for the game class
    * @param args
    */
    boolean correctPlayers = true;
    int playerAmountFlag = 0;
    int sizeFlag;
    boolean correctNumRoles = true;
    String failedRoles;
    public TestClientGame(){
        
        /**
         * Runs testing on the initializing of a Game object
         * first loop checks the amount of players and the amount 
         * of each role to ensure the game is setup correctly
         * identifies errors with flags
         */
        
        for(int i = 3; i <=8; i++ ){
            int Sheriff =0 ;
            int Renegade =0;
            int Outlaw = 0;
            int Deputy = 0;
            Game g = new Game(i);
            ArrayList<Player> players = g.getPlayers();
            if(players.size() != i)
            {
                correctPlayers = false;
                playerAmountFlag = i;
                break;
            }
            /*System.out.println("\nGame size " + i);
            System.out.println("========="); */
            for(Player t: players)
            {
                //System.out.println(t.getRole());
                if(t.getRole().equals("Sheriff"))
                    Sheriff++;
                if(t.getRole().equals("Renegade"))
                    Renegade ++;
                if(t.getRole().equals("Outlaw"))
                    Outlaw++;
                if(t.getRole().equals("Deputy"))
                    Deputy++;    
            }
            boolean passed;
            if(i == 3)
                passed = checkNumRoles(0,1,1,1,Sheriff,Renegade,Outlaw,Deputy,i);
            else if(i == 4)
                passed = checkNumRoles(1,1,2,0,Sheriff,Renegade,Outlaw,Deputy,i);
            else if(i == 5)
                passed = checkNumRoles(1,1,2,1,Sheriff,Renegade,Outlaw,Deputy,i);
            else if(i == 6)
                passed = checkNumRoles(1,1,3,1,Sheriff,Renegade,Outlaw,Deputy,i);
            else if( i == 7)
                passed = checkNumRoles(1,1,3,2,Sheriff,Renegade,Outlaw,Deputy,i);
            else 
                passed = checkNumRoles(1,2,3,2,Sheriff,Renegade,Outlaw,Deputy,i);
            if(!passed)
                break;
               
            
        }
      
        
        
        
        
        //g.play();
       // g.display();
    }
    public void checkTurn(){
        Game g = new Game(3);
        g.play();
        
    }
    public void checkWinners(){
       
        Game g = new Game(4);
        ArrayList<Player> testing = new ArrayList<Player>();
        
        Player p = new Player(1);
        Player p2 = new Player(1);
         
        if(g.getWinner(testing))
            System.out.println("All dead Outlaws win test passed");
        
        //single Outlaw left 
        p.setRole("Outlaw");
        testing.add(p);
        if(g.getWinner(testing))
            if("Outlaw".equals(g.getWinners()))
                System.out.println("Outlaw wins - Single Outlaw Test passed");
            else System.out.println("Single Outlaw Test Failed");
        else 
            System.out.println("Single Outlaw Test Didn't end game");
        //two outlaws remain
        p.setRole("Outlaw");
        p2.setRole("Outlaw");
        testing.add(p);
        testing.add(p2);
        if(g.getWinner(testing))
            if("Outlaw".equals(g.getWinners()))
                System.out.println("Outlaws wins - two Outlaw Test passed");
            else System.out.println("two Outlaw Test Failed");
        else 
            System.out.println("two outlaw didnt end game");
        
    //single Renegade left 
        testing.clear();
        p.setRole("Renegade");
        testing.add(p);
        if(g.getWinner(testing))
            if("Renegade".equals(g.getWinners()))
                System.out.println("Renegade wins - Single Renegade Test passed");
            else 
                System.out.println("Single Renegade Test Failed - result was " + g.getWinners());
        else 
            System.out.println("Single Renegade Test Didn't end game");
        //two renegades kill the sheriff
        
        p2.setRole("Renegade");
        testing.add(p2);
        if(g.getWinner(testing))
            if("Outlaw".equals(g.getWinners()))
                System.out.println("Outlaws win - Two Renegade kill sheriff Test passed");
            else
                System.out.println("Two renegade kill sheriff test failed");
        else
            System.out.println("Two renegade test didnt end game");
        //Single sheriff remaining 
        testing.clear();
        p.setRole("Sheriff");
        testing.add(p);
        
        if(g.getWinner(testing))
            if("Sheriff".equals(g.getWinners()))
                System.out.println("Sheriff wins - Single Sheriff Test passed");
            else System.out.println("Single Sheriff Test Failed");
        else 
            System.out.println("Single Sheriff Test Didn't end game");
         p2.setRole("Deputy");
         testing.add(p2);
         if(g.getWinner(testing))
            if("Sheriff".equals(g.getWinners()))
                System.out.println("Sheriff wins - Sheriff and  Deputy Test passed");
            else System.out.println("Sheriff and  Deputy Test failed");
         else   
             System.out.println("Sheriff and  Deputy Test Didn't end game");
    }
  private boolean checkNumRoles(int S, int R, int O, int D, int cS, int cR , int cO, int cD,int gS){
    if(S != cS)
    {
        correctNumRoles = false;
        failedRoles = "Sheriff";
        playerAmountFlag = cS;  
        sizeFlag = gS;
        return false;
    }
    else if( R != cR){
        correctNumRoles = false;
        failedRoles = "Renegade";
        playerAmountFlag = cR;
        sizeFlag = gS;
        return false;        
    }
    else if( O != cO){
        correctNumRoles = false;
        failedRoles = "Outlaw";
        playerAmountFlag = cO;
        sizeFlag = gS;
        return false;
    }
    else if( D != cD){
        correctNumRoles = false;
        failedRoles = "Deputy";
        playerAmountFlag = cD;
        sizeFlag = gS;
        return false;
    }
    else return true;
      
  }
  public void showResults(){
   if(correctPlayers)
      System.out.println("number of players passed all tests");
   else
       System.out.println("Failed number of players of size"+ playerAmountFlag );
   if(correctNumRoles)
       System.out.println("number of roles correct for all possible game instances");
   else
       System.out.println("Incorrect number " + playerAmountFlag + " of " + failedRoles + " in game size " + sizeFlag);
  }
  public void checkGetOne(){
      Game g = new Game(5);
      for(Player P : g.getPlayers())
          System.out.print(P.getRole() + " ");
      System.out.println();
      ArrayList<Player> options = g.getOneAway(g.getPlayers().get(0));
      System.out.println("\n" +g.getPlayers().get(0).getRole()+"\n=====");
      for(Player P : options )
          System.out.println(P.getRole());
      
      options = g.getOneAway(g.getPlayers().get(4));
      System.out.println("\n" +g.getPlayers().get(4).getRole()+"\n=====");
      for(Player P : options )
          System.out.println(P.getRole());
      options = g.getOneAway(g.getPlayers().get(2));
      System.out.println("\n" +g.getPlayers().get(2).getRole()+"\n=====");
      for(Player P : options )
          System.out.println(P.getRole());
  }
  public void checkGetTwo(){
      Game g = new Game(5);
      for(Player P : g.getPlayers())
          System.out.print(P.getRole() + " ");
      System.out.println();
      ArrayList<Player> options = g.getTwoAway(g.getPlayers().get(0));
      System.out.println("\n" +g.getPlayers().get(0).getRole()+"\n=====");
      for(Player P : options )
          System.out.println(P.getRole());
      
      options = g.getTwoAway(g.getPlayers().get(4));
      System.out.println("\n" +g.getPlayers().get(4).getRole()+"\n=====");
      for(Player P : options )
          System.out.println(P.getRole());
      options = g.getTwoAway(g.getPlayers().get(2));
      System.out.println("\n" +g.getPlayers().get(2).getRole()+"\n=====");
      for(Player P : options )
          System.out.println(P.getRole());
  }
}
