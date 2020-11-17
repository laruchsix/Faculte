/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_Exo_3;

/**
 *
 * @author thibault
 */
public class Tank extends Vehicle{
    // attributs
    private int nbRokets;
    
    private final int DEFAULT_NBROKETS = 1;
    
    
    // constructeurs
    public Tank()
    {
        super(2);
        this.nbRokets = this.DEFAULT_NBROKETS;
    }
    
    // methodes 
    public int getNbRockets()
    {
        return this.nbRokets;
    }
    
    public void useRoket()
    {
        this.nbRokets --;
    }
    
    public void shoot(Vehicle v)
    {
        super.stop();
        if(this.getNbRockets() > 0)
        {
            if(v instanceof Tank)
                v.stop();
            else 
                v.hs();
            this.useRoket();
        }
    }
    
    @Override
    public void specialAction(Circuit c)
    {
        Vehicle v = c.choseOtherVehicle(this);
        if(v!= null)
            shoot(v);
    }
    
    @Override
    public void printType()
    {
        if(this.getState() == State.OK)
            System.out.println("[T]");
        else
            System.out.println("[*]");
    }
    
    @Override
    public void print()
    {
        super.print();
        System.out.print(", je possède " + this.nbRokets + " rockets"); 
    }
}
