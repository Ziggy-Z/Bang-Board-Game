package project3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
/**
 * @author Joseph McClaine
 */
public class Player {
    
    private int CurrentHealth= 0;
    private int MaxHealth = 0;
    private int Arrows=0;
    private ArrayList<String> tokens = new ArrayList<String>();
    private String Role = "";
    private String Character = "";
    private String ability = "";
    private String number = "";
    public boolean AI = true;
    public boolean first = true;
    private boolean Zombie = false;
    ArrayList<String> woundTokens = new ArrayList<String>();
    
    
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
    public int getHealth()
    {
        return CurrentHealth;
    }
    public void setUser(){
        AI = false;
    }
    public void setHealth(int num)
    {
        CurrentHealth=num;

    }
    public void addToken(String t){
        tokens.add(t);
    }
    public void removeToken(String t){
        tokens.remove(t);
    }
    public int getArrows()
    {
        return Arrows;
    }
    public void setArrows(int num)
    {
        Arrows=num;
    }
    public String getRole()
    {
        return Role;
    }
    public void setRole(String temp)
    {
        Role=temp;
    }
    public void setCharacter(String input){
        Character = input;
    }
    public String getCharacter()
    {
        return Character;
    }
    public String getAbility()
    {
        return ability;
    }
    public boolean isZombie(){
        if(CurrentHealth <= 0 && first)
        {
            Zombie = true;
            woundTokens.clear();
            Character = "Zombie";
            first = false;
            return Zombie;
        }
        else
        {
                    return Zombie;
        }
    }
    public boolean isFullHealth()
    {
        if (CurrentHealth == MaxHealth)
            return true;
        else
            return false;
    }
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
    private void setZombieTraits(){
        
    }
    private void AssignTraits(String temp)
    {
        String[] arrtemp = temp.split(";",0);
        Character = arrtemp[0].toUpperCase();
        MaxHealth = Integer.parseInt(arrtemp[1]);
        CurrentHealth = MaxHealth;
        ability = arrtemp[2];
        ability = ability.replace(":","\n");
    }  
    public boolean isAI()
    {
        return AI;
    }
}

