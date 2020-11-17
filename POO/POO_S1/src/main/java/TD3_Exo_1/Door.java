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
public class Door implements Closeable {
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
    
    public void print()
    {
        System.out.print("is Open = " + this.isOpen);
    }
    
    public boolean getIsOpen() 
    {
        return this.isOpen; 
    }
    
}
