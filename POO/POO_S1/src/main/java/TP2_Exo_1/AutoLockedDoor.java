/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_Exo_1;


/**
 *
 * @author thibault
 */
public class AutoLockedDoor extends DoorWithLock{
    
    
    // Constructuers
    public AutoLockedDoor()
    {
        super();
        this.isLocked = true;
    }
    
    //methodes 
    @Override
    public void close()
    {
        super.close();
        super.lock();
    }
    
    
}
