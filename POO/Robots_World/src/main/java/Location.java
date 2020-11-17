
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trucher
 */
public class Location {
    // 
    private final int x;
    private final int y;
    private final int DEFAULT_X = -1;
    private final int DEFAULT_Y = -1;
    
    
    // constructeurs
    public Location()
    {
        this.x = this.DEFAULT_X;
        this.y = this.DEFAULT_Y;
    }
    
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y; 
    }
    
    // 
    public static List<Location> generate (int x_max , int y_max)
    {
        List<Location> mylist = new ArrayList<>(); 
        for(int i=1; i<=y_max;i++)
        {
            for(int j=1; j<=x_max; j++)
            {
                mylist.add(new Location(i,j));
            }
        }
        return mylist; 
    }
    
    public void print()
    {
        System.out.print("{ "+ this.x + "; " + this.y + " }");
    }
    
}
