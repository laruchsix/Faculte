/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_Exo_1;

import java.util.ArrayList;

/**
 *
 * @author thibault
 */
public class Door {
    // attributs
    private boolean isOpen;
    
    private final boolean DEFAULT_ISOPEN = false ; 
    
    // constructeur(s)
    public Door()
    {
        this.isOpen = this.DEFAULT_ISOPEN;
    }
    
    // 
    public void open()
    {
        this.isOpen = true;
    }
    
    public void close()
    {
        this.isOpen = false;
    }
    
    public void printDoorList(ArrayList<Door> doors)
    {
        for( Door i : doors)
        {
            System.out.println(i.toString());
        }
    }
    
    @Override
    public String toString()
    {
        return (this.getClass().getSimpleName() +" : is Open = " + this.isOpen);
    }
    
    public boolean getIsOpen() 
    {
        return this.isOpen; 
    }
    
}
