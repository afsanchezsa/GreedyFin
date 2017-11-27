/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author COMPAQ
 */
public class Boton extends JLabel{
    public Boton(String texto){
     //super(texto);
       // setFont(new Font("Arial",Font.PLAIN,30)); 
        //setText(texto);
    
   setBorder(new RoundedBorder(10));
        setSize(300,400);
setIcon(new ImageIcon("texto"+".jpg"));
//setMargin(new Insets(0,0,0,0));
        setIconTextGap(0);
        //setBorderPainted(false);
        setText("Hola");
    }
}
