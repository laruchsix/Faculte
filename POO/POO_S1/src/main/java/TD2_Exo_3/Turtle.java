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
public class Turtle {
    // attributs 
    private Orientation orient;
    private Mode mode;
    private Location location;
    
    private final Color DEFAULT_COLOR = Color.BLACK;
    
    //contructeurs
    public Turtle()
    {
        this.location = new Location();
        
    }
    
    public Turtle(int x, int y, Mode m, Orientation o)
    {
        this.location = new Location(x,y);
        this.mode = m;
        this.orient = o;
    }
    
    
    // methodes
    public Mode getmode()
    {
        return this.mode;
    }
    
    public Location getLocation()
    {
        return this.location;
    }
    
    public Orientation getOrient()
    {
        return this.orient;
    }
    
    public void move()
    {
        // a completer
    }
    
    public void turn()
    {
        switch (this.orient){
            case NORTH : 
                this.orient = Orientation.EAST;
                break;
            case EAST : 
                this.orient = Orientation.SOUTH;
                break;
            case SOUTH : 
                this.orient = Orientation.WEST;
                break;
            case WEST : 
                this.orient = Orientation.NORTH;
                break;
        }
            
    }
    
    public void print()
    {
        // a completer
    }
    
    public void switchMode()
    {
        if(getmode() == Mode.TRACE)
            this.mode = Mode.NO_TRACE;
        else
            this.mode = Mode.TRACE;
    }
}
