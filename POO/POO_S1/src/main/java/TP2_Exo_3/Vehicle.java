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
public abstract class Vehicle implements Printable {
    // attributs 
    private int pos;
    private int currentSpeed;
    protected final int maxSpeed;
    private State state;
    
    private final int DEFAUlT_MAXSPEED = 250;
    private final State DEFAULT_STATE = State.OK;
    private final int DAFAULT_SPEED = 0;
    private final int DEFAULT_POS = 0; 
    // 
    public Vehicle()
    {
        this.currentSpeed = this.DAFAULT_SPEED;
        this.maxSpeed = this.DEFAUlT_MAXSPEED;
        this.pos = this.DEFAULT_POS;
        this.state = this.DEFAULT_STATE;
    }
    
    public Vehicle(int mspeed)
    {
        this.currentSpeed = this.DAFAULT_SPEED;
        this.maxSpeed = mspeed;
        this.pos = this.DEFAULT_POS;
        this.state = this.DEFAULT_STATE;
    }
    
    public void setPos(int x)
    {
        this.pos = x;
    }
    
    public State getState ()
    {
        return this.state;
    }
    
    public int getPos ()
    {
        return this.pos;
    }
    
    public int getCurrentSpeed ()
    {
        return this.currentSpeed;
    }
    
    public int getMaxSpeed()
    {
        return this.maxSpeed;
    }
    
    public void accelerate()
    { 
        if(this.getCurrentSpeed()< this.getMaxSpeed())
            this.currentSpeed ++;
    }
    
    public void decelerate()
    { 
        this.currentSpeed --;
    }
    
    public void startState()
    {
        this.pos = 0;
        this.currentSpeed = 0;
    }
    
    public void stop()
    {
        this.currentSpeed = 0;
    }
    
    public void hs()
    {
        this.stop();
        this.state = State.HS;
    }
    
    public void printType()
    {
        if(this.getState() == State.OK)
            System.out.println("[v]");
        else
            System.out.println("[*]");
    }
    
    public void printRace()
    {
        for (int i=0; i<(this.pos-1); i++)
        {
            System.out.print("-");
        }
        this.printType();
    }
    
    public void move()
    {
        this.pos += this.currentSpeed;
    }
    
    public void specialAction(Circuit c)
    {
        // empty 
    }
    
    public void print()
    {
        System.out.print("\n" + this.getClass().getSimpleName() +
                " ma vitesse max est "+ this.maxSpeed + 
                ", ma vitesse actuelle est de " + this.currentSpeed +
                ", ma position est " + this.pos + 
                ", mon etat est " + this.state);
    }
}
