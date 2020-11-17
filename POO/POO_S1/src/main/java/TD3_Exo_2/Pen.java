/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD3_Exo_2;

import java.awt.Color;

/**
 *
 * @author thibault
 */
public class Pen implements Writer {
    // attributs 
    protected Cartridge cartridge;
    protected boolean canWrite; 
    
    private boolean DEFAULT_CANWRITE = true;
    
    // constructeur
    public Pen()
    {
        this.cartridge = new Cartridge();
        this.canWrite = this.DEFAULT_CANWRITE;
    }
    
    public Pen(Color c)
    {
        this.cartridge = new Cartridge(c);
        this.canWrite = this.DEFAULT_CANWRITE;
    }
    
    // 
    private boolean getCanWrite()
    {
        return this.canWrite;
    }
    
    public boolean emptyCartridge ()
    {
        return this.cartridge.isEmpty();
    }
    
    public boolean write(String txt)
    {
        if(this.cartridge.canUse(txt.length()))
        {
            System.out.println(txt);
            this.cartridge.use(txt.length());
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public void replaceCartridge(Color c)
    {
        Cartridge car = new Cartridge(c);
        this.cartridge = car;
    }
    
    public void print()
    {
        System.out.println(this.getClass().getSimpleName() + " : can write = "+ this.canWrite);
    }
}
