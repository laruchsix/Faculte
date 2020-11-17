/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD3_Exo_1;

/**
 *
 * @author thibault
 */
public class AutoLockedDoor extends DoorWithLock{
    
    
    // Constructuers
    public AutoLockedDoor()
    {
        super();
    }
    
    //methodes 
    @Override
    public void close()
    {
        super.close();
        super.lock();
    }
    
    @Override
    public void print()
    {
        System.out.print("AutoLockedDoor : is open"+ getIsOpen() + "; is locked " + getIsLocked());
    }
}
