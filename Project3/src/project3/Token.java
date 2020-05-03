package project3;


import java.util.Collections;
import java.util.LinkedList;

/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

/**
 CS 2365 Section 02
 Nathan Clough
 */
public class Token {
    
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
    public String drawToken(){
        Collections.shuffle(tokens);
        String token = tokens.pop();
        return token;
    }
    public void returnToken(String token){
        tokens.addFirst(token);
    }
    
        
}
