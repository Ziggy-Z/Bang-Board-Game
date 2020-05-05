package project3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.nio.file.*;
/**
 * @author Joseph McClaine
 */
public class Player {
    
    private int CurrentHealth= 0;
    private int MaxHealth = 0;
    private int Arrows=0;
    private String Role = "";
    private String Character = "";
    private String ability = "";
    private String number = "";
    private boolean AI = true;
    private boolean Chief_Arrow = false;
    
    
    public Player(String number)
    {
        this.number = number;
        
        /*
        setCharacterTraits(0);
        System.out.println("Name: " +Character);
        System.out.println("Max Health: " +MaxHealth);
        System.out.println("Current Health: " +CurrentHealth);
        System.out.println("Ability: " +ability);
        setRole("Bandit");
        setHealth(10);
        setArrows(5);
        System.out.println("Current Health: " +CurrentHealth);
        System.out.println("Role: " +Role);
        System.out.println("Arrows: "+Arrows);
*/
    }
    public String getNumber(){
        return number;
    }
    
/**
* getHealth returns the int value of the player's current health 
* Contributors: None
* @param void
* @author Joseph McClaine
* @return int
*/
    public int getHealth()
    {
        return CurrentHealth;
    }
    
/**
* setUser sets the AI to false to indicate that the player is a user 
* Contributors: None
* @param None
* @author Joseph McClaine
* @return void
*/
    public void setUser(){
        AI = false;
    }
    
/**
* setHealth sets the current health to the int parameter 
* Contributors: None
* @param int
* @author Joseph McClaine
* @return void
*/
    public void setHealth(int num)
    {
        CurrentHealth=num;
    }
    
/**
* getArrows Returns the number of arrows that the user has 
* Contributors: None
* @param none
* @author Joseph McClaine
* @return int
*/
    public int getArrows()
    {
        return Arrows;
    }
    
/**
* setArrows sets the current number of arrows to the int parameter 
* Contributors: None
* @param int
* @author Joseph McClaine
* @return void
*/
    public void setArrows(int num)
    {
        Arrows=num;
    }
    
/**
* getRole returns a string of the character's set role
* Contributors: None
* @param none
* @author Joseph McClaine
* @return String
*/
    public String getRole()
    {
        return Role;
    }
    
/**
* setRole sets the role string to the parameter string
* Contributors: None
* @param String
* @author Joseph McClaine
* @return void
*/
    public void setRole(String temp)
    {
        Role=temp;
    }
    
/**
* getCharacter returns a String that contains name of the character
* Contributors: None
* @param None
* @author Joseph McClaine
* @return String
*/
    public String getCharacter()
    {
        return Character;
    }
    
/**
* getAbility returns the string of the character's special ability
* Contributors: None
* @param None
* @author Joseph McClaine
* @return String
*/
    public String getAbility()
    {
        return ability;
    }
    
/**
* isFullHealth returns Boolean of whether the character is at full health
* Contributors: None
* @param None
* @author Joseph McClaine
* @return boolean
*/
    public boolean isFullHealth()
    {
        if (CurrentHealth == MaxHealth)
            return true;
        else
            return false;
    }
    
/**
* setCharacterTraits pulls a character and traits using parameter as the line number to pull from in text document
* Contributors: Nathan Clough
* @param int
* @author Joseph McClaine
* @return void
*/
    public void setCharacterTraits(int num)
    {
        String temp="";
        try{
            temp = Files.readAllLines(Paths.get("Bang_Characters.txt")).get(num);
            AssignTraits(temp);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
    
/**
* AssignTraits receives the string from the text document and breaks it down into parts
* Contributors: None
* @param String
* @author Joseph McClaine
* @return void
*/
    private void AssignTraits(String temp)
    {
        String[] arrtemp = temp.split(";",0);
        Character = arrtemp[0].toUpperCase();
        MaxHealth = Integer.parseInt(arrtemp[1]);
        CurrentHealth = MaxHealth;
        ability = arrtemp[2];
        ability = ability.replace(":","\n");
    }
    
/**
* isAI returns boolean whether the player is AI or user
* Contributors: None
* @param None
* @author Joseph McClaine
* @return boolean
*/
    public boolean isAI()
    {
        return AI;
    }
    
/**
* isChief_Arrow returns boolean saying whether the player has the Chief Arrow token
* Contributors: None
* @param None
* @author Joseph McClaine
* @return boolean
*/
    public boolean isChief_Arrow()
    {
        return Chief_Arrow;
    }
    
/**
* setChief_Arrow sets the Chief_Arrow to the parameter passed to add or remove Chief Arrow token from the player
* Contributors: None
* @param boolean
* @author Joseph McClaine
* @return void
*/
    public void setChief_Arrow(boolean Choice)
    {
        Chief_Arrow = Choice;
    }
}

