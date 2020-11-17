/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_Exo_1;

import TD3_Exo_1.*;

/**
 *
 * @author thibault
 */
public class DoorWithLock extends Door implements Lockable {
    // attributs 
    protected boolean isLocked ; 
    
    private final boolean DEFAULT_ISLOCKED = false;
    // constructeur(s) 
    public DoorWithLock()
    {
        super(); 
        this.isLocked = DEFAULT_ISLOCKED;
    }
    
    // méthodes
    public void unlock()
    {
       this.isLocked = false; 
    }
    
    public void lock()
    {
       this.isLocked = false; 
    }
    
    @Override
    public void open()
    {
        if(!this.isLocked)
            super.open();
    }
    
    @Override
    public void close()
    {
        if(!this.isLocked)
            super.close();
    }
    
    public boolean getIsLocked()
    {
        return this.isLocked;
    }
    
    @Override
    public String toString()
    {
        return (super.toString() + "; is Locked = "+this.isLocked);
    }
     
    
    
}
