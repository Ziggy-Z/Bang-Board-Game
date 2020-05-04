/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */
package project3;
import Testing.TestClientGame;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author X1Gen3
 */
public class Project3 {
//create a lock .notifyb 
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
       
        
        //Displays the board 

        UI ui = new UI();
        int numPlayers =0;
        try {
            numPlayers = ui.getStartNumPlayers();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int mod = ui.getModules();
       
        if(mod == 0)
        {
            Game g = new Game(numPlayers);
            g.play();
        }
        else if(mod == 1)
        {

            OldSaloon g = new OldSaloon(numPlayers);
            g.play();
        }
        else if (mod == 2)
        {
            Undead g = new Undead(numPlayers);
            g.play();
        }
    }
    
}
