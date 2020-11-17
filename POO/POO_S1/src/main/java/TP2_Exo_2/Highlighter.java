/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_Exo_2;

import TD3_Exo_2.*;

/**
 *
 * @author thibault
 */
public class Highlighter extends Pen {
    // constructeur
    public Highlighter()
    {
        super();
    }
    public boolean highlight(String txt)
    {
        return super.write(txt.toUpperCase());
    }
}
