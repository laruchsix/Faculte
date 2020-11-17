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
public class Retractable extends Pen{
    // attributs 
    private boolean writable;
    
    private boolean DEFAULT_WRITABLE = false;
    
    // constructeurs
    public Retractable(Color c)
    {
        super(c);
        this.writable = this.DEFAULT_WRITABLE;
    }
    //methodes
    public boolean getWritable()
    {
        return this.writable;
    }
    
    
    
    @Override
    public boolean write(String txt)
    {
        if(this.getWritable())
            super.write(txt);
        return false;
    }
    
    public void showNib()
    {
        this.writable = true;
    }
    
    public void hideNib()
    {
        this.writable = false;
    }
}
