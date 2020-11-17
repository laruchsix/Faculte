/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD3_Exo_1;

/**
 *
 * @author thibault
 */
public class DoorWithLock extends Door implements Lockable {
    // attributs 
    private boolean isLocked ; 
    
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
    public void print()
    {
        super.print();
        System.out.print( "; is Locked = "+this.isLocked);
    }
    
    
    
}
