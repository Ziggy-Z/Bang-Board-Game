
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
    private void Create_Deck()
    {
        Reset_Arrows();
    }
    public int getArrow()
    {
        int x = Arrow_List.remove(0);
       return x;
    }
    public int getNum_Arrows()
    {
        return Arrow_List.size();
    }
    private void Shuffle_Arrows()
    {
        for(int i=0; i<Arrow_List.size(); i++)
        {
            Random rand = new Random();
            int temp= rand.nextInt(Arrow_List.size()-1);
            Collections.swap(Arrow_List, i, temp);
        }
    }
    public void Reset_Arrows()
    {
        for (int i=1; i<=Regular_Arrow; i++)
        {
            Arrow_List.add(0);
        }
        Arrow_List.add(1);
        Shuffle_Arrows();
    }
    /*
    public static void main(String[] args)
    {
        ChiefArrow d = new ChiefArrow(1);
        int temp= d.getNum_Arrows();
        for (int i=0; i<temp; i++)
        {
            System.out.println("Number: "+d.getArrow());
        }
        System.out.println("\n\nNew Spotn\n\n");
        d.Reset_Arrows();
        for (int i=0; i<temp; i++)
        {
            System.out.println("Number: "+d.getArrow());
        }
    } */
}
