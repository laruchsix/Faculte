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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circuit c1 = new Circuit(12);
        
        Vehicle v1 = new Skeateboard();
        Vehicle v2 = new Tank();
        Vehicle v3 = new Car();
        Vehicle v4 = new Tank();
        
        c1.addVehicle(v1);
        c1.addVehicle(v2);
        c1.addVehicle(v3);
        c1.addVehicle(v4);
        
        c1.startRace();
    }
    
}
