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
public class Location implements Printable{
    // attributs
    private int x;
    private int y;
    
    private final int DEFAULT_X = 0;
    private final int DEFAULT_Y = 0;
    
    // constructeurs
    public Location()
    {
        this.x = this.DEFAULT_X;
        this.y = this.DEFAULT_Y;
    }
    
    public Location(int xx, int yy)
    {
        this.x = xx;
        this.y = yy;
    }
        
    //méthodes
    public int getx()
    {
        return this.x;
    }
    
    public int gety()
    {
        return this.y;
    }
    
    public void print()
    {
        System.out.println("x ="+ this.x+" ; y = "+this.y);
    }
}
