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
public class MultiColorPen extends Retractable {
    
    
    public MultiColorPen (Color c )
    {
        super(c); 
    }
    
    public void changeColor(Color c)
    { 
        super.replaceCartridge(c);
    }
}
