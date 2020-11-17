/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD2_Exo_3;

import java.awt.Color;

/**
 *
 * @author thibault
 */
public class ColoredTurtle extends Turtle implements Printable{
    // attributs
    private Color color;
    
    private final Color DEFAULT_COLOR = Color.blue;
    // constructeurs
    public ColoredTurtle()
    {
        super();
        this.color = this.DEFAULT_COLOR;
    }
    
    public ColoredTurtle(int x, int y, Mode m, Orientation o, Color c)
    {
        super(x,y,m,o);
        this.color = c;
    }
    
    @Override
    public void move()
    {
        // a completer
    }
    
    public void setColor(Color c)
    {
        this.color = c;
    }
    
    public void print(String txt)
    {
        // a completer
    }
}
