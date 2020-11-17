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
public class TwinPen extends Pen {
    private Pen secondePen; 
    
    public TwinPen(Color c1, Color c2)
    {
        super(c1);
        this.secondePen = new Pen(c2);
    }
    
    public TwinPen()
    {
        super();
        this.secondePen = new Pen(Color.red);
    }
    
    public boolean writeFirstPen (String txt)
    {
        super.write(txt);
        return false;
    }
    
   public boolean writeSecondPen (String txt)
   {
       return this.secondePen.write(txt);
   }
   
}
