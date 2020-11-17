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
public class Car extends Vehicle{
    
    public Car ()
    {
        super(8);
    }
    
    @Override
    public void accelerate()
    {
        super.accelerate();
        super.accelerate();
    }
    
    @Override
    public void specialAction(Circuit c)
    {
        super.decelerate();
    }
    
    @Override
    public void printType()
    {
        if(this.getState() == State.OK)
            System.out.println("[C]");
        else
            System.out.println("[*]");
    }
    
    @Override
    public void print()
    {
        super.print();
    }
}
