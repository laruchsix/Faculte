/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_Exo_2;

import java.awt.Color;

/**
 *
 * @author thibault
 */
public class Cartridge {
    private boolean empty; 
    private Color color;
    private int lvl;
    
    private int DEFAULT_LVL = 2000;
    private Color DEFAULT_COLOR = Color.black;
    
    // constructeurs
    public Cartridge (Color c)
    {
        this.empty = false;
        this.color = c;
        this.lvl = DEFAULT_LVL;
    }
    
    public Cartridge ()
    {
        this.empty = false;
        this.color = DEFAULT_COLOR;
        this.lvl = DEFAULT_LVL;
    }
    
    // 
    public int getLvl()
    {
        return this.lvl;
    }
    
    public boolean canUse(int n)
    {
        if(n <= this.lvl)
            return true;
        else 
            return false;
    }
    
    public void use(int n)
    {
        this.lvl -= n;
        if(this.lvl == 0)
            this.empty = true;
    }
    
    public boolean isEmpty()
    {
        return this.empty;
    }
}
