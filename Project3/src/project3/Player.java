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

    private boolean AI = true;
    private boolean Chief_Arrow = false;
    


    /**
     *
     */


    /**
     *
     */
    public boolean first = true;
    private boolean Zombie = false;
    private boolean token;
    ArrayList<String> woundTokens = new ArrayList<String>();

    
    /**
     *
     * @param number
     */
    public Player(String number)
    {
        this.number = number;
    }

    /**
     *
     * @return
     */
    public String getNumber(){
        return number;
    }

    /**
     *
     * @return
     */
    public int getHealth()
    {
        return CurrentHealth;
    }

    /**
     *
     */
    public void setUser(){
        AI = false;
    }

    /**
     *
     * @param num
     */
    public void setHealth(int num)
    {
        CurrentHealth=num;

    }

    /**
     *
     * @param t
     */
    public void addToken(String t){
        tokens.add(t);
    }


    /**
     *
     * @param t
     */
    public void removeToken(String t){
        tokens.remove(t);
    }
    public void removeToken(){
        tokens.remove(0);
    }

    /**
     *
     * @return
     */
    public int getArrows()
    {
        return Arrows;
    }

    /**
     *
     * @param num
     */
    public void setArrows(int num)
    {
        Arrows=num;
    }

    /**
     *
     * @return
     */
    public String getRole()
    {
        return Role;
    }

    /**
     *
     * @param temp
     */
    public void setRole(String temp)
    {
        Role=temp;
    }

    /**
     *
     * @param input
     */
    public void setCharacter(String input){
        Character = input;
    }

    /**
     *
     * @return
     */
    public String getCharacter()
    {
        return Character;
    }

    /**
     *
     * @return
     */
    public String getAbility()
    {
        return ability;
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    public boolean isFullHealth()
    {
        if (CurrentHealth == MaxHealth)
            return true;
        else
            return false;
    }

    /**
     *
     * @param num
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

    /**
     *
     * @return
     */
    public boolean isAI()
    {
        return AI;
    }

    public boolean isChief_Arrow()
    {
        return Chief_Arrow;
    }
    public void setChief_Arrow(boolean Choice)
    {
        Chief_Arrow = Choice;
    }
    public boolean hasToken(String s){
        if(tokens.contains(s)){
            return true;
            
        }
        else 
            return false;
    }        
    public boolean hasToken(){
        if(tokens.size() > 0)
            return true;
        else 
            return false;
    }

}

