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
public class CodeLockDoor extends AutoLockedDoor {
    // attributs
    private int code;
    private int DEFAULT_CODE = 0000; 
    
    // constructeur(s)
    public CodeLockDoor()
    {
        super();
        this.code = DEFAULT_CODE;
    }
    
    public CodeLockDoor(int pass)
    {
        super();
        this.code = pass;
    }
    
    //methodes 
    
    // surcharge 
    public void open(int pass)
    {
        if(pass == this.code)
            super.open(); 
    }
    
    public int getCode()
    {
        return this.code;
    }
    
    @Override
    public void print()
    {
        super.print();
        System.out.print("; code = " + this.code);
    }
}
