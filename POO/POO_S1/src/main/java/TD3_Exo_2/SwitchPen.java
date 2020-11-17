/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD3_Exo_2;

/**
 *
 * @author thibault
 */
public class SwitchPen extends Pen{
    
    
    public boolean write(String txt, char c1, char c2)
    {
        return super.write(txt.replace(c1, c2));
    }
    
    @Override
    public boolean write(String txt)
    {
        return this.write(txt,'a','*');
    }
}
