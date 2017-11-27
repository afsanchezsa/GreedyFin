/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFrame;

/**
 *
 * @author COMPAQ
 */
public class Marco extends JFrame{
    public Marco(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(400,300);
     add(new Menu());
     setVisible(true);
    }
   
}
