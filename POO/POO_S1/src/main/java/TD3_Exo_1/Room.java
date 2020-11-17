 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD3_Exo_1;

import java.util.ArrayList;

/**
 *
 * @author thibault
 */
public class Room {
    // agrégation avec les Door
    private String name;
    private ArrayList<Door> doors ;
    
    private String DEFAULT_NAME = "toto";
    // constructeurs
    public Room()
    {
        this.name = DEFAULT_NAME;
        this.doors = new ArrayList<>();
        doors.add(new Door());
        doors.add(new CodeLockDoor());
        doors.add(new DoorLockedOut());
        doors.add(new DoorWithLock());
        doors.add(new AutoLockedDoor());
    }
    
    public void openAll()
    {
        for(Door bDoor : this.doors)
        {
            if(bDoor instanceof CodeLockDoor)
                ((CodeLockDoor)bDoor).open(((CodeLockDoor)bDoor).getCode());
            else
                bDoor.open();
        }
    }
    
    
}
