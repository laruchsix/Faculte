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
public class SecretCodeDoor extends AutoLockedDoor {
    // attributs
    private int code;
    private int DEFAULT_CODE = 0000; 
    
    // constructeur(s)
    public SecretCodeDoor()
    {
        super();
        this.code = DEFAULT_CODE;
    }
    
    public SecretCodeDoor(int pass)
    {
        super();
        this.code = pass;
    }
    
    //methodes 
    @Override
    public void open()
    {
    }
    
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
}
