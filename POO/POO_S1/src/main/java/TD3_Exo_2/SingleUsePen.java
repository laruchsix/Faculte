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
public class SingleUsePen extends Pen {
    
    //constructeurs
    public SingleUsePen(Color c)
    {
        super(c);
    }
    
    public SingleUsePen()
    {
        super();
    }
    
    //methodes 
    @Override
    public void replaceCartridge(Color c)
    {
        super.cartridge = null; 
        super.canWrite = false;
    }
}
