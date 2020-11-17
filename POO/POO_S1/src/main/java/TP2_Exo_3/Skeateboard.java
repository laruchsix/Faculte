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
public class Skeateboard extends Vehicle {
    
    public Skeateboard()
    {
        super(4);
    }
    
    
    @Override
    public void specialAction(Circuit c)
    {
        super.accelerate();
    }
    
    @Override
    public void printType()
    {
        if(this.getState() == State.OK)
            System.out.println("[S]");
        else
            System.out.println("[*]");
    }
    
    @Override
    public void print()
    {
        super.print();
    }
}
