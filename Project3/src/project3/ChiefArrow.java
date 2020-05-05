package project3;
/**
 *
 * @author Joseph McClaine
 */
import java.io.*;
import java.util.*;

public class ChiefArrow {
    private int Regular_Arrow = 9;
    private ArrayList<Integer> Arrow_List = new ArrayList<Integer> (Regular_Arrow);
    
    public ChiefArrow()
    {
      Create_Deck();
    }
/**
* Create_Deck creates the Array List for the list of Arrows
* Contributors: None
* @param void
* @author Joseph McClaine
* @return void
*/
    private void Create_Deck()
    {
        Reset_Arrows();
    }
    
/**
* getArrow pulls an arrow from the list and value from Array list is returned to see if it was Chief Arrow or Regular Arrow
* Contributors: None
* @param void
* @author Joseph McClaine
* @return int
*/
    public int getArrow()
    {
        int x = Arrow_List.remove(0);
       return x;
    }
    
/**
* getNum_Arrows returns the number of arrows left in the ArrayList to see if there are arrows left
* Contributors: None
* @param void
* @author Joseph McClaine
* @return int
*/
    public int getNum_Arrows()
    {
        return Arrow_List.size();
    }
    
/**
* Shuffle_Arrows Shuffles the List of Arrows so the Chief Arrow is in list Randomly
* Contributors: None
* @param void
* @author Joseph McClaine
* @return void
*/
    private void Shuffle_Arrows()
    {
        for(int i=0; i<Arrow_List.size(); i++)
        {
            Random rand = new Random();
            int temp= rand.nextInt(Arrow_List.size()-1);
            Collections.swap(Arrow_List, i, temp);
        }
    }
    
/**
* Reset_Arrows refills the arrows in the list and shuffles them again
* Contributors: None
* @param void
* @author Joseph McClaine
* @return void
*/
    public void Reset_Arrows()
    {
        for (int i=1; i<=Regular_Arrow; i++)
        {
            Arrow_List.add(0);
        }
        Arrow_List.add(1);
        Shuffle_Arrows();
    }
}
