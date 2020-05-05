package project3;


import java.util.Collections;
import java.util.LinkedList;

/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

/**
 * CS 2365 Section 02
 * Nathan Clough
 * This class constructs tokens to be used in the Undead expansion 
 */
public class Token {
    

           /**
            * Constructor for Token
            * @author Nathan Clough
            */

  static LinkedList<String> tokens = new LinkedList<String>();

    public Token(){
          tokens = new LinkedList<String>() { 
            { 
                add("Dynamite"); 
                add("Dynamite"); 
                add("Beer");
                add("Beer");
                add("Beer");
                add("One");
                add("One");
                add("One");
                add("One");
                add("One");
                add("Two");
                add("Two");
                add("Two");
                add("Two");
                add("Two");
            } 
        }; 
    } 
   
           /**
            * Draws a Token from the Pile
            * @author Nathan Clough
            * @return token
            */ 
 
    public String drawToken(){
        Collections.shuffle(tokens);
        String token = "";
        if(tokens.size() <= 0){
            return token;
        }
        else
        {
            token = tokens.pop(); 
            return token;
        }

    }
          /**
            * Returns a Token to the Pile
            * @author Nathan Clough
     * @param token
            */ 
    public void returnToken(String token){
        tokens.addFirst(token);
    }
    
        
}
