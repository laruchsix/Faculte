/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_Exo_1;

import java.util.ArrayList;

/**
 *
 * @author thibault
 */
public class Main {
    public static void main(String[] args)
    {
    ArrayList<Door> doors = new ArrayList<>();
    
    Door d1 = new Door();
    Door d2 = new DoorWithLock();
    Door d3 = new ClosedDoor();
    Door d4 = new AutoLockedDoor();
    Door d5 = new SecretCodeDoor();
    
    
    doors.add(d1);
    doors.add(d2);
    doors.add(d3);
    doors.add(d4);
    doors.add(d5);
    
    ((AutoLockedDoor)doors.get(3)).unlock();
    
    for( Door d : doors )
    {
        if( d instanceof SecretCodeDoor)
            ((SecretCodeDoor)d).open(0000);
        else
            d.open();
    }
    
   doors.get(0).printDoorList(doors);
    
    
    }
}
