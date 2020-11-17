/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_Exo_3;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author thibault
 */
public class Circuit implements Printable{
    // attributs
    private int longueur;
    private ArrayList<Vehicle> vehicle = new ArrayList<>();
    
    // construteur
    public Circuit(int len)
    {
        this.longueur = len;
    }
    
    // methodes 
    public void addVehicle(Vehicle c)
    {
        this.vehicle.add(c);
    }
    
    public void initRace()
    {
        for(Vehicle c : this.vehicle)
        {
            c.startState();
        }
    }
    
    public void startRace()
    {
        // initialisation de la course
        this.initRace(); 
        
        do
        {
            round();
            System.out.print("\n\n\n\n\n\n");
            this.print();
            System.out.print("\n\n\n\n\n\n");
        }while(isFinishedRace() == -1 );
        printState();
        int var = isFinishedRace();
        if(var == -2)
           this.allVehicleHS();
        else 
           this.endMSG(var);
        
    }
    
    public void printState()
    {
        for(Vehicle v : this.vehicle)
        {
            v.printRace();
        }
    }
    
    
    
    public int isFinishedRace()
    {
        int a = -2;
        for( Vehicle c : this.vehicle)
        {
            if(c.getPos() >= this.longueur)
                   return this.vehicle.indexOf(c);
            else
                if(c.getState() != State.HS)
                    a = -1;
        }
        return a;
    }
    
    public void allVehicleHS()
    {
        System.out.println("Tous les vehicules sont hs !");
    }
    
    public void endMSG(int i)
    {
       System.out.println(this.vehicle.get(i).getClass().getSimpleName() + " a gagné la course !!!! ");
    }
    
    public Vehicle choseVehicle ()
    {
        Random rand = new Random();
        int len = this.vehicle.size();
        if(len == 0)
            return null;
        else
            return this.vehicle.get(rand.nextInt(len));
    }
    
    public void allActions()
    {
        for( Vehicle v : this.vehicle)
        {
            v.printRace();
            if(v.getState() != State.HS)
            {
                v.accelerate();
                v.move();
            }
        }
    }
    
    public void round()
    {
        this.allActions();
        Vehicle v = choseVehicle();
        v.specialAction(this);
    }
    
    public int verifState()
    {
        int i=0;
        for( Vehicle v : this.vehicle)
        {
            if(v.getState() == State.OK)
                i++;
        }
        return i;
    }
    
    public Vehicle choseOtherVehicle(Vehicle v)
    {
        // on verrifie qu'il n'y a pas que la tank qui roule encore sur la poste
        int usable = this.verifState();
        if (usable > 1)
        {
            Random rand = new Random();
            Vehicle vn;
            do 
            {
                vn = this.vehicle.get(rand.nextInt(this.vehicle.size()));
            
            }while( v == vn);
            return vn;
        }
        else 
            return null;
    }
    
    public void print()
    {
        System.out.print(this.getClass().getSimpleName() + " d'une longueur "+ this.longueur + " voici des vehicles du circuit :");
        for ( Vehicle v : this.vehicle)
        {
            v.print();
        }
    }
}
