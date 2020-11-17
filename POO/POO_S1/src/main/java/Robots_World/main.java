package Robots_World;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thibault
 */
public class main {
    public static void main(String[] args)
    {
        World m = new World("Narnia");
        m.addRobot("toshi");
        m.addRobot("tic");
        m.addRobot("tac");
        m.addRobot("bob");
        m.addRobot("boby");
        m.display();   
    }
}
