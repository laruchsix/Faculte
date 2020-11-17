package Robots_World;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trucher
 */
public class Robot {
    // attributs
    private String name; 
    
    // constructeurs
    public Robot(String n)
    {
        this.name = n;
    }
    
    // metodes 
    @Override
    public String toString()
    {
        return this.name;
    }
    
}
