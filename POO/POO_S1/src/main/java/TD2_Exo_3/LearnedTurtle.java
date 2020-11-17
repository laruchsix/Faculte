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
public class LearnedTurtle extends Turtle implements Printable {
    private int nbMoves;
    
    private int DEFAULT_NBMOVES = 0;
    
    // constructeurs
    public LearnedTurtle ()
    {
        super(); 
        this.nbMoves = this.DEFAULT_NBMOVES = 0;
    }
    
    public LearnedTurtle(int x, int y, Mode m, Orientation o)
    {
        super(x,y,m,o); 
        this.nbMoves = this.DEFAULT_NBMOVES;
    }  
    
    @Override
    public void move()
    {
        super.move();
        this.nbMoves++;
    }
    
    @Override
    public void print()
    {
        // a complete
    }
    
    public void write(String txt)
    {
        // a complter
    }
}
