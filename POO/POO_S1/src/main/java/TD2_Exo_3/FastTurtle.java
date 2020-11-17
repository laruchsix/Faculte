/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD2_Exo_3;

/**
 *
 * @author thibault
 */
public class FastTurtle extends Turtle {
    // attributs
    private int nbSteps;
    
    private final int DEFAULT_NBSTEPS = 1;
    
    // constructeurs
    public FastTurtle()
    {
        super();
        this.nbSteps = this.DEFAULT_NBSTEPS;
    }
    
    public FastTurtle(int x, int y, Mode m, Orientation o, int steps)
    {
        super(x,y,m,o);
        this.nbSteps = steps;
    }
    
    // methodes
    @Override
    public void move()
    {
        // a completer
    }
    
    @Override 
    public void print()
    {
        // a completer 
    }
    
    public void setNbSteps(int nb)
    {
        this.nbSteps = nb;
    }
}
