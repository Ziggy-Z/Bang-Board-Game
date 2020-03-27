/*
CS 2365 OOP Spring 2020 Section 2
Nathan Clough
 */

package project3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 CS 2365 Section 02
 Nathan Clough
 */
public class Player {
private int value;
private int health; 
private int arrows;
private String type;
private String role;
public Player(int x)
{
    value = x;
}
public void setRole(String role){
    this.role = role;
}
public void setCharacter(int x)
{
    
}
public int getHealth(){
    return health;
}
public void setHealth(int x ){
    health = x;
}
public int getArrows(){
    return arrows;
}
public void setArrows(int x){
    arrows =x;
}
public String getType(){
    return type;
    
}
public void setType(String input){
    type = input;
}
public String getRole(){
    return role;
}
public int getValue(){
    return value; 
}
public int [] rollAgain(ArrayList<Dice> dice){
    //System.out.println("\nPlayer: " + getValue() + " " + getRole() );
    int [] diceIndex = new int [5];
    diceIndex[0] = 1;
    System.out.println("Roll again?");
    Scanner kb = new Scanner(System.in);
    int response = kb.nextInt();
    if (response == 1)
        return diceIndex;
    else 
        return null;
}
       
}
