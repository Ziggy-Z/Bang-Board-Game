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
    
    private int CurrentHealth;
    private int MaxHealth;
    private int Arrows=0;
    private String Role;
    private String Character;
    private String ability;
    private String number;
    private boolean AI = true;
    
    
    public Player(String number)
    {
        if(number == "p1")
            AI=false;
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
    public void setHealth(int num)
    {
        CurrentHealth=num;
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
    public String getCharacter()
    {
        return Character;
    }
    public String getAbility()
    {
        return ability;
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

